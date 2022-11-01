package com.swontech.s02.domain.dto.comm;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Getter;
import lombok.Setter;

public class CommonDto {

    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    public static class SelectCodeResponse {
        private String cdV;
        private String cdVMeaning;
    }
    @Getter
    @Setter
    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    public class PagingReqDto {
        private int seq;
        private int totCnt;
        private String column;  /*sort column*/
        private String order;   /*sorting*/
        private int limit;   /*페이지당 출력 row수*/
        private int curPage; /*현재페이지번호*/
    }
}
