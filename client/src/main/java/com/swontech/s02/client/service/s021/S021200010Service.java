package com.swontech.s02.client.service.s021;

import com.swontech.s02.domain.dto.comm.ResponseDto;
import com.swontech.s02.domain.logic.s021.S021200010Logic;
import com.swontech.s02.domain.common.security.JwtTokenProvider;
import com.swontech.s02.domain.store.comm.AuthRedisStore;
import com.swontech.s02.domain.store.s021.S021200010Store;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.stereotype.Service;

@Service
public class S021200010Service extends S021200010Logic {
    public S021200010Service(S021200010Store s021200010Store, AuthenticationManagerBuilder authenticationManagerBuilder, JwtTokenProvider jwtTokenProvider, AuthRedisStore authRedisStore, ResponseDto responseDto) {
        super(s021200010Store, authenticationManagerBuilder, jwtTokenProvider, authRedisStore, responseDto);
    }
}
