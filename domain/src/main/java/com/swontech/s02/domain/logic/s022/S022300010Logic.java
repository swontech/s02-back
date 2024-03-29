/****************************************************
 * program : 비용진행현황 및 비용상세처리 (S022300010)
 * desc :
 * 1) 운영자, 회계 담당자가 비용요청 진행 전체 대상 List 조회
 * 2) 비용지급 처리 : 회계 담당자가 비용지급 처리 내용을 등록처리
 ****************************************************/
package com.swontech.s02.domain.logic.s022;

import com.swontech.s02.domain.logic.comm.PushNotificationLogic;
import com.swontech.s02.domain.dto.comm.CustomResponse;
import com.swontech.s02.domain.dto.s022.S0221A0090Dto;
import com.swontech.s02.domain.dto.s022.S022300010Dto;
import com.swontech.s02.domain.spec.s022.S022300010Spec;
import com.swontech.s02.domain.store.s022.S0221A0090Store;
import com.swontech.s02.domain.store.s022.S022300010Store;
import com.swontech.s02.domain.vo.s022.S022300010Vo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class S022300010Logic implements S022300010Spec {
    private final CustomResponse response;
    private final S022300010Store s022300010Store;
    private final PushNotificationLogic pushNotificationLogic;
    private final S0221A0090Store s0221A0090Store;

    private final Logger logger = LoggerFactory.getLogger(S022300010Logic.class);

    public S022300010Logic(CustomResponse response, S022300010Store s022300010Store, PushNotificationLogic pushNotificationLogic, S0221A0090Store s0221A0090Store) {
        this.response = response;
        this.s022300010Store = s022300010Store;
        this.pushNotificationLogic = pushNotificationLogic;
        this.s0221A0090Store = s0221A0090Store;
    }

    @Override
    public ResponseEntity<?> retrieveCostPayProTotList(S022300010Dto.RetrieveCostPayList reqDto) {
        return response.success(s022300010Store.selectCostPayProTotList(
                S022300010Vo.ParamsVo
                        .builder()
                        .memberName(reqDto.getMemberName())
                        .fromUsedDate(reqDto.getFromUsedDate())
                        .toUsedDate(reqDto.getToUsedDate())
                        .namePathPriortiy(reqDto.getNamePathPriortiy())
                        .useProStatus(reqDto.getUseProStatus())
                        .orgId(reqDto.getOrgId())
                        /*2022.11.02 kjy paging*/
                        .column(reqDto.getColumn())
                        .order(reqDto.getOrder())
                        .limit(reqDto.getLimit())
                        .curPage(reqDto.getCurPage())
                        .build()
        ));
    }

    @Override
    public ResponseEntity<?> retrieveCostPayProTotDetail(int eventUsedId) {
        Map<String, Object> returnMap = new HashMap<String, Object>();
        returnMap.put("head", s022300010Store.selectCostPayProTotDetailHead(eventUsedId));
        returnMap.put("line", s022300010Store.selectCostPayProTotDetailLine(eventUsedId));

        return response.success(returnMap);
    }

    /* 비용지급 처리 : 회계 담당자가 비용지급 처리 내용을 등록처리
     * 1.해당 행사비용의 지급 상태 변경 : tb_s020_event030의 진행 상태 update
     * 2.행사비용 이력 등록 : tb_s020_event040 해당 행사비용 정보 insert
     * */
    @Override
    public ResponseEntity<?> registerCostPay(S022300010Dto.RegisterCostPayReqDto reqDto) {
        int result = 0;
        logger.info("[S022300010] 비용지급처리 : " + reqDto.getEventUseId());

        //1.tb_s020_event030 진행상태 update
        result = s022300010Store.updateCostPayProgressStatus(reqDto.getEventUseId());

        logger.info("[S022300010] 비용지급처리 : 진행상태변경 => " + result);

        if (result > 0) {
            //2.tb_s020_event040 이력 insert
            S022300010Vo.RegisterCostPayReqVo registerVo = S022300010Vo.RegisterCostPayReqVo.builder()
                    .eventUseId(reqDto.getEventUseId())
                    .payMemberId(reqDto.getPayMemberId()).build();
            result = s022300010Store.insertCostPayHistory(registerVo);

            logger.info("[S022300010] 비용지급처리 : 이력등록 => " + result);

            if (result > 0) {
                // 푸시알림 발송
                S0221A0090Dto.AppPushUser appPushUser = s0221A0090Store.selectAppPushUser(reqDto.getEventUseId());
                if (appPushUser != null) {
                    String sendToken = null;
                    String sendBody = "";
                    if (appPushUser.getUseProStatus().equals("D")) {
                        sendToken = appPushUser.getReqToken();
                        sendBody = appPushUser.getReqUserName() + "님이 요청하신 비용이 지급되었습니다.";
                    }
                    if (sendToken != null) {
                        pushNotificationLogic.sendPushNotification(sendToken, "", sendBody);
                    }
                }
                return response.success(registerVo.getEventUsePayId(), "비용지급처리 등록에 성공했습니다.", HttpStatus.OK);
            }
        }
        return response.fail("비용지급처리 등록에 실패했습니다.", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /*비용지금 이력 등록*/
    @Override
    public ResponseEntity<?> registerCostPayHistory(S022300010Dto.RegisterCostPayReqDto reqDto) {
        S022300010Vo.RegisterCostPayReqVo registerVo = S022300010Vo.RegisterCostPayReqVo.builder()
                .eventUseId(reqDto.getEventUseId())
                .payMemberId(reqDto.getPayMemberId()).build();
        int result = s022300010Store.insertCostPayHistory(registerVo);
        if (result > 0) {
            return response.success(registerVo.getEventUsePayId(), "비용지급처리 등록에 성공했습니다.", HttpStatus.OK);
        }
        return response.fail("비용지급처리 등록에 실패했습니다.", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /*비용지금 진행상태 update */
    @Override
    public ResponseEntity<?> patchCostPayProgressStatus(int eventUsedId) {
        int result = s022300010Store.updateCostPayProgressStatus(eventUsedId);
        return response.success("비용지급 상태 수정에 성공했습니다.");
    }

    @Override
    public ResponseEntity<?> excelCostPayTotalHead(S022300010Dto.ExcelParamsReqDto reqDto) {
        return response.success(s022300010Store.excelCostPayTotalHead(
                S022300010Vo.ExcelParamsVo.builder()
                        .fromUsedDate(reqDto.getFromUsedDate())
                        .toUsedDate(reqDto.getToUsedDate())
                        .idPathPriortiy(reqDto.getIdPathPriortiy()).build())
        );
    }

    @Override
    public ResponseEntity<?> excelCostPayTotalLine(S022300010Dto.ExcelParamsReqDto reqDto) {
        return response.success(s022300010Store.excelCostPayTotalLine(
                S022300010Vo.ExcelParamsVo.builder()
                        .fromUsedDate(reqDto.getFromUsedDate())
                        .toUsedDate(reqDto.getToUsedDate())
                        .idPathPriortiy(reqDto.getIdPathPriortiy()).build())
        );
    }

    /*2023.02.27 재정청구서 엑셀*/
    @Override
    public ResponseEntity<?> excelExcelOjicFinBillUpload(S022300010Dto.ExcelParamsReqDto reqDto) {
        return response.success(s022300010Store.excelExcelOjicFinBillUpload(
                S022300010Vo.ExcelParamsVo.builder()
                        .fromUsedDate(reqDto.getFromUsedDate())
                        .toUsedDate(reqDto.getToUsedDate())
                        .idPathPriortiy(reqDto.getIdPathPriortiy()).build())
        );
    }

}
