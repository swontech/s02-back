package com.swontech.s02.domain.dto.s021;

import lombok.*;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class S021200010Dto {

    @Builder
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class LogIn {
        @NotEmpty(message = "이메일은 필수 입력값입니다.")
        @Email
        private String email;

        @NotEmpty(message = "비밀번호는 필수 입력값입니다.")
        private String pwd;

        public UsernamePasswordAuthenticationToken toAuthentication() {
            return new UsernamePasswordAuthenticationToken(email, pwd);
        }
    }
}
