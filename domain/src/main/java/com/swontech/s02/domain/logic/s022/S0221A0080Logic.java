package com.swontech.s02.domain.logic.s022;

import com.swontech.s02.domain.dto.comm.CustomResponse;
import com.swontech.s02.domain.dto.s022.S0221A0080Dto;
import com.swontech.s02.domain.spec.s022.S0221A0080Spec;
import com.swontech.s02.domain.store.s022.S0221A0080Store;
import com.swontech.s02.domain.vo.s022.S0221A0080Vo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Slf4j
public class S0221A0080Logic implements S0221A0080Spec {
    private final CustomResponse response;
    private final S0221A0080Store s0221A0080Store;
    public S0221A0080Logic(CustomResponse response, S0221A0080Store s0221A0080Store) {
        this.response = response;
        this.s0221A0080Store = s0221A0080Store;
    }

    @Override
    public ResponseEntity<?> retrieveCostReqDetail(int eventUseId) {
        S0221A0080Dto.CostReqDetailHeader header = s0221A0080Store.selectCostReqDetailHeader(eventUseId);
        if(header == null) {
            return response.fail("등록된 행사비용 사용 내역이 없습니다.", HttpStatus.BAD_REQUEST);
        }
        return response.success(
            S0221A0080Dto.CostReqDetailResponse
                    .builder()
                        .header(header)
                        .detail(s0221A0080Store.selectCostReqDetailTail(eventUseId))
                    .build()
        );
    }

