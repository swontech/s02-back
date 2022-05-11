package com.swontech.s02.domain.vo.s022;

import lombok.Builder;

public class S0221A0020Vo {

    @Builder
    public static class SelectMobileId {
        private String mobileId;
    }

    @Builder
    public static class InsertEnterVo {
        private int orgId;
        private int memberId;
        private int eventId;
    }
}
