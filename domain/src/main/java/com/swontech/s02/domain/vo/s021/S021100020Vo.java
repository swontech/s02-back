package com.swontech.s02.domain.vo.s021;

import lombok.*;

public class S021100020Vo {

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SelectMemberEmailVo{
        private String email;
        private String orgName;
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
        private String ceoName;         /*대표자명*/

    }

    @Builder
    @Getter
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
        private int memberId;           /*로그인 memberId*/
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
        private String pwd;
        private int memberId;           /*로그인 memberId*/
        private String ceoName;         /*대표자명*/
    }

    @Getter
    @Builder
    public static class SelectOrgDuplicationVo{
        private String orgName;
        private String ceoName;
    }
}
