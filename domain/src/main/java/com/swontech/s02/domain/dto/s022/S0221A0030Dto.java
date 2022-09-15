package com.swontech.s02.domain.dto.s022;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Getter;
import lombok.Setter;

public class S0221A0030Dto {

    @Getter
    public static class MobileMemberExistFlag {
        private Integer memberId;
        private String memberName;
        private String hpNo;
        private String MobileId;
        private String mobileLoginDate;
        private String orgEventName;
        private Integer eventId;
        private Integer orgId;
    }

    @Setter
    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    public static class SignUpResponse {
        private Integer memberId;
        private String memberName;
        private Integer orgId;
        private String hpNo;
        private String mobileId;
        private String memberTp;
        private String orgEventName;
    }
}
