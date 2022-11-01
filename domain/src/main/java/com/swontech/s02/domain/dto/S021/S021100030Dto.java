package com.swontech.s02.domain.dto.s021;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.swontech.s02.domain.dto.comm.CommonDto;
import com.swontech.s02.domain.dto.comm.CommonDto.PagingReqDto;
import lombok.Getter;
import lombok.Setter;

public class S021100030Dto {

    public static CommonDto commonDto = new CommonDto();
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
        /*2022.11.01 kjy paging*/
        private String column;  /*sort column*/
        private String order;   /*sorting*/
        private int limit;   /*v페이지당 출력 row수*/
        private int curPage; /*현재페이지번호*/
    }

    @Getter
    public static class DeleteMember {
        private int memberId;
    }

    @Getter
    public static class UpdateMemberTp {
        private int memberId;
        private String memberTp;
        private int loginId; /*2022.10.27 kjy*/
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
        private int loginId; /*2022.10.27 kjy*/
        /*2022.11.01 kjy paging*/
        private int seq;
        private int totCnt;
    }

    /*2022.10.31 kjy 회원관리-업로드:일괄등록*/
    @Getter
    public static class UploadMemberDto {
        private String memberName;
        private String email;
        private String hpNo;
        private String birth;
        private String zipCode;
        private String address;
        private String detailAddress;
        private String accountNo;
        private String bankNm;
    }
}
