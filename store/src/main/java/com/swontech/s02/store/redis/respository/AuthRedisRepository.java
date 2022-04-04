package com.swontech.s02.store.redis.respository;

import com.swontech.s02.domain.store.comm.AuthRedisStore;
import com.swontech.s02.domain.vo.comm.AuthVo;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

@Repository
public class AuthRedisRepository implements AuthRedisStore {
    private final RedisTemplate<String, Object> redisTemplate;
    public AuthRedisRepository(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    /**
     * 로그인 redis store
     * <pre>
     *      redis 메모리에 refresh token을 저장하는 기능을 수행한다.
     *      refreshToken을 키 값, eamil을 value값으로 저장한다.
     *      지속시간을 3분으로 지정
     * </pre>
     * @param jwtTokenInfo
     * @param timeUnit
     *
     * {@link com.swontech.s02.domain.vo.s021.S021100020Vo}
     */
    @Override
    public void setRefreshToken(AuthVo.JwtTokenInfo jwtTokenInfo, TimeUnit timeUnit) {
        redisTemplate.opsForValue().set(jwtTokenInfo.getRefreshToken(), jwtTokenInfo.getEmail(), Duration.ofMinutes(3));
    }

    @Override
    public String isExistsToken(String refreshToken) {
        return null;
    }

    @Override
    public void reIssueRefreshToken(AuthVo.JwtTokenInfo jwtTokenInfo, TimeUnit timeUnit) {

    }

    @Override
    public void deleteRefreshToken(String refreshToken) {
        redisTemplate.delete(refreshToken);
    }
}
