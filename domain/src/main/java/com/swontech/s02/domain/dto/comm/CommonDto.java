package com.swontech.s02.domain.dto.comm;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

public class CommonDto {

    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    public static class SelectCodeResponse {
        private String cdV;
        private String cdVMeaning;
    }
}
