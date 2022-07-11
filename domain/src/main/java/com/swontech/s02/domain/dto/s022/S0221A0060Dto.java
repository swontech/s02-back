package com.swontech.s02.domain.dto.s022;

import lombok.Getter;
import lombok.Setter;

public class S0221A0060Dto {

    @Getter
    @Setter
    public static class UpdateEventCostDto {
        private int eventUseId;
        private int eventUserId;
        private String useSubject;
        private int eventId;
        private String usedDate;
        private int useAmount;
        private String useReceiptId;
        private String useComment;
        private String useProStatus;
    }

    @Getter
    @Setter
    public static class InsertEventCostDto {
        private int eventUserId;
        private String useSubject;
        private int eventId;
        private String usedDate;
        private int useAmount;
        private String useReceiptId;
        private String useComment;
        private String useProStatus;
    }

    @Getter
    @Setter
    public static class SelectEventCostResponse {
        private int eventUseId;
        private int eventId;
        private int eventUserId;
        private String usedDate;
        private int useAmount;
        private String useComment;
        private String useReceiptId;
        private String useProStatus;
        private String useSubject;
    }
}
