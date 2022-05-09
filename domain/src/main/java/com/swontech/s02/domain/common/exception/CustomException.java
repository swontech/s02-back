package com.swontech.s02.domain.common.exception;

public class CustomException extends RuntimeException {
    private ExceptionEnum exceptionEnum;

    public CustomException(String message, ExceptionEnum exceptionEnum) {
        super(message);
        this.exceptionEnum = exceptionEnum;
    }

    public CustomException(ExceptionEnum exceptionEnum) {
        super(exceptionEnum.getMessage());
        this.exceptionEnum = exceptionEnum;
    }

    public ExceptionEnum getExceptionEnum() {
        return this.exceptionEnum;
    }
}
