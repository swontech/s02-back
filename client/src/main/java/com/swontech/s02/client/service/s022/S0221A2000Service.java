package com.swontech.s02.client.service.s022;

import com.swontech.s02.domain.dto.comm.ResponseDto;
import com.swontech.s02.domain.logic.s022.S0221A2000Logic;
import com.swontech.s02.domain.store.s022.S0221A2000Store;
import org.springframework.stereotype.Service;

@Service
public class S0221A2000Service extends S0221A2000Logic {
    public S0221A2000Service(S0221A2000Store s0221A2000Store, ResponseDto responseDto) {
        super(s0221A2000Store, responseDto);
    }
}
