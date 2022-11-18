package com.swontech.s02.domain.dto.s021;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

/**
 * S021100010 단체관리 화면 Dto
 */
public class S021100010Dto {

    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    public static class OrgListResponse {
        private int seq;       /*2022.11.02 kjy paging*/
        private int orgId;
        private String orgName;
        private String telNo;
        private String memberName;
        private String email;
        private String memberCnt;
        private String orgCode;
        /*2022.11.02 kjy paging*/
        private int totCnt;
    }

    @Builder
    @Getter
    public static class OrgListParamsDto {
        private String orgName;
        private String memberName;
        /*2022.11.02 kjy paging*/
        private String column;  /*sort column*/
        private String order;   /*sorting*/
        private int limit;   /*v페이지당 출력 row수*/
        private int curPage; /*현재페이지번호*/
    }


}
