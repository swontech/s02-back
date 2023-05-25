package com.swontech.s02.client.service.s022;

import com.swontech.s02.domain.logic.comm.PushNotificationLogic;
import com.swontech.s02.domain.dto.comm.CustomResponse;
import com.swontech.s02.domain.logic.s022.S0221A0060Logic;
import com.swontech.s02.domain.spec.comm.S3BucketSpec;
import com.swontech.s02.domain.store.s022.S0221A0060Store;
import com.swontech.s02.domain.store.s022.S0221A0090Store;
import org.springframework.stereotype.Service;

@Service
public class S0221A0060Service extends S0221A0060Logic {
    public S0221A0060Service(S0221A0060Store s0221A0060Store, CustomResponse response, S3BucketSpec s3BucketSpec, PushNotificationLogic pushNotificationLogic, S0221A0090Store s0221A0090Store) {
        super(s0221A0060Store, response, s3BucketSpec, pushNotificationLogic, s0221A0090Store);
    }
}
