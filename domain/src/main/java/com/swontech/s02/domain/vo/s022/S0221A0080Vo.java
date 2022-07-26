package com.swontech.s02.domain.vo.s022;

import lombok.Builder;

public class S0221A0080Vo {

    @Builder
    public static class InsertCostReqProcessVo {
        private Integer eventUseId;
        private Integer payCurrentStep;
        private Integer payMemberId;
        private String payResultFlag;
        private String payComment;
    }

    @Builder
    public static class UpdateCostReqProcessVo {
        private String useProStatus;
        private Integer payCurrentStep;
        private Integer eventUseId;
    }
}
