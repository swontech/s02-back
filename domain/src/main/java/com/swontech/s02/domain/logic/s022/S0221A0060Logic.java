package com.swontech.s02.domain.logic.s022;

import com.swontech.s02.domain.logic.comm.PushNotificationLogic;
import com.swontech.s02.domain.dto.comm.CustomResponse;
import com.swontech.s02.domain.dto.s022.S0221A0060Dto;
import com.swontech.s02.domain.dto.s022.S0221A0090Dto;
import com.swontech.s02.domain.spec.comm.S3BucketSpec;
import com.swontech.s02.domain.spec.s022.S0221A0060Spec;
import com.swontech.s02.domain.store.s022.S0221A0060Store;
import com.swontech.s02.domain.store.s022.S0221A0090Store;
import com.swontech.s02.domain.vo.s022.S0221A0060Vo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class S0221A0060Logic implements S0221A0060Spec {
    private final S0221A0060Store s0221A0060Store;
    private final CustomResponse response;
    private final S3BucketSpec s3BucketSpec;
    private final PushNotificationLogic pushNotificationLogic;
    private final S0221A0090Store s0221A0090Store;

    public S0221A0060Logic(S0221A0060Store s0221A0060Store, CustomResponse response, S3BucketSpec s3BucketSpec, PushNotificationLogic pushNotificationLogic, S0221A0090Store s0221A0090Store) {
        this.s0221A0060Store = s0221A0060Store;
        this.response = response;
        this.s3BucketSpec = s3BucketSpec;
        this.pushNotificationLogic = pushNotificationLogic;
        this.s0221A0090Store = s0221A0090Store;
    }

    @Override
    public ResponseEntity<?> selectEventCost(Integer eventUseId) {
        Map<String, Object> data = new HashMap<>();

        data.put("header", s0221A0060Store.selectEventCostHeader(eventUseId));
        data.put("detail", s0221A0060Store.selectEventCostDetail(eventUseId));

        return response.success(data);
    }

    @Override
    public ResponseEntity<?> updateEventCost(S0221A0060Dto.UpdateEventCostDto eventCostDto) {

        try {
            if ("N".equals(s0221A0060Store.selectAvailableFlag(eventCostDto.getEventUseId())))
                return response.success("이미 지급이 완료된 건으로 수정이 불가합니다.");

            /** base64String이 빈 값이면 수정이 아니므로 기존 receiptId로 update
             base64String이 빈 값이 아니라면 수정이므로 기존 receiptId로 update */
            String receiptId = eventCostDto.getUseReceiptId();
            if (!"".equals(eventCostDto.getBase64String())) {
                s3BucketSpec.delete(receiptId, "event");                                    // <-- 기존 파일 삭제
                receiptId = s3BucketSpec.upload(eventCostDto.getBase64String(), "event");   // <-- 새 이미지 등록
            }

            int result = s0221A0060Store.updateEventCost(S0221A0060Vo.UpdateEventCostVo
                    .builder()
                    .eventId(eventCostDto.getEventId())
                    .eventUserId(eventCostDto.getEventUserId())
                    .usedDate(eventCostDto.getUsedDate())
                    .useAmount(eventCostDto.getUseAmount())
                    .useComment(eventCostDto.getUseComment())
                    .useReceiptId(receiptId)
                    .useReceiptName(eventCostDto.getUseReceiptName())
                    .useSubject(eventCostDto.getUseSubject())
                    .eventUseId(eventCostDto.getEventUseId())
                    .build());
            if (result > 0) {
                // 푸시알림 발송
                S0221A0090Dto.AppPushUser appPushUser = s0221A0090Store.selectAppPushUser(eventCostDto.getEventUseId());
                if (appPushUser != null) {
                    if (appPushUser.getPayToken() != null) {
                        String sendBody = appPushUser.getReqUserName() + "님이 결제를 요청했습니다.";
                        pushNotificationLogic.sendPushNotification(appPushUser.getPayToken(), "", sendBody);
                    }
                }
                return response.success("행사비용등록 수정에 성공했습니다.");
            }

            return response.success("수정된 항목이 없습니다.");
        } catch (Exception e) {
            return response.fail("행사비용이 정상적으로 수정되지 않았습니다.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<?> insertEventCost(S0221A0060Dto.InsertEventCostDto eventCostDto) {
        String useProStatus = "";
        Integer payCurrentStep = null;
        int eventPayDept = 0;

        try {
            S0221A0060Dto.PayInfo payInfo = s0221A0060Store.selectPayInfo(eventCostDto.getEventId());
            if (payInfo == null) {
                return response.success("비용요청등록이 가능한 event가 아니거나 등록된 event가 없습니다.");
            }

            eventPayDept = payInfo.getEventPayDept();
            String payFlag = payInfo.getPayFlag();
            if ("N".equals(payFlag)) {
                useProStatus = "C";
                payCurrentStep = null;
            } else if ("Y".equals(payFlag)) {
                useProStatus = "A";
                payCurrentStep = 1;
            }

            String receiptId = null;
            if (!"".equals(eventCostDto.getBase64String()) && eventCostDto.getBase64String() != null) {
                receiptId = s3BucketSpec.upload(eventCostDto.getBase64String(), "event");
            }

            S0221A0060Vo.InsertEventCostVo insertEventCostVo = S0221A0060Vo.InsertEventCostVo
                    .builder()
                    .eventId(eventCostDto.getEventId())
                    .eventUserId(eventCostDto.getEventUserId())
                    .usedDate(eventCostDto.getUsedDate())
                    .useAmount(eventCostDto.getUseAmount())
                    .useComment(eventCostDto.getUseComment())
                    .useReceiptId(receiptId)
                    .useReceiptName(eventCostDto.getUseReceiptName())
                    .useSubject(eventCostDto.getUseSubject())
                    .useProStatus(useProStatus)
                    .payStepCnt(eventPayDept)
                    .payCurrentStep(payCurrentStep)
                    .build();
            s0221A0060Store.insertEventCost(insertEventCostVo);

            // 푸시알림 발송
            int newEventUseId = insertEventCostVo.getEventUseId();
            S0221A0090Dto.AppPushUser appPushUser = s0221A0090Store.selectAppPushUser(newEventUseId);
            if (appPushUser != null) {
                if (appPushUser.getPayToken() != null) {
                    String sendBody = appPushUser.getReqUserName() + "님이 결제를 요청했습니다.";
                    pushNotificationLogic.sendPushNotification(appPushUser.getPayToken(), "", sendBody);
                }
            }

            return response.success("행사비용이 정상적으로 등록되었습니다.");
        } catch (Exception e) {
            log.error(e.getMessage());
            throw e;
        }
    }

    @Override
    public ResponseEntity<?> deleteEventCost(List<Integer> eventUseIdList) {
        eventUseIdList.forEach(e -> s0221A0060Store.deleteEventCost(e));
        return response.success("행사비용이 정상적으로 삭제되었습니다.");

    }
}
