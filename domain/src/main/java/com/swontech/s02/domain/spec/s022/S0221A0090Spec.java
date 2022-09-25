package com.swontech.s02.domain.spec.s022;

import com.swontech.s02.domain.dto.s022.S0221A0090Dto;
import org.springframework.http.ResponseEntity;

public interface S0221A0090Spec {
    ResponseEntity<?> retrieveCostPayList(String eventCode, int eventPayUserId, String fromDate, String toDate);
    ResponseEntity<?> retrieveCostReqList(Integer mobileMemberId, String fromDate, String toDate);
}
