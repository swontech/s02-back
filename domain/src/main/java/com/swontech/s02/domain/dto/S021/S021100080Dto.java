package com.swontech.s02.domain.dto.s021;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

public class S021100080Dto {

    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    public static class SelectListResponse {
        private int eventId;
        private String eventNm0;
        private int eventHostId;
        private String eventHostName;
        private String payLevel1;
        private String payLevel01Name;
        private String payNm1;
        private String payLevel2;
        private String payLevel02Name;
        private String payNm2;
        private String payLevel3;
        private String payLevel03Name;
        private String payNm3;
        private String payLevel4;
        private String payLevel04Name;
        private String payNm4;
        private String eventBudgetAmount;
        private String eventLevel;
        private String payFlag;
        private String highEventId;
        private String eventNm;
        private String eventTp;
        private String eventComment;
    }
}
