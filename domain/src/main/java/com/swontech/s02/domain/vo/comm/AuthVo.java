package com.swontech.s02.domain.vo.comm;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class AuthVo {

    @Builder
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class JwtTokenInfo {
        private String email;
        private String grantType;
        private String accessToken;
        private String refreshToken;
        private Long refreshTokenDurationDays;
    }
}
