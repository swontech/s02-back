package com.swontech.s02.domain.dto.s021;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Getter;
import lombok.Setter;

public class S021100030Dto {

    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    public static class MemberDetailInfo {
        private int memberId;
        private String memberName;
        private String birth;
        private String hpNo;
        private String zipCode;
        private String address;
        private String detailAddress;
        private String email;
        private String bankNm;
        private String accountNo;
    }

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
        private String memberTp;
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
        private String regDate;
    }
}
