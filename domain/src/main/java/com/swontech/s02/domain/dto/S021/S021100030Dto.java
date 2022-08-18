package com.swontech.s02.domain.dto.s021;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Getter;
import lombok.Setter;

public class S021100030Dto {

    @Getter
    @Setter
    public static class RetriveMemberList {
        private int orgId;
        private String fromDt;
        private String toDt;
        private String memberName;
        private String memberTp;
    }

    @Getter
    public static class DeleteMember {
        private int memberId;
    }

    @Getter
    public static class UpdateMemberTp {
        private int memberId;
    }

    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    public static class MemberListResponse {
        private int orgId;
        private String orgName;
        private int memberId;
        private String memberName;
        private String email;
        private String hpNo;
        private String mobileLoginDate;
        private String memberTp;
        private String memberTpNm;
    }
}
