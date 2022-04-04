package com.swontech.s02.domain.security;

/**
 * @desc    : Jwt 토큰을 관리하는 유틸성 클래스 파일
 * <p>
 *      Request Header에 담긴 Token정보의 유효성 검증,
 *      새로운 accessToken 및 refreshToken의 생성,
 *      token의 갱신,
 *      token의 삭제(로그아웃)
 *      의 기능을 담당한다.
 * </p>
 * @version : 1.0
 * @author  : MSH
 * @since   : 2022.03.23
 *
 * {@link com.swontech.s02.domain.logic.s021.S021200010Logic#signIn(S021200010Dto.SignIn)} 에서 사용
 * ================================================
 * @lastmodify  : 2022.03.23 MSH
 *
 ================================================================================================================================================ */

import com.swontech.s02.domain.dto.s021.S021200010Dto;
import com.swontech.s02.domain.store.comm.AuthRedisStore;
import com.swontech.s02.domain.vo.comm.AuthVo;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.security.Key;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

@Component
public class JwtTokenProvider {
    private Logger logger = LoggerFactory.getLogger(JwtTokenProvider.class);

    private static final String AUTHORITIES_KEY = "auth";
    private static final String BEARER_TYPE = "Bearer";
    private static final long ACCESS_TOKEN_EXPIRE_TIME = 30 * 60 * 1000L;              // 30분
    private static final long REFRESH_TOKEN_EXPIRE_TIME = 7 * 24 * 60 * 60 * 1000L;    // 7일

    private final Key key;
    private final AuthRedisStore authRedisStore;
    public JwtTokenProvider(@Value("${jwt.secretkey}") String secretKey, AuthRedisStore authRedisStore) {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        this.key = Keys.hmacShaKeyFor(keyBytes);
        this.authRedisStore = authRedisStore;
    }

    /** =========================================================================================================
     *  accessToken 및 refreshToken을 신규 생성하는 메소드.
     * <p>
     *     JwtAuthenticationProvider에서 최종 생성된 authentication객체를 parameter로 받아
     *     새로운 accessToken 및 refreshToken을 생성한다.
     * </p>
     * @param   {Authentication}타입의 JwtAuthenticationProvider에서 생성된 인증 정보.
     * @return  {Authentication}타입의 사용자가 화면에서 입력한 이메일과 패스워드에 DB에서 조회한 사용자의 권한을 담은 Vo를 리턴한다.
     * @throws  RuntimeException
     * {@see    {@link com.swontech.s02.domain.logic.s021.S021200010Logic#logIn(S021200010Dto.LogIn)} (S021200010Dto.LogIn)}에서 호출한다.
     *          {@link com.swontech.s02.domain.vo.s021.S021200010Vo.JwtTokenInfo} 토큰정보가 담긴 Vo를 리턴한다.}
    ========================================================================================================= */
    public AuthVo.JwtTokenInfo generateToken(Authentication authentication) {
        String email = authentication.getName();    // 이메일
        String accessToken;                         // accessToken
        String refreshToken;                        // refreshToken
        Date accessTokenExpiresIn;                  // access token 만료 일자
        Date refreshTokenExpiresIn;                 // refresh token 만료 일자

        /**
         * parameter로 받은 Authentication객체로부터 authorities권한을 String으로 파싱한다.
         */
        String authorities = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining());

        /**
         * 현재시간
         */
        long now = (new Date()).getTime();

        /**
         * Access Token 생성
         */
        accessTokenExpiresIn = new Date(now + ACCESS_TOKEN_EXPIRE_TIME);
        accessToken = Jwts.builder()
                .setSubject(authentication.getName())
                .claim(AUTHORITIES_KEY, authorities)
                .setExpiration(accessTokenExpiresIn)
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();

        /**
         * Refresh Token 생생
         */
        refreshTokenExpiresIn = new Date(now + REFRESH_TOKEN_EXPIRE_TIME);
        refreshToken = Jwts.builder()
                .setExpiration(refreshTokenExpiresIn)
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();

        return AuthVo.JwtTokenInfo.builder()
                .grantType(BEARER_TYPE)
                .refreshTokenExpirationTime(REFRESH_TOKEN_EXPIRE_TIME)
                .email(email)
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();

    }

    /**
     *  Jwt Access Token을 복호화하여 토큰에 들어있는 정보를 꺼낸다
     */
    public Authentication getAuthentication(String accessToken) {
        Claims claims = parseClaims(accessToken);
        if(claims.get(AUTHORITIES_KEY) == null) {
            throw new RuntimeException();
        }

        // 클레임에서 정보 가져오기
        Collection<? extends GrantedAuthority> authorities =
                Arrays.stream(claims.get(AUTHORITIES_KEY).toString().split(""))
                        .map(SimpleGrantedAuthority::new)
                        .collect(Collectors.toList());

        // UserDetails 객체를 만들어서 Authentication 리턴
        UserDetails principal = new User(claims.getSubject(), "", authorities);
        return new UsernamePasswordAuthenticationToken(principal, "", authorities);
    }


    /**
     *  Request Header에 담긴 토큰의 유효성을 검증하는 메소드.
     * <p>
     *     JwtAuthenticationFilter에서 토큰정보를 parameter로 받아 토큰의 기초적인 검증을 한다.
     * </p>
     * @param   {String}타입의 토큰 문자열
     * @return  {boolean}타입의 유효성 검증 결과
     * {@see    {@link com.swontech.s02.domain.security.JwtAuthenticationFilter#doFilter(ServletRequest, ServletResponse, FilterChain)}
     */
    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
            return true;
        } catch (io.jsonwebtoken.security.SecurityException | MalformedJwtException e) {
            logger.info("INVALID JWT");
        } catch (ExpiredJwtException e) {
            logger.info("EXPIRED JWT");
        } catch (UnsupportedJwtException e) {
            logger.info("UNSUPPORTED JWT");
        } catch (IllegalArgumentException e) {
            logger.info("JWT CLAIMS STRING IS EMPTY");
        }
        return false;
    }



    /**
     *  access token을 파싱하여
     * <p>
     *     JwtAuthenticationFilter에서 토큰정보를 parameter로 받아 토큰의 기초적인 검증을 한다.
     * </p>
     * @param   {String}타입의 토큰 문자열
     * @return  {boolean}타입의 유효성 검증 결과
     * {@see    {@link com.swontech.s02.domain.security.JwtAuthenticationFilter#doFilter(ServletRequest, ServletResponse, FilterChain)}
     */
    private Claims parseClaims(String accessToken) {
        try {
            return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(accessToken).getBody();
        } catch (ExpiredJwtException e) {
            return e.getClaims();
        }
    }
}
