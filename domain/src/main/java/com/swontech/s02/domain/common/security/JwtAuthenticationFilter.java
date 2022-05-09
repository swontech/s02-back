package com.swontech.s02.domain.common.security;
/**
 * OncePerRequestFilter를 상속받은 커스텀 인증 필터 클래스 파일
 * <p>
 *      request요청이 들어오면 가장 먼저 실행되어
 *      토큰의 존재 및 유효성 검증 여부, 사용자 로그인 상태 확인 등을 진행한다.
 * </p>
 * @version : 1.0
 * @author  : MSH
 * @since   : 2022.03.24
 *
 * @see     : {@link com.swontech.s02.config.WebSecurityConfiguration}
 * ================================================
 * @lastmodify  : 2022.03.24 MSH
 *
 */
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private static final String AUTHORIZATION_HEADER = "Authorization";
    private static final String BEARER_TYPE = "Bearer ";

    private final JwtTokenProvider jwtTokenProvider;
    public JwtAuthenticationFilter(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        //1. Request Header 에서 JWT 토큰 추출
        String accessToken = resolveAccessToken(request);

        //TODO[Feat]: refresh & access 토큰 갱신 기능 추가
        //2. AccessToken이 존재하고 유효하다면
        if(accessToken != null && jwtTokenProvider.validateToken(accessToken)) {
            //3. Authentication생성
            Authentication authentication = jwtTokenProvider.getAuthentication(accessToken);

            //4. Security Context에 authentication 저장
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        filterChain.doFilter(request, response);
    }

    /**
     *  Request Header 에서 토큰 정보 추출
     * <p>
     *     요청 Request의 Header에 담긴 토큰 정보를 추출하여 반환한다.
     * </p>
     * @param   {HttpServletRequest}타입의 요청 Request
     * @return  {String}타입의 Request Header로부터 추출한 토큰
     */
    private String resolveAccessToken(HttpServletRequest request) {
        String bearerAccessToken = request.getHeader(AUTHORIZATION_HEADER);
        if (StringUtils.hasText(bearerAccessToken) && bearerAccessToken.startsWith(BEARER_TYPE)) {
            return bearerAccessToken.substring(7);
        }
        return null;
    }
}
