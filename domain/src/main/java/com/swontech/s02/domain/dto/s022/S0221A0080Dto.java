package com.swontech.s02.domain.dto.s022;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Getter;
import lombok.Setter;

public class S0221A0080Dto {

    @Setter
    @Getter
    public static class ProcessingCostReqDto {
        private int eventUseId;
        private int memberId;
        private int payCurrentStep;
        private String payResultFlag;
        private String payComment;
    }

    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    public static class RetrieveCostReqDetailResponse {
        private int eventId;
        private String eventNm;
        private String payFlag;
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
        private String useReceiptName;
        private int eventUsePayId;
        private int payStep;
        private int payMemberId;
        private String payResultFlag;
        private String payComment;
        private String payDate;
        private String userName;
        private String useProStatusNm;
        private String paiedName;
        private String currentPayName;
        private String payResultFlagNm;
    }

}
