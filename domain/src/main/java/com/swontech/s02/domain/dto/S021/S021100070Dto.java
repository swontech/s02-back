package com.swontech.s02.domain.dto.s021;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

public class S021100070Dto {
    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    public static class DeptLevel {
        private String eventNm;
        private int highEventId;
        private String idPath;
        private int mostHighId;
        private int eventLevel;
        private String eventTp;
        private int eventId;
    }

    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    public static class DeptDetailInfo {
        private int eventId;
        private String eventNm;
        private String eventCode;
        private int eventHostId;
        private String memberName;
        private int eventBudgetAmount;
        private String eventStartDate;
        private String eventEndDate;
        private String eventLoc;
        private String defaultEventFlag;
        private String eventStatus;
        private String payFlag;
        private String eventComment;
    }

    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    public static class DeptDetailPayInfo {
        private int eventId;
        private int eventPayUserId;
        private int eventPayLevel;
        private String eventPayRoleCd;
        private String memberName;
    }
}
