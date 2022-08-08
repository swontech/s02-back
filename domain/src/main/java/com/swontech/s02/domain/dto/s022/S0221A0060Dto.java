package com.swontech.s02.domain.dto.s022;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Getter;
import lombok.Setter;

public class S0221A0060Dto {
    @Getter
    public static class PayInfo {
        private String payFlag;
        private int eventPayDept;
    }

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
        private String useReceiptName;
        private String useComment;
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
        private String useReceiptName;
        private String useComment;
    }

    @Getter
    @Setter
    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    public static class SelectEventCostResponse {
        private String payFlag;
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
