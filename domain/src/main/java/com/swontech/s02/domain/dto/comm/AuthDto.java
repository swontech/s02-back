package com.swontech.s02.domain.dto.comm;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class AuthDto {
    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ReIssue {

        private String refreshToken;
        private String accessToken;
    }


}
