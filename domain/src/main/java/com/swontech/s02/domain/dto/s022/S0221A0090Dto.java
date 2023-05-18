package com.swontech.s02.domain.dto.s022;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Getter;
import lombok.Setter;

public class S0221A0090Dto {
    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    public static class CostPayList {
        private int eventUseId;
        private int eventId;
        private int eventUserId;
        private String memberName;
        private String usedDate;
        private int useAmount;
        private String useComment;
        private String useReceiptId;
        private String useReceiptName;
        private String useSubject;
        private String payName;
        private String useProStatus;
        private String useProStatusNm;
    }

    @Getter
    @Setter
    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    public static class AppPushUser {
        private String useProStatus;
        private String reqUserName;
        private String reqToken;
        private String payToken;
    }
}
