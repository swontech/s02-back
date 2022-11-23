package com.swontech.s02.domain.vo.s022;

import lombok.Builder;

public class S0221A2000Vo {

    @Builder
    public static class MoblieQRScanEventListVo {
        private int orgId;
        private String eventCode;
        private String eventNm;     /*2022.11.23 kjy 행사명검색*/
    }
}
