package com.swontech.s02.domain.dto.s022;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public class S022300080Dto {

    @Setter
    @Getter
    public static class RetrieveAttendList {
        private Integer eventId;
        private String memberName;
        private String hpNo;
        private String enterFlag;
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
    }
}
