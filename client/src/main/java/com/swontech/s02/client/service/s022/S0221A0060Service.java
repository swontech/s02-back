package com.swontech.s02.client.service.s022;

import com.swontech.s02.domain.dto.comm.CustomResponse;
import com.swontech.s02.domain.logic.s022.S0221A0060Logic;
import com.swontech.s02.domain.store.s022.S0221A0060Store;
import org.springframework.stereotype.Service;

@Service
public class S0221A0060Service extends S0221A0060Logic {
    public S0221A0060Service(S0221A0060Store s0221A0060Store, CustomResponse response) {
        super(s0221A0060Store, response);
    }
}
