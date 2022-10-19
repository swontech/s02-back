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
    public static class ParamsVo {
        private String memberName;
        private String fromUsedDate;
        private String toUsedDate;
        private String namePathPriortiy;
        private String useProStatus;
        private int orgId;
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RegisterCostPayReqVo {
        private int eventUsePayId;
        private int eventUseId;
        private String payStep;
        private int payMemberId;
        private String payResultFlag;
    }

}
