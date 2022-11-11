package com.swontech.s02.domain.spec.s022;

import com.swontech.s02.domain.dto.s022.S0221A0070Dto;
import org.springframework.http.ResponseEntity;

public interface S0221A0070Spec {
    ResponseEntity<?> selectCostReqList(String eventCode, Integer memberId, String fromDate, String toDate);

    /* 2022.11.10 kjy */
    ResponseEntity<?> selectCostReqList(S0221A0070Dto.SelectCostReqDto reqDto);
}
