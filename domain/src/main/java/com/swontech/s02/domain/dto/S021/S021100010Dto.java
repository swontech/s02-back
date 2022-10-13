package com.swontech.s02.domain.dto.s021;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

/**
 * S021100010 단체관리 화면 Dto
 */
public class S021100010Dto {

    @Builder
    @Getter
    @AllArgsConstructor
    public static class OrgListResponse {
        private int orgId;
        private String orgName;
        private String telNo;
//        private String hpNo;
        private String memberName;
        private String email;
        private String memberCnt;
        private String orgCode;
    }
}
