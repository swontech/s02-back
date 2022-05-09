package com.swontech.s02.client.service.s022;

import com.swontech.s02.domain.dto.comm.ResponseDto;
import com.swontech.s02.domain.logic.s022.S022300050Logic;
import com.swontech.s02.domain.store.s022.S022300050Store;
import org.springframework.stereotype.Service;

@Service
public class S022300050Service extends S022300050Logic {
    public S022300050Service(S022300050Store s022300050Store, ResponseDto response) {
        super(s022300050Store, response);
    }
}
