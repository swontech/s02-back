package com.swontech.s02.domain.dto.s022;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

public class S0221A0070Dto {

    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    public static class CostReqResponse {
        private int eventUseId;
        private String useSubject;
        private String usedDate;
        private int useAmount;
        private String useProStatus;
        private String payId;
    }
}
