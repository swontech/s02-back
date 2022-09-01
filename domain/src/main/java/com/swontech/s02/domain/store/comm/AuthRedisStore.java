package com.swontech.s02.domain.store.comm;

/**
 * 사용자 인증정보를 Redis
 *
 */

import com.swontech.s02.domain.vo.comm.AuthVo;

import java.util.concurrent.TimeUnit;

public interface AuthRedisStore {
    /** Refresh Token 저장 */
    void setRefreshToken(AuthVo.JwtTokenInfo jwtTokenInfo);

    /** Refresh 토큰이 있는지 체크 */
    String getRefreshToken(String email);

    /** Refresh 토큰 갱신 */
    void reIssueRefreshToken(AuthVo.JwtTokenInfo jwtTokenInfo, TimeUnit timeUnit);

    /** Refresh Token 삭제 */
    void deleteRefreshToken(String email);
}
