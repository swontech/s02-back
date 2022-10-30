package com.swontech.s02.domain.spec.s022;

import org.springframework.http.ResponseEntity;

public interface S0221A0010Spec {
    ResponseEntity<?> retrieveMobileInitUserInfo(String eventCode, String hpNo);
    ResponseEntity<?> retrieveMobileInitUseStateCnt(String eventCode, String hpNo);
    ResponseEntity<?> retrieveMobileInitPayCnt(String eventCode, String hpNo);
    ResponseEntity<?> retrieveMobileInitRecentEvent(int orgId, String eventCode);

}
