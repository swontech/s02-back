package com.swontech.s02.domain.vo.s022;

import lombok.Builder;
import lombok.Getter;

public class S0221A0030Vo {

    @Builder
    @Getter
    public static class InsertMemberInfoVo {
        private int memberId;
        private String memberName;
        private String hpNo;
        private String pwd;
        private String mobileId;
    }

    @Builder
    public static class UpdateMobileIdVo {
        private int memberId;
        private String mobileId;
    }
}
