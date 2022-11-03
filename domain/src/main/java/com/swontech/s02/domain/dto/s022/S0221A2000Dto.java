package com.swontech.s02.domain.dto.s022;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Setter;

public class S0221A2000Dto {

    @Setter
    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    public static class MoblieQRScanEventList {
        private int eventId;
        private String eventNm;
        private String payFlag;
        private int highEventId;
        private String idPathPriortiy;
        private int orgId;
        private String eventFinalFlag;
        private String eventStartDate;
        private String eventEndDate;
        private String eventTp;
        private String eventStatus;
        private int eventHostId;
        private String memberName;
        private String eventPath;
        private String eventCode;
    }

    @Setter
    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    public static class MoblieQRScanEventDetail {
        private int eventId;
        private String eventPath;
        private String eventNm;
        private String eventStartDate;
        private String eventEndDate;
        private String eventLoc;
        private String memberName;
    }

}
