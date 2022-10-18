package com.swontech.s02.domain.spec.comm;

public interface S3BucketSpec {
    String upload(String base64, String dir);
    void delete (String fileId);
    String update(String fileId);

}
