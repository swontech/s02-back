package com.swontech.s02.domain.common.exception;

public class CustomException extends RuntimeException {
    private static final long serialVersionUID = 1133942101198931627L;

    private ExceptionEnum exceptionEnum;
    public CustomException(ExceptionEnum exceptionEnum) {
        super(exceptionEnum.getMessage());
        this.exceptionEnum = exceptionEnum;
    }

    public CustomException(ExceptionEnum exceptionEnum, String message) {
        super(message);
        this.exceptionEnum = exceptionEnum;
    }

    public CustomException(ExceptionEnum exceptionEnum, String message, Throwable cause) {
        super(message, cause);
        this.exceptionEnum = exceptionEnum;
    }

    public CustomException(ExceptionEnum exceptionEnum, Throwable cause) {
        super(cause);
        this.exceptionEnum = exceptionEnum;
    }

    public ExceptionEnum getExceptionEnum() {
        return this.exceptionEnum;
    }
}
