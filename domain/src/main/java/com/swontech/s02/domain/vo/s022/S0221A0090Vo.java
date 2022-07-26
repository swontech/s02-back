package com.swontech.s02.domain.vo.s022;

import lombok.Builder;
import lombok.Getter;

public class S0221A0090Vo {

    @Builder
    @Getter
    public static class SelectCostReqVo {
        private int mobileMemberId;
        private String fromDate;
        private String toDate;
    }
}
