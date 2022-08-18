package com.swontech.s02.client.service.s021;

import com.swontech.s02.domain.dto.comm.CustomResponse;
import com.swontech.s02.domain.logic.s021.S021100030Logic;
import com.swontech.s02.domain.store.s021.S021100030Store;
import org.springframework.stereotype.Service;

@Service
public class S021100030Service extends S021100030Logic {
    public S021100030Service(CustomResponse response, S021100030Store s021100030Store) {
        super(response, s021100030Store);
    }
}
