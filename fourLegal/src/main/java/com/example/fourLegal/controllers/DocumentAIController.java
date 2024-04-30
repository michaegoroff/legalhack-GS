package com.example.fourLegal.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.fourLegal.services.DocumentAIService;
import com.example.fourLegal.services.StorageService;

@RestController
@RequestMapping("/document-ai")
public class DocumentAIController {

    private DocumentAIService documentAIService;
    private StorageService storageService;
    
    public DocumentAIController(DocumentAIService documentAIService, StorageService storageService){
        this.documentAIService = documentAIService;
        this.storageService = storageService;
    }

    // Gets the text from the document, placed in the Cloud Storage, using the blob ID.
    @GetMapping("/get/blob/{blobId}")
    public ResponseEntity<String> getText(@PathVariable("blobId") String blobId) throws Exception {
        var fileDto = storageService.getFile(blobId);
        return ResponseEntity.ok(documentAIService.parseDocument(fileDto));
    }
}
