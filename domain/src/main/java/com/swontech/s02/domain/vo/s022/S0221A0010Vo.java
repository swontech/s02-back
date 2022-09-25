package com.swontech.s02.domain.vo.s022;

import lombok.Builder;

public class S0221A0010Vo {

    @Builder
    public static class MobileInitUserInfoVo {
        private String eventCode;
        private String hpNo;
    }

    @Builder
    public static class MobileInitUseStateCntVo {
        private String eventCode;
        private String hpNo;
    }

    @Builder
    public static class MobileInitPayCntVo {
        private String eventCode;
        private String hpNo;
    }
}
