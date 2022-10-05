package com.swontech.s02.domain.dto.s022;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
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

    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    public static class SelectQRScanInfo {
        private String namePathPriortiy;
        private String eventNm;
        private String eventStartDate;
        private String eventEndDate;
    }
}
