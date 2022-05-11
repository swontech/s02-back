package com.swontech.s02.domain.dto.s022;

import lombok.Getter;
import lombok.Setter;

public class S0221A0020Dto {

    @Setter
    @Getter
    public static class QrInfo {
        private Integer orgId;
        private Integer memberId;
        private Integer eventId;
        private String mobileId;
    }
}
