package com.swontech.s02.domain.dto.s022;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

public class S0221A0060Dto {
    @Getter
    public static class PayInfo {
        private int eventId;
        private String payFlag;
        private int eventBudgetAmount;
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
        private String base64String;
    }

    @Getter
    @Setter
    public static class InsertEventCostDto {
        private int eventUserId;
        private String useSubject;
        private int eventId;
        private String usedDate;
        private int useAmount;
        private String useReceiptName;
        private String useComment;
        private String base64String;
    }

    @Getter
    @Setter
    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    public static class SelectEventCostHeader {
        private int eventId;
        private String eventNm;
        private int eventUseId;
        private int eventUserId;
        private String userName;
        private String usedDate;
        private int useAmount;
        private String useComment;
        private String useReceiptId;
        private String useProStatus;
        private String useProStatusNm;
        private String useSubject;
        private int payStepCnt;
        private int payCurrentStep;
        private String payFlag;
        private String useReceiptName;
    }

    @Getter
    @Setter
    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    public static class SelectEventCostDetail {
        private int eventUsePayId;
        private int payStep;
        private int payMemberId;
        private String paiedName;
        private String payResultFlag;
        private String payResultNm;
        private String payComment;
        private String payDate;
    }
}
