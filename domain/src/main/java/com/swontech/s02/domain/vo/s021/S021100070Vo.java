package com.swontech.s02.domain.vo.s021;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

public class S021100070Vo {

    @Builder
    public static class ParamsVo {
        private int orgId;
        private int eventId;
    }
    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class TbEvent010Vo {
        private int eventId;
        private String eventNm;
        private String eventCode;
        private String eventStartDate;
        private String eventEndDate;
        private String payFlag;
        private String eventLoc;
        private int eventHostId;
        private String eventComment;
        private String eventStatus;
        private int eventRegId;
        private int eventBudgetAmount;
        private int orgId;
        private String defaultEventFlag;
        private int highEventId;
        private int eventLevel;
        private String eventFinalFlag;
        private String eventTp;
        private int eventPayDept;
        private int memberId; /*로그인 memberId*/
    }
    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class TbEvent020Vo {
        private int eventId;
        private int eventPayUserId;
        private int memberId;           /*로그인 memberId*/
        private int eventPayLevel;
        private String eventPayRoleCd;
    }

}
