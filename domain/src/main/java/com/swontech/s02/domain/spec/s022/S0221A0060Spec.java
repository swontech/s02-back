package com.swontech.s02.domain.spec.s022;

import com.swontech.s02.domain.dto.s022.S0221A0060Dto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface S0221A0060Spec {
    /** 기존에 등록된 행사비용 상세정보를 조회한다 */
    ResponseEntity<?> selectEventCost(Integer eventUseId);
    /** 기존에 등록된 행사비용 상세정보를 수정한다 */
    ResponseEntity<?> updateEventCost(S0221A0060Dto.UpdateEventCostDto eventCostDto);
    /** 행사비용을 신규 등록한다 */
    ResponseEntity<?> insertEventCost(S0221A0060Dto.InsertEventCostDto eventCostDto);
    /** 기존에 등록된 행사 비용을 삭제한다 */
    ResponseEntity<?> deleteEventCost(List<Integer> eventUseIdList);

}
