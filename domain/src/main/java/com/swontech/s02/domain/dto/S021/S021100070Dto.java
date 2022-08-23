package com.swontech.s02.domain.dto.s021;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

public class S021100070Dto {

    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    public static class DeptDetailInfo {
        private int eventId;
        private String eventTp;
        private String eventNm;
        private int eventHostId;
        private int eventBudgetAmount;
        private String eventStartDate;
        private String eventEndDate;
        private String eventLoc;
        private String defaultEventFlag;
        private String eventComment;
        private String memberName;
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
