package com.swontech.s02.domain.spec.s022;

import org.springframework.http.ResponseEntity;

public interface S0221A2000Spec {
    ResponseEntity<?> retrieveEventList(String eventCode, int orgId);
    /*2022.11.03 kjy */
    ResponseEntity<?> retrieveEventDetail(int eventId);
}
