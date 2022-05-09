package com.swontech.s02.domain.spec.s022;

import com.swontech.s02.domain.dto.s022.S022300050Dto;
import org.springframework.http.ResponseEntity;

public interface S022300050Spec {
    // 행사등록
    ResponseEntity<?> registerEvent(S022300050Dto.RegisterEvent reqDto);

    // 행사조회
    ResponseEntity<?> retrieveEvent(String eventId);

    // 행사수정
    ResponseEntity<?> patchEvent();
}
