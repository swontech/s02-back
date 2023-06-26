package com.swontech.s02.domain.dto.s021;

import lombok.Getter;
import lombok.Setter;

public class S021100040Dto {

    @Getter
    public static class RegisterMemberDto {
        private int orgId;
        private String memberName;
        private String birth;
        private String firstHpNo;
        private String middleHpNo;
        private String lastHpNo;
        private String zipCode;
        private String address;
        private String detailAddress;
        private String email;
        private String pwd;
        private String accountNo;
        private String bankNm;
        private int loginId; /*2022.10.27 kjy*/
    }

    @Getter
    public static class UpdateMemberInfoDto {
        private String memberName;
        private String birth;
        private String firstHpNo;
        private String middleHpNo;
        private String lastHpNo;
        private String zipCode;
        private String address;
        private String detailAddress;
        private String email;
        private String accountNo;
        private String bankNm;
        private int memberId;
        private String pwd;
        private int loginId; /*2022.10.27 kjy*/
    }

    @Getter
    @Setter
    public static class MemberOrgMultiFlagDto {
        private int orgId;
        private String firstHpNo;
        private String middleHpNo;
        private String lastHpNo;
    }
}
