package com.swontech.s02.domain.vo.s021;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

public class S021100010Vo {

    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SelectOrgListVo {
        // 단체명
        private String orgName;
        // 대표자 이름
        private String memberName;
    }

    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class DeleteOrgListVo {
        // 단체 ID
        private String orgId;
    }
}
