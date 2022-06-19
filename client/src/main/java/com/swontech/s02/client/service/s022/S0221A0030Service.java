package com.swontech.s02.client.service.s022;

import com.swontech.s02.domain.dto.comm.CustomResponse;
import com.swontech.s02.domain.logic.s022.S0221A0030Logic;
import com.swontech.s02.domain.store.s022.S0221A0030Store;
import org.springframework.stereotype.Service;

@Service
public class S0221A0030Service extends S0221A0030Logic {
    public S0221A0030Service(S0221A0030Store s0221A0030Store, CustomResponse response) {
        super(s0221A0030Store, response);
    }
}
