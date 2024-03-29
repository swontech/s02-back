package com.swontech.s02.domain.dto.s022;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.swontech.s02.domain.vo.s022.S022300080Vo;
import lombok.Getter;
import lombok.Setter;

public class S022300080Dto {

    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    public static class SelectEventLov {
        private String eventNm;
        private int eventId;
    }

    @Setter
    @Getter
    public static class RetrieveAttendList {
        private Integer eventId;
        private String memberName;
        private String hpNo;
        private String enterFlag;
        /*2022.11.02 kjy paging*/
        private String column;  /*sort column*/
        private String order;   /*sorting*/
        private int limit;   /*v페이지당 출력 row수*/
        private int curPage; /*현재페이지번호*/
    }

    @Setter
    @Getter
    public static class RegisterAttend {
        private Integer memberId;
        private Integer eventId;
    }

    @Setter
    @Getter
    public static class DeleteAttend {
        private Integer memberId;
        private Integer eventId;
    }

    @Setter
    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    public static class AttendListResponse {
        private int seq;       /*2022.11.02 kjy paging*/
        private int memberId;
        private String memberName;
        private String hpNo;
        private int eventId;
        private String enterDate;
        private String enterFlag;
        private String eventNm;
        private String eventStartDate;
        private String eventEndDate;
        private int orgId;
        private String orgName;
        /*2022.11.02 kjy paging*/
        private int totCnt;
    }


}
