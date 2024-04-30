package com.example.fourLegal.configurations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.properties")
public class StorageServiceSettings {
    @Value("${storage.bucket.name}")
    private String bucketName;
    public String getBucketName(){
        return this.bucketName;
    }
}
