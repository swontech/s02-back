package com.swontech.s02.domain.vo.s021;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.swontech.s02.domain.vo.comm.CommonVo;
import lombok.*;

public class S021100030Vo {
    @Builder
    public static class SelectMemberListVo {
        private int orgId;
        private String fromDt;
        private String toDt;
        private String memberName;
        private String memberTp;
        /*2022.11.01 kjy paging*/
        private int seq;
        private int totCnt;
        private String column;  /*sort column*/
        private String order;   /*sorting*/
        private int limit;   /*페이지당 출력 row수*/
        private int curPage; /*현재페이지번호*/
    }

    @Builder
    public static class UpdateMemberTp {
        private int memberId;
        private String memberTp;
        private int loginId;
    }
    @Builder
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UploadMemberVo {
        private int orgId;
        private String memberName;
        private String email;
        private String hpNo;
        private String birth;
        private String zipCode;
        private String address;
        private String detailAddress;
        private String accountNo;
        private String bankNm;
        private int loginId;
    }
}
