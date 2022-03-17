package com.swontech.s02.client.response;

import lombok.Getter;

@Getter
public enum ErrorCode {
    INVALID_PARAMETER(400, null, "Invalid Request Data")
    ;

    private final int status;
    private final String code;
    private final String message;

    ErrorCode(final int status, final String code, final String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }
}
