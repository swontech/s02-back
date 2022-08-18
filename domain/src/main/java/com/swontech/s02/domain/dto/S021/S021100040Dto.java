package com.swontech.s02.domain.dto.s021;

import lombok.Getter;

public class S021100040Dto {

    @Getter
    public class RegisterMemberDto {
        private int orgId;
        private String memberName;
        private String birth;
        private String hpNo;
        private String zipCode;
        private String address;
        private String detailAddress;
        private String email;
        private String pwd;
        private String accountNo;
        private String backNm;
    }

    @Getter
    public class UpdateMemberInfoDto {
        private String memberName;
        private String birth;
        private String hpNo;
        private String zipCode;
        private String address;
        private String detailAddress;
        private String email;
        private String accountNo;
        private String bankNm;
        private int memberId;
    }
}
