package com.swontech.s02.domain.dto.s021;

import lombok.*;

import javax.validation.constraints.*;

/**
 * S021100020 등록/수정 화면 Dto
 */
public class S021100020Dto {

    @Getter
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

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class PatchOrg {
        private int orgId;
        private String orgName;
        private String zipCode;
        private String address;
        private String detailAddress;
        private String firstTelNo;
        private String middleTelNo;
        private String lastTelNo;
        private String memberName;
        private String firstHpNo;
        private String middleHpNo;
        private String lastHpNo;
    }

    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class OrgDetailInfo {
        private String orgId;
        private String orgName;
        private String zipCode;
        private String address;
        private String detailAddress;
        private String firstTelNo;
        private String middleTelNo;
        private String lastTelNo;
        private String firstHpNo;
        private String middleHpNo;
        private String lastHpNo;
        private String email;
        private String memberTp;
    }
}
