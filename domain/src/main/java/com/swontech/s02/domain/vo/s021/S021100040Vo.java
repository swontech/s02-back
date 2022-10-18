package com.swontech.s02.domain.vo.s021;

import lombok.Builder;

public class S021100040Vo {

    @Builder
    public static class InsertMemberVo {
        private final String createProgramId = "S021100040";
        private final String updateProgramId = "S021100040";
        private int orgId;
        private String memberName;
        private String birth;
//        private String hpNo;
        private String firstHpNo;
        private String middleHpNo;
        private String lastHpNo;
        private String zipCode;
        private String address;
        private String detailAddress;
        private String email;
        private String pwd;
        private final String memberTp = "C";
        private String accountNo;
        private String bankNm;
    }

    @Builder
    public static class UpdateMemberInfoVo {
        private final String updateProgramId = "S021100040";
        private String memberName;
        private String birth;
//        private String hpNo;
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
    }
}
