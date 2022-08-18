package com.swontech.s02.domain.dto.s021;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

public class S021100050Dto {

    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    public static class MemberListResponse {
        private int orgId;
        private String orgName;
        private int memberId;
        private String memberName;
        private String hpNo;
    }
}
