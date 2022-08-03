package com.swontech.s02.domain.vo.comm;

import lombok.Builder;

public class CommonVo {

    @Builder
    public static class SelectCodeVo {
        private String category;
        private String cdTp;
        private int orgId;
    }
}
