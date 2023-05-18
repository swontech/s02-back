package com.swontech.s02.domain.spec.s022;

import org.springframework.http.ResponseEntity;

import java.security.NoSuchAlgorithmException;

public interface S0221A0030Spec {
    ResponseEntity<?> signUp(String eventCode, String hpNo, String memberName, String token) throws NoSuchAlgorithmException;
}
