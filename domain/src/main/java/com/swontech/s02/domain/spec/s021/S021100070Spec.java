package com.swontech.s02.domain.spec.s021;

import org.springframework.http.ResponseEntity;

public interface S021100070Spec {
    ResponseEntity<?> retrieveDeptInfo(int eventId);
    ResponseEntity<?> retrieveDeptPayInfo(int eventId);

}
