package com.swontech.s02.client.service.s021;

import com.swontech.s02.domain.dto.comm.CustomResponse;
import com.swontech.s02.domain.logic.s021.S021100050Logic;
import com.swontech.s02.domain.store.s021.S021100050Store;
import org.springframework.stereotype.Service;

@Service
public class S021100050Service extends S021100050Logic {
    public S021100050Service(S021100050Store s021100050Store, CustomResponse response) {
        super(s021100050Store, response);
    }
}
