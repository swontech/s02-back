package com.swontech.s02.client.service.s022;

import com.swontech.s02.domain.common.util.PushNotificationLogic;
import com.swontech.s02.domain.dto.comm.CustomResponse;
import com.swontech.s02.domain.logic.s022.S0221A0080Logic;
import com.swontech.s02.domain.store.s022.S0221A0080Store;
import com.swontech.s02.domain.store.s022.S0221A0090Store;
import org.springframework.stereotype.Service;

@Service
public class S0221A0080Service extends S0221A0080Logic {
    public S0221A0080Service(CustomResponse response, S0221A0080Store s0221A0080Store, PushNotificationLogic pushNotificationLogic, S0221A0090Store s0221A0090Store) {
        super(response, s0221A0080Store, pushNotificationLogic, s0221A0090Store);
    }
}
