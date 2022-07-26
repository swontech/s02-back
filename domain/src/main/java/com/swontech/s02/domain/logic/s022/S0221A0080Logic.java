package com.swontech.s02.domain.logic.s022;

import com.swontech.s02.domain.dto.comm.CustomResponse;
import com.swontech.s02.domain.dto.s022.S0221A0080Dto;
import com.swontech.s02.domain.spec.s022.S0221A0080Spec;
import com.swontech.s02.domain.store.s022.S0221A0080Store;
import com.swontech.s02.domain.vo.s022.S0221A0080Vo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public class S0221A0080Logic implements S0221A0080Spec {
    private final CustomResponse response;
    private final S0221A0080Store s0221A0080Store;
    public S0221A0080Logic(CustomResponse response, S0221A0080Store s0221A0080Store) {
        this.response = response;
        this.s0221A0080Store = s0221A0080Store;
    }

    @Override
    public ResponseEntity<?> retrieveCostReqDetail(int eventUseId) {
        return response.success(s0221A0080Store.selectCostReqDetail(eventUseId));
    }

    @Override
    public ResponseEntity<?> processingCostReq(S0221A0080Dto.ProcessingCostReqDto reqDto) {
        /** tb_s020_event040 insert */
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
            return response.fail("데이터를 Insert 하는 중 실패했습니다", HttpStatus.INTERNAL_SERVER_ERROR);
        }


        /** tb_s020_event030 update */
        Map<String, Object> costReqInfo = s0221A0080Store.selectCostReqInfo(reqDto.getEventUseId());
        if(costReqInfo == null) {
            return response.fail("데이터를 Update하는 중 실패했습니다.", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        int payCurrentStep = (int)costReqInfo.get("PAY_CURRENT_STEP");
        int payStepCnt = (int)costReqInfo.get("PAY_STEP_CNT");
        String useProStatus = (String)costReqInfo.get("USE_PRO_STATUS");

        String paramUseProStatus = null;
        int updateResult = 0;

        /** 1.승인처리인 경우 */
        if("Y".equals(reqDto.getPayResultFlag())) {
            /** 1-1. 현재 진행상태(useProStatus) 비용요청인지 결제진행인지 반려상태인지 본다 */
            switch (useProStatus) {
                case "A":   // 비용요청상태인 경우
                    if(payStepCnt == payCurrentStep + 1) {
                        paramUseProStatus = "C";    // 최종 결제완료
                    } else {
                        paramUseProStatus = "B";    // 진행 중 결제완료
                    }
                    break;
                case "B":   // 결제상태인 경우
                    if(payStepCnt == payCurrentStep + 1){
                        paramUseProStatus = "C";    // 최종 결제 완료
                    }
                    break;
                case "E":   // 반려상태인 경우
                    if(payStepCnt == payCurrentStep + 1){
                        paramUseProStatus = "A";    // 비용요청
                    } else {
                        paramUseProStatus = "C";    // 최종 결제 완료
                    }
                    break;
                default:
                    return response.fail("조회된 useProStatus가 올바르지 않습니다.", HttpStatus.MULTI_STATUS);
            }

            if(paramUseProStatus == null) {
                return response.fail("비용처리를 Update하는 중 오류가 발생했습니다.", HttpStatus.INTERNAL_SERVER_ERROR);
            }
            updateResult = s0221A0080Store.updateCostReqProcess(S0221A0080Vo.UpdateCostReqProcessVo
               .builder()
                        .eventUseId(reqDto.getEventUseId())
                        .payCurrentStep(payCurrentStep)
                        .useProStatus(paramUseProStatus)
               .build()
            );

        /** 2.반려처리인 경우 */
        } else if("N".equals(reqDto.getPayResultFlag())) {
            updateResult = s0221A0080Store.updateCostReqProcess(S0221A0080Vo.UpdateCostReqProcessVo
                    .builder()
                            .eventUseId(reqDto.getEventUseId())
                            .payCurrentStep(0)
                            .useProStatus("E")
                    .build()
            );
        }

        if(updateResult < 1) {
            return response.fail("데이터를 Update 하는 중 실패했습니다", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response.success("비용처리가 성공적으로 완료되었습니다.");
    }
}
