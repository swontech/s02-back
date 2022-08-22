package com.swontech.s02.domain.spec.s021;

import org.springframework.http.ResponseEntity;

public interface S021100080Spec {
    ResponseEntity<?> retrieveList(int orgId, String eventNm);
}
