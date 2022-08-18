package com.swontech.s02.domain.vo.s021;

import lombok.Builder;

public class S021100050Vo {

    @Builder
    public static class SelectMemberListVo {
        private int orgId;
        private String memberName;
    }
}
