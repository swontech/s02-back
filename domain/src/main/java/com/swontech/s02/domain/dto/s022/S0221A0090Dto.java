package com.swontech.s02.domain.dto.s022;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

public class S0221A0090Dto {

    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    public static class CostReqResponse {

        private String useSubject;
        private String usedDate;
        private String userMemberName;
        private int useAmount;
    }
}
