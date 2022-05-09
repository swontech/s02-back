package com.swontech.s02.domain.vo.s022;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

public class S022300050Vo {

    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class InsertEventVo {
        private String eventNm;
        private String eventStartDate;
        private String eventEndDate;
        private String eventLoc;
        private String eventHostId;
        private String eventComment;
        private final String eventStatus = "N";
    }
}
