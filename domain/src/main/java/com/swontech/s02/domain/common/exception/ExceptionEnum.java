package com.swontech.s02.domain.common.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.jsonwebtoken.ExpiredJwtException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ExceptionEnum {

    // Jwt Auth
    INVALID_JWT(401, "A001", "Invalid Jwt... 잘못된 형식의 JWT입니다."),
    EXPIRED_JWT(401, "A002", "Expired Jwt... 기간이 만료된 JWT입니다."),
    UNSUPPORTED_JWT(401, "A003", "Unsupported Jwt... JWT의 형식과 구성이 올바르지 않습니다."),
    CLAIMS_EMPTY_JWT(401, "A004", "Claims is Empty... JWT의 기존 서명을 확인하지 못했습니다."),

    // 인증 정보 에러
    USER_NOT_FOUND(403, "A005", "가입된 이메일 정보가 없습니다."),
    PASSWORD_INCORRECT(403, "A006", "비밀번호가 일치하지 않습니다."),

    // AWS관련 오류
    FILE_UPLOAD_FAIL(500, "B001", "S3버킷에 파일을 업로드하는데 실패했습니다.")
    ;


    private int status;
    private String code;
    private String message;

    ExceptionEnum(int status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }
    public String getCode() {
        return this.code;
    }
    public String getMessage() {
        return this.message;
    }
}
