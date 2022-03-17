package com.swontech.s02.core;

import org.springframework.stereotype.Component;

/** ======================================================================================
 *  description     : 상수 컴포넌트 클래스
 *  author          : 민성현
 *  version         : 0.1
 *  see             : none
 *  since           : 2022.02.28
 *  ------------------------------------------------------------------------------------
 *  last modifier   : 민성현(2022.02.28)
 ======================================================================================= */
@Component
public interface Constants {
    // DML 타입
    public static final String DML_TP_INSERT = "I";
    public static final String DML_TP_UPDATE = "U";
    public static final String DML_TP_DELETE = "D";

    // 이메일
    public static final String INVALID_EMAIL = "유효하지 않은 메일 주소입니다.";
    public static final String NOT_BLANK_EMAIL = "이메일은 필수 입력 값입니다.";
    public static final String NOT_REGSTRIED_EMAIL = "등록된 이메일 정보가 없습니다.";

    // 패스워드
    public static final String INVALID_PWD = "비밀번호 형식에 맞지 않습니다.";
    public static final String NOT_BLANK_PWD = "비밀번호는 필수 입력 값입니다.";
    public static final String INCORRECT_PWD = "비밀번호가 맞지 않습니다.";
}
