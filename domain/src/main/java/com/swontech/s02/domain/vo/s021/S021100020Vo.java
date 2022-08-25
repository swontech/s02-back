package com.swontech.s02.domain.vo.s021;

import lombok.*;

public class S021100020Vo {

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SelectMemberEmailVo{
        private String email;
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class InsertOrgVo {
        private int orgId;
        private String orgName;
        private String zipCode;
        private String address;
        private String detailAddress;
        private String firstTelNo;
        private String middleTelNo;
        private String lastTelNo;
    }

    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class InsertMemberVo {
        private int orgId;
        private String memberName;
        private String firstHpNo;
        private String middleHpNo;
        private String lastHpNo;
        private String email;
        private String pwd;
    }

    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UpdateOrgVo {
        private int orgId;
        private String orgName;
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
    }
}