    @Override
    public ResponseEntity<?> processingCostReq(S0221A0080Dto.ProcessingCostReqDto reqDto) {
        try {
            /** variables */
            int payStepCnt;                 // 전체 결제 진행 단계
            int currentPayCurrentStep;      // 현재 결제 진행 단계
            int nextPayCurrentStep;         // 현재 결제 진행 단계의 다음 단계(currentPayCurrentStep + 1)
            String currentUseProStatus;     // 현재 결제 진행 상태
            String nextUseProStatus;        // update될 결제 진행 상태


            /** *******************************************
             *  eventUseId의 현재결제진행정보tb_s020_event030를 가져온다.
             *  ******************************************* */
            S0221A0080Dto.SelectCostReqCurrInfoDto currentInfo = s0221A0080Store.selectCostReqCurrInfo(reqDto.getEventUseId());
            if(currentInfo == null) {
                return response.fail("등록된 비용요청 정보가 없습니다.", HttpStatus.BAD_REQUEST);
            } else {
                payStepCnt = currentInfo.getPayStepCnt();
                currentPayCurrentStep = currentInfo.getPayCurrentStep();
                nextPayCurrentStep = currentPayCurrentStep + 1;
                currentUseProStatus = currentInfo.getUseProStatus();
            }

            /** *******************************************
             *  결제내역 정보를 tb_s020_event040에 insert한다.
             *  ******************************************* */
            int insertResult = s0221A0080Store.insertCostReqProcess(
                S0221A0080Vo.InsertCostReqProcessVo
                    .builder()
                            .eventUseId(reqDto.getEventUseId())
                            .payCurrentStep(reqDto.getPayCurrentStep())
                            .payMemberId(reqDto.getMemberId())
                            .payResultFlag(reqDto.getPayResultFlag())
                            .payComment(reqDto.getPayComment())
                    .build());
            if(insertResult < 1) {
                return response.fail("결제내역정보를 Insert 하는 중 오류가 발생했습니다", HttpStatus.INTERNAL_SERVER_ERROR);
            }


            /** case 1.승인처리인 경우  *
             *  pay_result_flag = Y */
            if("Y".equals(reqDto.getPayResultFlag())) {
                /** ===============================================================================
                 * 1-1. 현재 행사비용진행상태(useProStatus) 비용요청인지 결제진행인지 반려상태인지 본다
                 * --------------------------------------------------------------------------------
                 *  useProStatus    = A(비용요청) : 최초 비용등록시 아무 결제도 이뤄지지 않은 상태.
                 *                    B(결제진행) : 최소 하나의 결제가 이뤄진 상태지만 결제완료는 아닌상태.
                 *                    C(결제완료) : 전체 결제 진행 Process를 모두 완료한 상태.
                 *                    D(지급완료) : 전체 결제 진행 Process를 모두 완료하고 지급까지 완료된 상태.
                 *                    E(결제반려) : 결제가 반려된 상태.
                 *                    F(요청취소) : 비용요청등록자가 비용요청을 취소한 상태.
                 *  --------------------------------------------------------------------------------
                 *  payStepCnt      = 전체 결제진행 단계
                 *  --------------------------------------------------------------------------------
                 *  payCurrentStep  = 현재 결제진행상태
                 *  --------------------------------------------------------------------------------
                 * */
                switch (currentUseProStatus) {
                    // 현재 결제 진행상태가 비용요청상태인 경우 전제결제진행단계가 현재결제진행상태의 다음단계와 같다면
                    // 최종결제완료(C)로 상태를 update하지만
                    // 그렇지 않다면 결제진행상태(B)로 update한다.
                    case "A":
                        if(payStepCnt == nextPayCurrentStep) {
                            nextUseProStatus = "C";    // 최종 결제완료
                        } else {
                            nextUseProStatus = "B";    // 진행 중 결제완료
                        }
                        break;

                    // 현재 결제 진행상태가 진행상태(B)인 경우 전제결제진행단계가 현재결제진행상태의 다음단계와 같다면
                    // 최종결제완료(C)로 상태를 update하지만
                    // 그렇지 않다면 결제진행상태(B)로 유지한다.
                    case "B":
                        if(payStepCnt == nextPayCurrentStep) {
                            nextUseProStatus = "C";                 // 최종 결제 완료
                        } else {
                            nextUseProStatus = currentUseProStatus; // 현상태로 유지
                        }
                        break;

                    // 현재 결제 진행상태가 반려상태(E)인 경우 전제결제진행단계가 현재결제진행상태의 다음단계와 같다면
                    // 최종결제완료(C)로 상태를 update하지만
                    // 그렇지 않다면 결제진행상태(B)로 유지한다.
                    case "E":
                        if(payStepCnt == nextPayCurrentStep) {
                            nextUseProStatus = "A";    // 비용요청
                        } else {
                            nextUseProStatus = "C";    // 최종결제완료
                        }
                        break;
                    default:
                        // case C(결제완료)/D(지급완료)/F(요청취소)
                        return response.fail("비용요청의 현재 진행상태가 바용승인 Process를 진행하기에 적합하지 않은 상태입니다. 현재 진행상태:" + currentUseProStatus, HttpStatus.BAD_REQUEST);
                }
                // update처리
                s0221A0080Store.updateCostReqProcess(S0221A0080Vo.UpdateCostReqProcessVo
                   .builder()
                            .eventUseId(reqDto.getEventUseId())
                            .payCurrentStep(nextPayCurrentStep)
                            .useProStatus(nextUseProStatus)
                   .build()
                );


            /** case 1.반려처리인 경우  *
             *  pay_result_flag = N */
            } else if("N".equals(reqDto.getPayResultFlag())) {
                s0221A0080Store.updateCostReqProcess(S0221A0080Vo.UpdateCostReqProcessVo
                        .builder()
                                .eventUseId(reqDto.getEventUseId())
                                .payCurrentStep(0)              // 현재 결제진행 단계: 초기(0)
                                .useProStatus("E")              // 현재 결제진행 상태: 반려상태(E)
                        .build()
                );
            }
            return response.success("비용처리가 성공적으로 완료되었습니다.");
        } catch (Exception e) {
            log.error(e.getMessage());
            return response.fail("비용처리가 Process를 진행하는 중 오류가 발생했습니다.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
