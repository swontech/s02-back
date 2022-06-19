package com.swontech.s02.domain.vo.s021;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

public class S021100010Vo {

    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SelectOrgListVo {
        private String orgName;
        private String memberName;
    }

    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UpdateOrgListVo {
        private String orgId;
    }
}
