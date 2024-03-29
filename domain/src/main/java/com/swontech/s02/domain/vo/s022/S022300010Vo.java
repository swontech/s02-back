/****************************************************
 * program : 비용진행현황 및 비용상세처리 (S022300010)
 ****************************************************/
package com.swontech.s02.domain.vo.s022;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class S022300010Vo {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ParamsVo {
        private String memberName;
        private String fromUsedDate;
        private String toUsedDate;
        private String namePathPriortiy;
        private String useProStatus;
        private int orgId;
        /*2022.11.02 kjy paging*/
        private String column;  /*sort column*/
        private String order;   /*sorting*/
        private int limit;   /*페이지당 출력 row수*/
        private int curPage; /*현재페이지번호*/
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RegisterCostPayReqVo {
        private int eventUsePayId;
        private int eventUseId;
        private String payStep;
        private int payMemberId;    /*로그인 memberId*/
        private String payResultFlag;
    }
    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UpdateCostPayReqVo {
        private int eventUseId;
        private int memberId;
    }
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ExcelParamsVo {
        private String fromUsedDate;
        private String toUsedDate;
        private String idPathPriortiy;
    }

}
