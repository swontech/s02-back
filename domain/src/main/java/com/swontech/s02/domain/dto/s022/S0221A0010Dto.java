package com.swontech.s02.domain.dto.s022;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

public class S0221A0010Dto {

    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    public static class MobileInitRecentEvent {
        private int eventId;
        private String eventCode;   /*2022.11.17 kjy */
        private String eventNm;
        private String eventStartDate;
        private String eventEndDate;
        private int EventHostId;
        private String eventHostName;
        private String eventPath;   /*2022.11.21 kjy */
    }

    @Setter
    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    public static class MobileInitUserInfo {
        private int memberId;
        private int orgId;
        private String memberName;
        private String hpNo;
        private String mobileId;
        private String mobileLoginDate;
        private String orgEventName;
        private int eventId;
        private String eventCode;
        private String memberTp;
        private String eventNm;
        private String orgName;
        private String eventRole;
        private int defaultEventId;
        private String useRegFlag; /*2022.11.01 kjy add */
        private int eventHostId;    /*2022.11.28 kjy*/
    }

    @Setter
    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    public static class MobileInitUseStateCnt {
        private int cnt;
        private String useProStatus;
        private String useProStatusNm;
    }

    @Setter
    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    public static class MobileInitPayCnt {
        private int payCnt;
    }

    /*2022.11.09 kjy:부서코드조회 검색조건항목*/
    @Getter
    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    public static class SelectEventCodeParams {
        private String orgName;
        private String ceoName;
//        private String memberName;
//        private String eventNm;
    }
    /*2022.11.18 kjy:부서코드 조회결과 */
    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    public static class SelectEventList {
        private String eventCode;
        private String eventNm;
    }
}
