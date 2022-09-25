package com.swontech.s02.domain.dto.s022;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Setter;

public class S0221A2000Dto {

    @Setter
    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    public static class MoblieQRScanEventList {
        private int eventId;
        private String eventNm;
        private String idPathPriority;
        private int orgId;
        private String eventCode;
        private String eventStartDate;
        private String eventEndDate;
        private String eventTp;
        private String eventStatus;
    }
}
