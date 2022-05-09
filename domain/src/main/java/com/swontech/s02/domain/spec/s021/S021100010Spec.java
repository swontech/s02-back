package com.swontech.s02.domain.spec.s021;

import org.springframework.http.ResponseEntity;

public interface S021100010Spec {
    ResponseEntity<?> retrieveOrgList();
    ResponseEntity<?> registerOrgList();
    ResponseEntity<?> patchOrgList();
    ResponseEntity<?> deleteOrgList();
}
