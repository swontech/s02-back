package com.swontech.s02.domain.spec.s021;

import org.springframework.http.ResponseEntity;

public interface S021100050Spec {
    ResponseEntity<?> retrieveMemberList(int orgId, String memberName);
}
