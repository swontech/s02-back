package com.swontech.s02.domain.dto.s021;

import lombok.*;

import javax.validation.constraints.*;

/**
 * S021100020 등록/수정 화면 Dto
 */
public class S021100020Dto {

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class RegisterOrg {
        @NotNull
        private String orgName;

        @NotBlank
        private String zipCode;

        @NotBlank
        private String address;

        @NotBlank
        private String detailAddress;

        @NotBlank
        private String firstTelNo;

        @NotBlank
        private String middleTelNo;

        @NotBlank
        private String lastTelNo;

        @NotBlank
        private String memberName;

        @NotBlank
        private String firstHpNo;

        @NotBlank
        private String middleHpNo;

        @NotBlank
        private String lastHpNo;

        @NotBlank
        private String email;
    }

}
