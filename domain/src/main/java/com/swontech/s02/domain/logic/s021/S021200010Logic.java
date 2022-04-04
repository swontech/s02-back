package com.swontech.s02.domain.logic.s021;

import com.swontech.s02.domain.dto.comm.ResponseDto;
import com.swontech.s02.domain.dto.s021.S021200010Dto;
import com.swontech.s02.domain.security.JwtTokenProvider;
import com.swontech.s02.domain.spec.s021.S021200010Spec;
import com.swontech.s02.domain.store.comm.AuthRedisStore;
import com.swontech.s02.domain.store.s021.S021200010Store;
import com.swontech.s02.domain.vo.comm.AuthVo;
import com.swontech.s02.domain.vo.s021.S021200010Vo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.concurrent.TimeUnit;

public class S021200010Logic implements S021200010Spec {
    private final S021200010Store s021200010Store;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final JwtTokenProvider jwtTokenProvider;
    private final AuthRedisStore authRedisStore;
    private final ResponseDto responseDto;
    private Logger logger = LoggerFactory.getLogger(S021200010Logic.class);

    public S021200010Logic(S021200010Store s021200010Store, AuthenticationManagerBuilder authenticationManagerBuilder, JwtTokenProvider jwtTokenProvider, AuthRedisStore authRedisStore, ResponseDto responseDto) {
        this.s021200010Store = s021200010Store;
        this.authenticationManagerBuilder = authenticationManagerBuilder;
        this.jwtTokenProvider = jwtTokenProvider;
        this.authRedisStore = authRedisStore;
        this.responseDto = responseDto;
    }

    @Override
    public ResponseEntity<?> logIn(S021200010Dto.LogIn logIn) throws Exception {
        try {
            // 회원가입된 정보가 없을 경우 UsernameNotFoundException을 발생시킨다.
            String memberEmail = s021200010Store.selectMemberEmail(
                    S021200010Vo.SelectMemberEmailVo.builder()
                            .email(logIn.getEmail())
                            .build());
            if(memberEmail == null) {
                throw new UsernameNotFoundException("회원가입된 이메일 정보가 없습니다");
            }

            /**
             * signIn EMAIL/PWD 를 기반으로 Authentication 객체 생성
             * authentication 는 인증 여부를 확인하는 authenticated 값이 false
             */
            UsernamePasswordAuthenticationToken authenticationToken = logIn.toAuthentication();

            /**
             * 실제 검증 (사용자 비밀번호 체크)이 이루어지는 부분
             * authenticate 매서드가 실행될 때 CustomUserDetailsService 에서 만든 loadUserByUsername 메서드가 실행
             */
            Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);

            /**
             * 토큰 생성
             * 인증되어 생성된 authentication 객채로 accessToken, refreshToken 정보를 생성한다.
             */
            AuthVo.JwtTokenInfo jwtTokenInfo = jwtTokenProvider.generateToken(authentication);

            /**
             * Redis 저장
             * 토큰정보를 Redis DB에 저장한다.
             */
            authRedisStore.setRefreshToken(jwtTokenInfo, TimeUnit.MILLISECONDS);

            /**
             * Client로 생성된 token 정보 리턴
             */
            return responseDto.success(jwtTokenInfo, "로그인 완료.", HttpStatus.OK);
        } catch (Exception e) {
            logger.info("Exception: ", e.getMessage());
            throw e;
        }
    }
}
