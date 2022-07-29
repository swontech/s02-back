package com.swontech.s02.domain.vo.s022;

import lombok.Builder;

public class S0221A0060Vo {

    @Builder
    public static class UpdateEventCostVo {
        private int eventUseId;
        private int eventUserId;
        private String useSubject;
        private int eventId;
        private String usedDate;
        private int useAmount;
        private String useReceiptId;
        private String useComment;
    }

    @Builder
    public static class InsertEventCostVo {
        private int eventUserId;
        private String useSubject;
        private int eventId;
        private String usedDate;
        private int useAmount;
        private String useReceiptId;
        private String useComment;
    }

}