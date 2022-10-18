package com.swontech.s02.client.service.comm;

import com.amazonaws.services.s3.AmazonS3;
import com.swontech.s02.domain.logic.comm.S3BucketLogic;
import org.springframework.stereotype.Service;

@Service
public class S3BucketService extends S3BucketLogic {
    public S3BucketService(AmazonS3 amazonS3) {
        super(amazonS3);
    }
}
