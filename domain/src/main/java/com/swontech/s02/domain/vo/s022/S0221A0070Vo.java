package com.swontech.s02.domain.vo.s022;

import lombok.Builder;
import lombok.Getter;

public class S0221A0070Vo {
    @Builder
    @Getter
    public static class SelectCostReqVo {
        private String eventCode;
        private int mobileMemberId;
        private String fromDate;
        private String toDate;
    }
}
