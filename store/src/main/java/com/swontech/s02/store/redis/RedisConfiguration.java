package com.swontech.s02.store.redis;

/**
 * Redis의 기본적인 설정을 환경설정 클래스 파일
 * <p>
 *      Lettuce를 사용한다.
 * </p>
 * @version : 1.0
 * @author  : MSH
 * @since   : 2022.03.23
 * ================================================
 * @lastmodify  : 2022.03.23 MSH
 *
 */
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
@EnableRedisRepositories
public class RedisConfiguration {
    @Value("${redis.host}")
    private String redisHost;
    @Value("${redis.port}")
    private int redisPort;

    /**
     * lettuce이용하여 Redis저장소와의 연결을 위한 RedisConnectionFactory 빈 생성
     * @return {@RedisConnectionFactory}에 host와 port를 설정한 LettuceConnectionFactory를 리턴한다.
     */
    @Bean
    public RedisConnectionFactory redisConnectionFactory() {
        return new LettuceConnectionFactory(redisHost, redisPort);
    }

    /**
     * RedisConnectionFactory를 통하여 RedisTemplate 빈 생성
     * @return {@RedisTemplate}을 생성하여 빈으로 리턴한다.
     */
    @Bean
    public RedisTemplate<?, ?> redisTemplate() {
        RedisTemplate<byte[], byte[]> redisTemplate = new RedisTemplate<>();
        // 아래 두 라인을 작성하지 않으면, key값이 \xac\xed\x00\x05t\x00\x03sol 이렇게 조회된다.
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new StringRedisSerializer());
        redisTemplate.setConnectionFactory(redisConnectionFactory());
        return redisTemplate;
    }
}
