package com.example.fourLegal.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.fourLegal.contract.PromptDto;
import com.example.fourLegal.helpers.PromptHolder;
import com.example.fourLegal.helpers.TemplateCheckHelper;

@Service
public class OrchestratorService {
    private PromptHolder promptHolder;
    private OpenAIService openAIService;
    private DocumentAIService documentAIService;
    private StorageService storageService;
    private TemplateCheckHelper templateCheckHelper;

    public OrchestratorService
    (
        OpenAIService openAIService, 
        DocumentAIService documentAIService, 
        StorageService storageService, 
        PromptHolder promptHolder,
        TemplateCheckHelper templateCheckHelper
    ) {
        this.openAIService = openAIService;
        this.documentAIService = documentAIService;
        this.storageService = storageService;
        this.promptHolder = promptHolder;
        this.templateCheckHelper = templateCheckHelper;
    }
    
    // Returns a summary of the document in JSON format after processing it through Document AI OCR and two OpenAI Prompts.
    // The first OpenAI Prompt is used to analyze the document and the second OpenAI Prompt is used to generate a JSON summary.
    // The document is retrieved from the Cloud Storage using the blob ID.   
    public String getDocumentSummary(String blobId) throws Exception {
        var fileDto = storageService.getFile(blobId);
        System.out.println("File retrieved from the Cloud Storage");

        var documentText = documentAIService.parseDocument(fileDto);
        System.out.println("OCR completed");

        var analysisPrompt = promptHolder.getDocumentAnalysis(documentText);
        var promptDto = new PromptDto();
        promptDto.setContent(analysisPrompt);
        promptDto.setRole("assistant");
        var analysisResponse = openAIService.sendPrompt(List.of(promptDto));
        System.out.println("Document analysis completed");
         
        var documentType = templateCheckHelper.determineDocumentType(analysisResponse);

        var jsonPrompt = promptHolder.getJsonPrompt(analysisResponse.getOpenAiResponse(), documentType);
        promptDto.setContent(jsonPrompt);
        var jsonResponse = openAIService.sendPrompt(List.of(promptDto));
        System.out.println("Json generation completed");

        var finalJson = jsonResponse.getOpenAiResponse().replaceAll("\\s+", " ");

        return finalJson;
    }
}
