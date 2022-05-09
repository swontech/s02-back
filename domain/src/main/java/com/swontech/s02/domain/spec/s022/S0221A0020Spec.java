package com.swontech.s02.domain.spec.s022;

import com.swontech.s02.domain.dto.s022.S0221A0020Dto;
import org.springframework.http.ResponseEntity;

public interface S0221A0020Spec {
    ResponseEntity<?> scanQrInfo(S0221A0020Dto.QrInfo qrInfo);
}
