package com.swontech.s02.domain.spec.s021;

import org.springframework.http.ResponseEntity;

public interface S021100070Spec {
    ResponseEntity<?> retrieveDeptLevel(int orgId);
    ResponseEntity<?> retrieveDeptInfo(int eventId);
    ResponseEntity<?> retrieveDeptPayInfo(int orgId, int eventId);

}
