package com.swontech.s02.client.service.s021;

import com.swontech.s02.domain.dto.comm.CustomResponse;
import com.swontech.s02.domain.logic.s021.S021100040Logic;
import com.swontech.s02.domain.store.s021.S021100040Store;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class S021100040Service extends S021100040Logic {
    public S021100040Service(S021100040Store s021100040Store, CustomResponse response, PasswordEncoder passwordEncoder) {
        super(s021100040Store, response, passwordEncoder);
    }
}
