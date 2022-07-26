package com.swontech.s02.client.service.s022;

import com.swontech.s02.domain.dto.comm.CustomResponse;
import com.swontech.s02.domain.logic.s022.S0221A0090Logic;
import com.swontech.s02.domain.store.s022.S0221A0090Store;
import org.springframework.stereotype.Service;

@Service
public class S0221A0090Service extends S0221A0090Logic {
    public S0221A0090Service(CustomResponse response, S0221A0090Store s0221A0090Store) {
        super(response, s0221A0090Store);
    }
}
