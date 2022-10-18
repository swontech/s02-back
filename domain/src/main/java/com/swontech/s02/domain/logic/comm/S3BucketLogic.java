package com.swontech.s02.domain.logic.comm;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.swontech.s02.domain.common.exception.CustomException;
import com.swontech.s02.domain.common.exception.ExceptionEnum;
import com.swontech.s02.domain.spec.comm.S3BucketSpec;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;

import java.io.ByteArrayInputStream;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.UUID;

@Slf4j
public class S3BucketLogic implements S3BucketSpec {
    @Value("${cloud.aws.s3.bucket}")
    private String bucket;

    private final AmazonS3 amazonS3;
    public S3BucketLogic(AmazonS3 amazonS3) {
        this.amazonS3 = amazonS3;
    }

    @Override
    public String upload(String base64, String dir) {
        Date nowDate = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String fileName = UUID.randomUUID() + "_" + simpleDateFormat.format(nowDate);
        ObjectMetadata meta = new ObjectMetadata();

        bucket += "/storage/img/s02/" + dir;
        try {
            log.info(fileName);
            byte[] decodedFile = Base64.getMimeDecoder().decode(base64.substring(base64.indexOf(",") + 1));
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(decodedFile);

            meta.setContentLength(byteArrayInputStream.available());
            amazonS3.putObject(bucket, fileName, byteArrayInputStream, meta);

            return dir + "/" + fileName;
        } catch(Exception e) {
            throw e;
        }
    }

    @Override
    public void delete(String fileId) {
        try {
            amazonS3.deleteObject(bucket, fileId);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public String update(String fileId) {
        return null;
    }
}
