package com.swontech.s02.domain.vo.s022;

import lombok.Builder;

public class S0221A0010Vo {

    @Builder
    public static class MobileInitRecentEventVO {
        private int orgId;
        private String eventCode;
    }

    @Builder
    public static class MobileInitUserInfoVo {
        private String eventCode;
        private String hpNo;
    }

    @Builder
    public static class MobileInitUseStateCntVo {
        private String eventCode;
        private String hpNo;
    }

    @Builder
    public static class MobileInitPayCntVo {
        private String eventCode;
        private String hpNo;
    }
    /*2022.11.09 kjy:부서코드조회 검색조건항목*/
    @Builder
    public static class SelectEventCodeVo {
        private String orgName;
        private String ceoName;
        private String memberName;
        private String eventNm;
    }

}
