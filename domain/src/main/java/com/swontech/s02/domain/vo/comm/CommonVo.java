package com.swontech.s02.domain.vo.comm;

import lombok.Builder;

public class CommonVo {

    @Builder
    public static class SelectCodeVo {
        private String category;
        private String cdTp;
        private int orgId;
        private String cdV;
    }

    @Builder
    public static class PagingVo {
        private int seq;
        private int totCnt;
        private String column;  /*sort column*/
        private String order;   /*sorting*/
        private int limit;   /*페이지당 출력 row수*/
        private int curPage; /*현재페이지번호*/
    }
}
