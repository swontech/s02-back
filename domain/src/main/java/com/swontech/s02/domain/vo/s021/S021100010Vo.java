package com.swontech.s02.domain.vo.s021;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

public class S021100010Vo {

    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SelectOrgListVo {
        private String orgName;
        private String memberName;
        /*2022.11.02 kjy paging*/
        private int seq;
        private int totCnt;
        private String column;  /*sort column*/
        private String order;   /*sorting*/
        private int limit;   /*페이지당 출력 row수*/
        private int curPage; /*현재페이지번호*/
    }

    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UpdateOrgListVo {
        private String orgId;
    }
}
