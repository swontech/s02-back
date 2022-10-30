package com.swontech.s02.domain.dto.s021;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
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
    public static class LogInReqDto {
        @NotEmpty(message = "이메일은 필수 입력값입니다.")
        @Email
        private String email;

        @NotEmpty(message = "비밀번호는 필수 입력값입니다.")
        private String pwd;

        public UsernamePasswordAuthenticationToken toAuthentication() {
            return new UsernamePasswordAuthenticationToken(email, pwd);
        }
    }

    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    public static class MemberInfoDto {
        private int memberId;
        private String email;
        private String memberName;
        private String memberTp;
        private int orgId;
        private String orgName;
        private String refreshToken;
        private String accessToken;
    }
}
