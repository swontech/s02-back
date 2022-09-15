package com.swontech.s02.domain.vo.s022;

import lombok.Builder;
import lombok.Getter;

public class S0221A0030Vo {

    @Builder
    public static class SelectMemberExistFlagVo {
        private String hpNo;
        private String eventCode;
    }

    @Builder
    @Getter
    public static class InsertNewMobileMemberVo {
        private int memberId;
        private int orgId;
        private String memberName;
        private String hpNo;
    }

    @Builder
    public static class UpdateMobileIdVo {
        private int memberId;
        private String mobileId;
    }

    @Builder
    public static class InsertNewMobileEventMemberVo {
        private int eventId;
        private int memberId;
    }

    @Builder
    public static class UpdateMobileMemberVo {
        private String newMobileId;
        private String mobileId;
    }
}
