package com.swontech.s02.domain.vo.s022;

import lombok.Builder;
import lombok.Getter;

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
        private String useReceiptName;
        private String useComment;
    }

    @Builder
    @Getter
    public static class InsertEventCostVo {
        private int eventUseId;
        private int eventUserId;
        private String useSubject;
        private int eventId;
        private String usedDate;
        private int useAmount;
        private String useReceiptId;
        private String useReceiptName;
        private String useComment;
        private String useProStatus;
        private int payStepCnt;
        private Integer payCurrentStep;
    }
}
