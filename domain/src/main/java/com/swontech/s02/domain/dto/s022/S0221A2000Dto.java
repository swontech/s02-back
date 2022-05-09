package com.swontech.s02.domain.dto.s022;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Setter;

public class S0221A2000Dto {

    @Setter
    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    public static class EventListResponse {
        private String eventId;
        private String eventNm;
        private String eventPeriod;
        private String regMemberName;
        private String orgId;
    }
}
