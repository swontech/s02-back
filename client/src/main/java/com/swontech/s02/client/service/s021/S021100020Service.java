package com.swontech.s02.client.service.s021;

import com.swontech.s02.domain.dto.comm.CustomResponse;
import com.swontech.s02.domain.logic.s021.S021100020Logic;
import com.swontech.s02.domain.store.s021.S021100020Store;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class S021100020Service extends S021100020Logic {
    public S021100020Service(S021100020Store s021100020Store, PasswordEncoder passwordEncoder, CustomResponse responseDto) {
        super(s021100020Store, passwordEncoder, responseDto);
    }
}
