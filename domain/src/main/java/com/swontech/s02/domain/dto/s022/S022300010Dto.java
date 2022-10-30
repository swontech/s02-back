package com.swontech.s02.domain.dto.s022;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class S022300010Dto {

    @Getter
    public static class RetrieveCostPayList {
        private String memberName;
        private String fromUsedDate;
        private String toUsedDate;
        private String namePathPriortiy;
        private String useProStatus;
        private int orgId;
    }


    /*비용 요청 조회*/
    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    public static class CostPayProTotList {
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
        private String payerName;
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
}
