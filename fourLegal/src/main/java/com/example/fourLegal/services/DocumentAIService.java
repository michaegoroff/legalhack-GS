package com.example.fourLegal.services;
import com.example.fourLegal.configurations.DocumentAIServiceSettings;
import org.springframework.stereotype.Service;

import com.example.fourLegal.contract.FileDto;
import com.google.cloud.documentai.v1.Document;
import com.google.cloud.documentai.v1.DocumentProcessorServiceClient;
import com.google.cloud.documentai.v1.DocumentProcessorServiceSettings;
import com.google.cloud.documentai.v1.ProcessRequest;
import com.google.cloud.documentai.v1.ProcessResponse;
import com.google.cloud.documentai.v1.RawDocument;

import com.google.protobuf.ByteString;

@Service
public class DocumentAIService{
    private DocumentAIServiceSettings documentAIServiceSettings;
    
    // Variables needed for the Document AI API.
    // Google Cloud Project ID.
    private String projectId;
    // Google Cloud Project Location.
    private String location;
    // ID of the Document AI processor to use.
    private String processorId;

    public DocumentAIService(DocumentAIServiceSettings documentAIServiceSettings){
        this.documentAIServiceSettings = documentAIServiceSettings;
        this.projectId = this.documentAIServiceSettings.getProjectId();
        this.location = this.documentAIServiceSettings.getLocality();
        this.processorId = this.documentAIServiceSettings.getProcessorId();
    }

    //OCR processing of the document and returning the text.
    public String parseDocument(FileDto fileDto) throws Exception{
        String text;
        String endpoint = String.format("%s-documentai.googleapis.com:443", location);
        DocumentProcessorServiceSettings settings =
        DocumentProcessorServiceSettings.newBuilder().setEndpoint(endpoint).build();
        try (DocumentProcessorServiceClient client = DocumentProcessorServiceClient.create(settings)) {
            // The full resource name of the processor, e.g.:
            // projects/project-id/locations/location/processor/processor-id
            String resourceName =
                String.format("projects/%s/locations/%s/processors/%s", projectId, location, processorId);

            // Convert the image data to a Buffer and base64 encode it.
            ByteString content = ByteString.copyFrom(fileDto.getFileBytes());
            String contentType = fileDto.getContentType();

            RawDocument document =
                RawDocument.newBuilder().setContent(content).setMimeType(contentType).build();

            // Configure the process request.
            ProcessRequest request =
                ProcessRequest.newBuilder().setName(resourceName).setRawDocument(document).build();

            // Recognizes text entities in the PDF document
            ProcessResponse result = client.processDocument(request);
            Document documentResponse = result.getDocument();

            // Get all of the document text as one big string
            text = documentResponse.getText();
            
            // // Read the text recognition output from the processor
            // System.out.println("The document contains the following paragraphs:");
            // Document.Page firstPage = documentResponse.getPages(0);
            // List<Document.Page.Paragraph> paragraphs = firstPage.getParagraphsList();

            // for (Document.Page.Paragraph paragraph : paragraphs) {
            // String paragraphText = getText(paragraph.getLayout().getTextAnchor(), text);
            // System.out.printf("Paragraph text:\n%s\n", paragraphText);
            // }
        }
        return text;
    }
    // private String getText(Document.TextAnchor textAnchor, String text) {
    // if (textAnchor.getTextSegmentsList().size() > 0) {
    //   int startIdx = (int) textAnchor.getTextSegments(0).getStartIndex();
    //   int endIdx = (int) textAnchor.getTextSegments(0).getEndIndex();
    //   return text.substring(startIdx, endIdx);
    // }
    // return "[NO TEXT]";
    // }
}