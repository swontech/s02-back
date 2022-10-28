package com.swontech.s02.domain.dto.s021;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.*;

import javax.validation.constraints.*;

/**
 * S021100020 등록/수정 화면 Dto
 */
public class S021100020Dto {

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class RegisterOrgReqDto {
        @NotNull
        private String orgName;
        @NotNull
        private String pwd;
        private String zipCode;
        private String address;
        private String detailAddress;
        private String firstTelNo;
        private String middleTelNo;
        private String lastTelNo;
        @NotBlank
        private String memberName;
        private String firstHpNo;
        private String middleHpNo;
        private String lastHpNo;
        private String email;
        private int memberId;           /*로그인 memberId*/
        @NotNull
        private String ceoName;         /*대표자명*/
    }

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class PatchOrgReqDto {
        private int orgId;
        private String orgName;
        private String pwd;
        private String zipCode;
        private String address;
        private String detailAddress;
        private String firstTelNo;
        private String middleTelNo;
        private String lastTelNo;
        private String email;
        private String memberName;
        private String firstHpNo;
        private String middleHpNo;
        private String lastHpNo;
        private int memberId;           /*로그인 memberId*/
        private String ceoName;         /*대표자명*/
    }

    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    public static class OrgDetailInfo {
        private Integer orgId;
        private String orgName;
        private String zipCode;
        private String address;
        private String detailAddress;
        private String telNoFst;
        private String telNoSnd;
        private String telNoThd;
        private String hpFst;
        private String hpSnd;
        private String hpThd;
        private String emailFst;
        private String emailSnd;
        private String memberId;
        private String memberTp;
        private String memberName;
        private String ceoName;         /*대표자명*/
    }
}
