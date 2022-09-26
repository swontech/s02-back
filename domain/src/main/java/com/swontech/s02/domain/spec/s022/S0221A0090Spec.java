package com.swontech.s02.domain.spec.s022;

import org.springframework.http.ResponseEntity;

public interface S0221A0090Spec {
    ResponseEntity<?> retrieveCostPayList(String eventCode, int eventPayUserId, String fromDate, String toDate);
}
