package com.swontech.s02.domain.spec.s022;

import org.springframework.http.ResponseEntity;

public interface S022300040Spec {
    //행사리스트검색
    ResponseEntity<?> retrieveEventList();
    // 행사삭제
    ResponseEntity<?> deleteEvent();
}
