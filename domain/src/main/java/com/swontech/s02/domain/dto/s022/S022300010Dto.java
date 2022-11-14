package com.swontech.s02.domain.dto.s022;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class S022300010Dto {

    @Setter
    @Getter
    @AllArgsConstructor
    public static class RetrieveCostPayList {
        private String memberName;
        private String fromUsedDate;
        private String toUsedDate;
        private String namePathPriortiy;
        private String useProStatus;
        private int orgId;
        /*2022.11.02 kjy paging*/
        private String column;  /*sort column*/
        private String order;   /*sorting*/
        private int limit;   /*v페이지당 출력 row수*/
        private int curPage; /*현재페이지번호*/
    }


    /*비용 요청 조회*/
    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    public static class CostPayProTotList {
        private int seq;       /*2022.11.02 kjy paging*/
        private int eventUseId;
        private int eventUserId;
        private String memberName;
        private String namePathPriortiy;
        private String eventNm;
        private String useSubject;
        private String usedDate;
        private int useAmount;
        private String useProStatus;
        private String statusNm;
        private int eventPayUserId;
        private String payerNm;
        /*2022.11.02 kjy paging*/
        private int totCnt;
    }

    /*비용 요청 조회 상세 Head*/
    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    public static class CostPayProTotDetailHead {
        private String eventUseId;
        private String eventUSerId;
        private String memberName;
        private String namePathPriortiy;
        private String usedDate;
        private int useAmount;
        private String useProStatus;
        private String statusNm;
        private String useReceiptName;
        private String useReceiptId;
        private String useSubject;
        private String eventNm;
        private String useComment;
        private String accountNo;
        private String bankNm;
    }

    /*비용 요청 조회 상세 Line*/
    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    public static class CostPayProTotDetailLine {
        private String eventUsePayId;
        private String payMemberId;
        private String payerName;
        private String payResultFlag;
        private String payResultNm;
        private String payDate;
        private String payComment;
    }

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    /*비용지급 이력을 insert 항목 */
    public static class RegisterCostPayReqDto {
        @NotNull
        private int eventUseId;
        @NotBlank
        private int payMemberId;
    }

    @Setter
    @Getter
    @AllArgsConstructor
    public static class ExcelParamsReqDto {
        private String fromUsedDate;
        private String toUsedDate;
        private String idPathPriortiy;
    }
    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    public static class ExcelCostPayTotalHead {
        private String idPathPriortiy;
        private int  eventBudgetAmount; /*예산총액*/
        private int thisAmount;         /*당월사용액*/
        private int beforeAmount;       /*전월사용누계*/
        private int balanceAmount;      /*잔여예산*/
        private String eventPath;       /*발의부서명*/
        private String memberName;      /*발의부서책임자*/
    }
    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    public static class ExcelCostPayTotalLine {
        private String payMethod;
        private String memberName;
        private String bankNm;
        private String accountNo;
        private String useAmount;
        private String useComment;
        private String cdVMeaning;
        private String billCd;
        private String tag;
        private String eventPath;
        private String mainEventHostName;
        private String eventPath0;
        private String usedDate;
        private String payDate;
        private String useSubject;
    }


}
