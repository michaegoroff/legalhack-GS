package com.example.fourLegal.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.fourLegal.services.OrchestratorService;

@RestController
@RequestMapping("/orchestrator")
public class OrchestratorController {
    private OrchestratorService orchestratorService;
    
    public OrchestratorController(OrchestratorService orchestratorService){
        this.orchestratorService = orchestratorService;
    }

    // Lunches the document processing workflow and returns the summary in JSON format.
    @GetMapping(value = "/process/document/{blobId}", produces = "application/json")
    public ResponseEntity<String> processBlob(@PathVariable("blobId") String blobId) throws Exception {
        return ResponseEntity.ok(orchestratorService.getDocumentSummary(blobId));
    }
}
