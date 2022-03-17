package com.swontech.s02.core;

/** ======================================================================================
 *  description     : 정규식 util 인터페이스
 *  author          : 민성현
 *  version         : 0.1
 *  see             : none
 *  since           : 2022.02.28
 *  ------------------------------------------------------------------------------------
 *  last modifier   : 민성현(2022.02.28)
 ======================================================================================= */

public interface RegExp {
    // 이메일 정규식
    public static final String REGEXP_EMAIL = "";
    // 패스워드 정규식
    public static final String REGEXP_PWD = "/^01([0|1|6|7|8|9])-?([0-9]{3,4})-?([0-9]{4})$/";
    // 회사명 정규식
    public static final String REGEXP_COMP = "";
    // 휴대전화 정규식
    public static final String REGEXP_PHONE = "/^01([0|1|6|7|8|9])-?([0-9]{3,4})-?([0-9]{4})$/";
}
