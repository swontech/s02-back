package com.swontech.s02.client.service.s021;

import com.swontech.s02.domain.dto.comm.CustomResponse;
import com.swontech.s02.domain.logic.s021.S021100010Logic;
import com.swontech.s02.domain.store.s021.S021100010Store;
import org.springframework.stereotype.Service;

@Service
public class S021100010Service extends S021100010Logic {
    public S021100010Service(S021100010Store s021100010Store, CustomResponse response) {
        super(s021100010Store, response);
    }
}
