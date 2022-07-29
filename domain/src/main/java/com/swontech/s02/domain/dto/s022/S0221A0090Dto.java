package com.swontech.s02.domain.dto.s022;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

public class S0221A0090Dto {

    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    public static class CostReqResponse {
        private int eventId;
        private String eventNm;
        private int eventPayUserId;
        private int eventUseId;
        private int eventUserId;
        private String usedDate;
        private int useAmount;
        private String useComment;
        private String useReceiptId;
        private String useProStatus;
        private String useSubject;
        private int payStepCnt;
        private int payCurrentStep;
        private String useProStatusNm;
        private String memberName;
        private String userMemberName;
    }
}
