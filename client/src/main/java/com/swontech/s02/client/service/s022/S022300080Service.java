package com.swontech.s02.client.service.s022;

import com.swontech.s02.domain.dto.comm.CustomResponse;
import com.swontech.s02.domain.logic.s022.S022300080Logic;
import com.swontech.s02.domain.store.s022.S022300080Store;
import org.springframework.stereotype.Service;

@Service
public class S022300080Service extends S022300080Logic {
    public S022300080Service(CustomResponse response, S022300080Store s022300080Store) {
        super(response, s022300080Store);
    }
}
