package com.swontech.s02.client.service.s021;

import com.swontech.s02.domain.dto.comm.CustomResponse;
import com.swontech.s02.domain.logic.s021.S021100090Logic;
import com.swontech.s02.domain.spec.comm.S3BucketSpec;
import com.swontech.s02.domain.store.s021.S021100090Store;
import org.springframework.stereotype.Service;

@Service
public class S021100090Service extends S021100090Logic {
    public S021100090Service(S021100090Store s021100090Store, CustomResponse response, S3BucketSpec s3BucketSpec) {
        super(s021100090Store, response, s3BucketSpec);
    }
}
