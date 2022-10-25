package com.swontech.s02.domain.dto.s021;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class S021100070Dto {
    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    public static class DeptLevel {
        private String eventNm;
        private int highEventId;
        private String idPath;
        private int mostHighId;
        private int eventLevel;
        private String eventTp;
        private int eventId;
    }

    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    public static class DeptDetailInfo {
        private int eventId;
        private String eventNm;
        private String eventCode;
        private int eventHostId;
        private String memberName;
        private int eventBudgetAmount;
        private String eventStartDate;
        private String eventEndDate;
        private String eventLoc;
        private String defaultEventFlag;
        private String eventStatus;
        private String payFlag;
        private String eventComment;
        private int highEventId;
        private int eventLevel;
        private String eventTp;
        private String eventFinalFlag;
        private String delFlag;
    }

    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    public static class DeptDetailPayInfo {
        private int eventPayUserId;
        private String memberName;
        private String hpNo;
        private String fstPayFlag;
        private String sndPayFlag;
        private String trdPayFlag;
        private String fourthPayFlag;
        private String eventPayRoleCd; 
        private int eventPayLevel;
        private int eventId;
        private String useRegFlag;      /*등록권한*/
    }

    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    public static class NewEventCode {
        private String eventCode;
    }

    /** 부서(행사) 등록 항목 */
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class RegisterEventDto {
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
    }

    /** 부서(행사)별 회원 등록 항목 */
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class RegisterEventMemberDto {
        private int eventPayUserId;     /*행사결제자ID*/
        private int memberId;           /*로그인 memberId*/
        private int eventPayLevel;      /*행사결제LEVEL*/
        private String eventPayRoleCd;  /*결재자역활구분*/
        private String useRegFlag;      /*등록권한*/
    }

    @Setter
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class PatchEventDto {
        private int eventId;
        private String eventNm;
        private String eventCode;
        private String eventStartDate;
        private String eventEndDate;
        private String payFlag;         /*결제구분*/
        private String eventLoc;
        private int eventHostId;
        private String eventComment;
        private String eventStatus;     /*행사진행상태*/
        private int eventRegId;         /*행사등록자ID*/
        private int eventBudgetAmount;  /*행사예산금액*/
        private int orgId;              /*단체ID*/
        private String defaultEventFlag;    /*기본행사여부*/
        private int highEventId;        /*상위행사ID*/
        private int eventLevel;         /*행사최하위여부*/
        private String eventFinalFlag;
        private String eventTp;
        private int eventPayDept;
        private int memberId; /*로그인 memberId*/
        private String useRegFlag;      /*등록권한*/
    }

}
