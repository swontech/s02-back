package com.swontech.s02.domain.dto.s021;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

public class S021100080Dto {

    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    public static class SelectListResponse {
        private int eventId;
        private String eventNm;
        private String payNm4;
        private int payLevel4;
        private String payerNm4;
        private String payNm3;
        private int payLevel3;
        private String payerNm3;
        private String payNm2;
        private int payLevel2;
        private String payerNm2;
        private String payNm1;
        private int payLevel1;
        private String payerNm1;
        private int lev;
        private String menuPath;
        private int eventHostId;
        private String chargeNm;
        private String payFlag;
        private int highEventId;
        private int idPath;
        private int idPathPriortiy; /* kjy add */
    }
}
