package com.swontech.s02.domain.logic.s022;

import com.swontech.s02.domain.common.exception.CustomException;
import com.swontech.s02.domain.dto.comm.CustomResponse;
import com.swontech.s02.domain.dto.s022.S0221A0060Dto;
import com.swontech.s02.domain.spec.comm.S3BucketSpec;
import com.swontech.s02.domain.spec.s022.S0221A0060Spec;
import com.swontech.s02.domain.store.s022.S0221A0060Store;
import com.swontech.s02.domain.vo.s022.S0221A0060Vo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class S0221A0060Logic implements S0221A0060Spec {
    private final S0221A0060Store s0221A0060Store;
    private final CustomResponse response;
    private final S3BucketSpec s3BucketSpec;
    public S0221A0060Logic(S0221A0060Store s0221A0060Store, CustomResponse response, S3BucketSpec s3BucketSpec) {
        this.s0221A0060Store = s0221A0060Store;
        this.response = response;
        this.s3BucketSpec = s3BucketSpec;
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
            if("N".equals(s0221A0060Store.selectAvailableFlag(eventCostDto.getEventUseId()))) return response.success("이미 지급이 완료된 건으로 수정이 불가합니다.");

            int result = s0221A0060Store.updateEventCost(S0221A0060Vo.UpdateEventCostVo
                .builder()
                    .eventId(eventCostDto.getEventId())
                    .eventUserId(eventCostDto.getEventUserId())
                    .usedDate(eventCostDto.getUsedDate())
                    .useAmount(eventCostDto.getUseAmount())
                    .useComment(eventCostDto.getUseComment())
                    .useReceiptId(eventCostDto.getUseReceiptId())
                    .useReceiptName(eventCostDto.getUseReceiptName())
                    .useSubject(eventCostDto.getUseSubject())
                    .eventUseId(eventCostDto.getEventUseId())
                .build());
            if(result > 0)  return response.success("행사비용등록 수정에 성공했습니다.");

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
            if(payInfo == null) {
                return response.success("비용요청등록이 가능한 event가 아니거나 등록된 event가 없습니다.");
            }

            eventPayDept = payInfo.getEventPayDept();
            String payFlag = payInfo.getPayFlag();
            if("N".equals(payFlag)) {
                useProStatus = "C";
                payCurrentStep = null;
            } else if("Y".equals(payFlag)) {
                useProStatus = "A";
                payCurrentStep = 1;
            }

            String receiptId = null;
            if(!"".equals(eventCostDto.getBase64String()) && eventCostDto.getBase64String() != null) {
                receiptId = s3BucketSpec.upload(eventCostDto.getBase64String(), "event");
            }

            s0221A0060Store.insertEventCost(S0221A0060Vo.InsertEventCostVo
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
                    .build()
            );
            return response.success("행사비용이 정상적으로 등록되었습니다.");
        } catch(Exception e) {
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
