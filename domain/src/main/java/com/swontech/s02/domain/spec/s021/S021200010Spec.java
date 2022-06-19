package com.swontech.s02.domain.spec.s021;

import com.swontech.s02.domain.dto.s021.S021200010Dto;
import org.springframework.http.ResponseEntity;

public interface S021200010Spec {
    ResponseEntity<?> logIn(S021200010Dto.LogInReqDto reqDto) throws Exception;
}
