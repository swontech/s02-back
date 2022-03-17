package com.swontech.s02.domain.dto.S021;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

/**
 * S021100020 등록/수정 화면 Dto
 */
public class S021100020Dto {

    @Getter
    @Builder
    @AllArgsConstructor
    public static class RegisterOrg {

        @NotBlank
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
        private String midTelNo;

        @NotBlank
        private String lastTelNo;
    }

}
