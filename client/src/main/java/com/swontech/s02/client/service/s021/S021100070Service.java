package com.swontech.s02.client.service.s021;

import com.swontech.s02.domain.dto.comm.CustomResponse;
import com.swontech.s02.domain.logic.s021.S021100070Logic;
import com.swontech.s02.domain.store.s021.S021100070Store;
import org.springframework.stereotype.Service;

@Service
public class S021100070Service extends S021100070Logic {
    public S021100070Service(CustomResponse response, S021100070Store s021100070Store) {
        super(response, s021100070Store);
    }
}
