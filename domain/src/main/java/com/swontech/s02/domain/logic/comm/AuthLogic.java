package com.swontech.s02.domain.logic.comm;

import com.swontech.s02.domain.security.JwtTokenProvider;
import com.swontech.s02.domain.dto.comm.AuthDto;
import com.swontech.s02.domain.dto.comm.ResponseDto;
import com.swontech.s02.domain.spec.comm.AuthSpec;
import com.swontech.s02.domain.store.comm.AuthRedisStore;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.util.ObjectUtils;

public class AuthLogic implements AuthSpec {
    private final JwtTokenProvider jwtTokenProvider;
    private final AuthRedisStore authRedisStore;
    private final ResponseDto responseDto;

    public AuthLogic(JwtTokenProvider jwtTokenProvider, AuthRedisStore authRedisStore, ResponseDto responseDto) {
        this.jwtTokenProvider = jwtTokenProvider;
        this.authRedisStore = authRedisStore;
        this.responseDto = responseDto;
    }

    @Override
    public ResponseEntity<?> reIssueToken(AuthDto.ReIssue reIssue) {
        // authentication 객체 생성
        Authentication authentication = jwtTokenProvider.getAuthentication(reIssue.getAccessToken());

        // 이메일 key값으로 refresh토큰 가져오기
        String refreshToken = authRedisStore.isExistsToken(authentication.getName());

        // redis 메모리에 저장되어 있는 refresh 토큰이 없다면.
        if(ObjectUtils.isEmpty(refreshToken)) {
            return responseDto.fail("잘못된 요청입니다.", HttpStatus.BAD_REQUEST);
        }

        // redis 메모리에 저장되어 있는 refresh 토큰과 요청으로 들어온 refresh토큰이 다르다면.
        if(!refreshToken.equals(reIssue.getRefreshToken())) {
            return responseDto.fail("Refresh Token정보가 일치하지 않습니다.", HttpStatus.BAD_REQUEST);
        }



//        // 토큰을 갱신
//        authRedisStore.reIssueRefreshToken();
//
//        return response.success("토큰이 갱신되었습니다.",  ,HttpStatus.OK);
        return null;
    }

    @Override
    public ResponseEntity<?> deleteToken() {
        return null;
    }
}
