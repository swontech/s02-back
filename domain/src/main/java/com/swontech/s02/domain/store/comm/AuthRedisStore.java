package com.swontech.s02.domain.store.comm;

/**
 * 사용자 인증정보를 Redis
 *
 */

import com.swontech.s02.domain.vo.comm.AuthVo;

import java.util.concurrent.TimeUnit;

public interface AuthRedisStore {
    /**
     * 로그인
     * @param jwtTokenInfo
     * @param timeout
     */
    void setRefreshToken(AuthVo.JwtTokenInfo jwtTokenInfo, TimeUnit timeout);

    /**
     * refresh 토큰이 있는지 체크
     * @param refreshToken
     * @return
     */
    String isExistsToken(String refreshToken);


    /**
     * 토큰 갱신
     * @param jwtTokenInfo
     * @param timeUnit
     */
    void reIssueRefreshToken(AuthVo.JwtTokenInfo jwtTokenInfo, TimeUnit timeUnit);

    /**
     * 로그아웃
     */
    void deleteRefreshToken(String refreshToken);
}
