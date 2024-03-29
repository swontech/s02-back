package com.swontech.s02.domain.spec.comm;

import com.swontech.s02.domain.dto.comm.AuthDto;
import org.springframework.http.ResponseEntity;

public interface AuthSpec {
    ResponseEntity<?> reIssueToken(String accessToken, String refreshToken);
    ResponseEntity<?> deleteToken(String email);
}
