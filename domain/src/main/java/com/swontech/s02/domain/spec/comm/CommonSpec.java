package com.swontech.s02.domain.spec.comm;

import org.springframework.http.ResponseEntity;

public interface CommonSpec {
    ResponseEntity<?> retrieveCode(String category, String cdTp, Integer orgId, String cdV);
}
