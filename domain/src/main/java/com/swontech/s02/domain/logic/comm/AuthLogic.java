package com.swontech.s02.domain.logic.comm;

import com.swontech.s02.domain.common.security.JwtTokenProvider;
import com.swontech.s02.domain.dto.comm.AuthDto;
import com.swontech.s02.domain.dto.comm.CustomResponse;
import com.swontech.s02.domain.spec.comm.AuthSpec;
import com.swontech.s02.domain.store.comm.AuthRedisStore;
import com.swontech.s02.domain.vo.comm.AuthVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.util.ObjectUtils;

@Slf4j
public class AuthLogic implements AuthSpec {
    private final JwtTokenProvider jwtTokenProvider;
    private final AuthRedisStore authRedisStore;
    private final CustomResponse response;

    public AuthLogic(JwtTokenProvider jwtTokenProvider, AuthRedisStore authRedisStore, CustomResponse response) {
        this.jwtTokenProvider = jwtTokenProvider;
        this.authRedisStore = authRedisStore;
        this.response = response;
    }

    @Override
    public ResponseEntity<?> reIssueToken(String accessToken, String refreshToken) {
        // authentication 객체 생성
        Authentication authentication = jwtTokenProvider.getAuthentication(accessToken);

        // 이메일 key값으로 refresh토큰 가져오기
        String savedRefreshToken = authRedisStore.getRefreshToken(authentication.getName());

        // redis 메모리에 저장되어 있는 refresh 토큰이 없다면.
        if(ObjectUtils.isEmpty(refreshToken)) {
            log.info("저장된 refreshtoken이 없습니다.");
            return response.fail("저장된 RefreshToken이 없습니다.", HttpStatus.BAD_REQUEST);
        }

        // redis 메모리에 저장되어 있는 refresh 토큰과 요청으로 들어온 refresh토큰이 다르다면.
        if(!refreshToken.equals(refreshToken)) {
            log.info("저장된 refreshtoken과 다릅니다.");
            return response.fail("Refresh Token정보가 일치하지 않습니다.", HttpStatus.BAD_REQUEST);
        }

        AuthVo.JwtTokenInfo jwtTokenInfo = jwtTokenProvider.generateToken(authentication);
        authRedisStore.setRefreshToken(jwtTokenInfo);

        log.info("original access token: " + accessToken);
        log.info("original refresh token: " + refreshToken);
        log.info("saved refresh token: " + savedRefreshToken);
        log.info("new access token: " + jwtTokenInfo.getAccessToken());
        log.info("new refresh token: " + jwtTokenInfo.getRefreshToken());

        return response.success(jwtTokenInfo, "Refresh토큰과 AccessToken이 갱신되었습니다.", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> deleteToken(String email) {
        authRedisStore.deleteRefreshToken(email);

        return response.success("로그아웃 처리가 정상적으로 완료됐습니다.");
    }
}
