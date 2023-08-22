package com.swontech.s02.domain.dto.s022;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Getter;
import lombok.Setter;

public class S0221A0030Dto {

    @Getter
    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    public static class MobileMemberExistFlag {
        private Integer memberId;
        private String memberName;
        private String hpNo;
        private String MobileId;
        private String mobileLoginDate;
        private String orgEventName;
        private Integer eventId;
        private Integer orgId;
        private String eventCode;
        private String eventPayUserId;
        private String pushToken;
    }

    @Getter
    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    public static class RetrieveToken {
        private Integer certiNo;
        private String pushToken;
        private Integer memberNo;
        private Integer orgId;
        private String memberName;
        private String hpNo;
        private String pushTokenTab;
        private String memberTp;
    }
}
