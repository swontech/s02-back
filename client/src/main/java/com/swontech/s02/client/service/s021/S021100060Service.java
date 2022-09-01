package com.swontech.s02.client.service.s021;

import com.swontech.s02.domain.dto.comm.CustomResponse;
import com.swontech.s02.domain.logic.s021.S021100060Logic;
import com.swontech.s02.domain.store.s021.S021100060Store;
import org.springframework.stereotype.Service;

@Service
public class S021100060Service extends S021100060Logic {
    public S021100060Service(CustomResponse response, S021100060Store s021100060Store) {
        super(response, s021100060Store);
    }
}
