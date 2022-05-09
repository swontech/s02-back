package com.swontech.s02.domain.vo.s022;

import lombok.Builder;
import lombok.Getter;

public class S022300080Vo {

    @Builder
    public static class SelectEnterListVo {
        private int eventId;
        private String hpNo;
        private String memberName;
        private String enterFlag;
    }

    @Builder
    @Getter
    public static class InsertEnterVo {
        private int eventId;
        private int memberId;
    }

    @Builder
    public static class DeleteEnterVo {
        private int eventId;
        private int memberId;
    }
}
