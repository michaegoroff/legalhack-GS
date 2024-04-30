package com.example.fourLegal.services;

import com.example.fourLegal.configurations.StorageServiceSettings;
import org.springframework.stereotype.Service;

import com.example.fourLegal.contract.FileDto;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;

@Service
public class StorageService {
    private Storage storage;
    // Google Cloud Storage bucket name.
    private String bucketName;
    private StorageServiceSettings storageServiceSettings;

    public StorageService(StorageServiceSettings storageServiceSettings) {
        this.storageServiceSettings = storageServiceSettings;
        this.bucketName = this.storageServiceSettings.getBucketName();
        storage = StorageOptions.getDefaultInstance().getService();
    }

    public FileDto getFile(String blobId) {
        var blob = storage.get(bucketName, blobId);
        var fileDto = new FileDto();
        fileDto.setFileBytes(blob.getContent());
        fileDto.setContentType(blob.getContentType());
        return fileDto;
    }
}
