package com.swontech.s02.domain.spec.s022;

import com.swontech.s02.domain.dto.s022.S0221A0080Dto;
import org.springframework.http.ResponseEntity;

public interface S0221A0080Spec {
    ResponseEntity<?> retrieveCostReqDetail(int eventUseId);
    ResponseEntity<?> processingCostReq(S0221A0080Dto.ProcessingCostReqDto reqDto);
}
