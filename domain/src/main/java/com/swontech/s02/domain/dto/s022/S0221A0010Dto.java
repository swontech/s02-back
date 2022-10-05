package com.swontech.s02.domain.dto.s022;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Setter;

public class S0221A0010Dto {

    @Setter
    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    public static class MobileInitUserInfo {
        private int memberId;
        private int orgId;
        private String memberName;
        private String hpNo;
        private String mobileId;
        private String mobileLoginDate;
        private String orgEventName;
        private int eventId;
        private String eventCode;
        private String memberTp;
        private String eventNm;
        private String orgName;
        private String eventRole;
        private int defaultEventId;
    }

    @Setter
    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    public static class MobileInitUseStateCnt {
        private int cnt;
        private String useProStatus;
        private String useProStatusNm;
    }

    @Setter
    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    public static class MobileInitPayCnt {
        private int payCnt;
    }
}
