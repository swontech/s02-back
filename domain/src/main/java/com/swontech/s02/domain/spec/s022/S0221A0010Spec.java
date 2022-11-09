package com.swontech.s02.domain.spec.s022;

import org.springframework.http.ResponseEntity;
import com.swontech.s02.domain.dto.s022.S0221A0010Dto;

public interface S0221A0010Spec {
    ResponseEntity<?> retrieveMobileInitUserInfo(String eventCode, String hpNo);
    ResponseEntity<?> retrieveMobileInitUseStateCnt(String eventCode, String hpNo);
    ResponseEntity<?> retrieveMobileInitPayCnt(String eventCode, String hpNo);
    ResponseEntity<?> retrieveMobileInitRecentEvent(int orgId, String eventCode);
    /*2022.11.09 kjy:부서코드검색*/
    ResponseEntity<?> retrieveEventCode(S0221A0010Dto.SelectEventCodeParams params);
}
