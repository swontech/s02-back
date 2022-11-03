package com.swontech.s02.domain.vo.s022;

import lombok.Builder;
import lombok.Getter;

public class S022300080Vo {

    @Builder
    public static class SelectEnterListVo {
        private int eventId;
        private String hpNo;
        private String memberName;
        private String enterFlag;
        /*2022.11.02 kjy paging*/
        private String column;  /*sort column*/
        private String order;   /*sorting*/
        private int limit;   /*페이지당 출력 row수*/
        private int curPage; /*현재페이지번호*/
    }

    @Builder
    @Getter
    public static class InsertEnterVo {
        private int eventId;
        private int memberId;
    }

    @Builder
    public static class DeleteEnterVo {
        private int eventId;
        private int memberId;
    }
}
