package com.swontech.s02.client.service.comm;

import com.swontech.s02.domain.common.security.JwtTokenProvider;
import com.swontech.s02.domain.dto.comm.CustomResponse;
import com.swontech.s02.domain.logic.comm.AuthLogic;
import com.swontech.s02.domain.store.comm.AuthRedisStore;
import org.springframework.stereotype.Service;

@Service
public class AuthService extends AuthLogic {
    public AuthService(JwtTokenProvider jwtTokenProvider, AuthRedisStore authRedisStore, CustomResponse customResponse) {
        super(jwtTokenProvider, authRedisStore, customResponse);
    }
}
