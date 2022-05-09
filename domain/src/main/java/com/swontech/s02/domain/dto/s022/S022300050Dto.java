package com.swontech.s02.domain.dto.s022;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class S022300050Dto {

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class RegisterEvent {
        private String eventNm;
        private String eventStartDate;
        private String eventEndDate;
        private String eventLoc;
        private String eventComment;
        private String eventHostId;
    }

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class PatchEvent {
        private String eventNm;
        private String eventStartDate;
        private String eventEndDate;
        private String eventLoc;
        private String eventComment;
        private String eventHostId;
    }

    @Setter
    public static class RetrieveEventResponse {
       private String eventId;
       private String eventNm;
       private String eventStartDate;
       private String eventEndDate;
       private String eventLoc;
       private String eventComment;
       private String eventStatus;
       private String eventFlag;
       private String orgId;
       private String eventHostNm;

    }
}
