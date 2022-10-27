package com.swontech.s02.domain.vo.s021;

import lombok.Builder;

public class S021100030Vo {
    @Builder
    public static class SelectMemberListVo {
        private int orgId;
        private String fromDt;
        private String toDt;
        private String memberName;
        private String memberTp;
    }

    @Builder
    public static class UpdateMemberTp {
        private int memberId;
        private String memberTp;
        private int loginId;
    }
}
