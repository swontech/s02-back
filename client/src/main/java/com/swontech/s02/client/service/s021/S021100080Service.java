package com.swontech.s02.client.service.s021;

import com.swontech.s02.domain.dto.comm.CustomResponse;
import com.swontech.s02.domain.logic.s021.S021100080Logic;
import com.swontech.s02.domain.store.s021.S021100080Store;
import org.springframework.stereotype.Service;

@Service
public class S021100080Service extends S021100080Logic {
    public S021100080Service(CustomResponse response, S021100080Store s021100080Store) {
        super(response, s021100080Store);
    }
}
