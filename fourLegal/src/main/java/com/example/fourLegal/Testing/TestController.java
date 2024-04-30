package com.example.fourLegal.Testing;

import org.springframework.web.bind.annotation.RestController;

import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import com.google.protobuf.ByteString;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.cloud.documentai.v1.Document;
import com.google.cloud.documentai.v1.DocumentProcessorServiceClient;
import com.google.cloud.documentai.v1.DocumentProcessorServiceSettings;
import com.google.cloud.documentai.v1.ProcessRequest;
import com.google.cloud.documentai.v1.ProcessResponse;
import com.google.cloud.documentai.v1.RawDocument;


@RestController
@RequestMapping("/tests")
public class TestController {

    private String projectId = "key-buttress-416712";
    private String location = "eu";
    private String processorId = "b4ea3c9d1d50545b";
    private String filePath = "fourLegal/src/main/resources/files/test.pdf";

    @GetMapping("/storage")
    public String testStorage() {
        var value = "Hello, guys!";
        var bytes = value.getBytes();

        Storage storage = StorageOptions.getDefaultInstance().getService();
        Bucket bucket = storage.get("lh24-bucket");
        bucket.create("hello", bytes, "text/plain");
        return "Storage is working";
    }

    @GetMapping("/processdocument")
    public String processDocument()
    throws Exception {
        String text;
          String endpoint = String.format("%s-documentai.googleapis.com:443", location);
          DocumentProcessorServiceSettings settings =
          DocumentProcessorServiceSettings.newBuilder().setEndpoint(endpoint).build();
          try (DocumentProcessorServiceClient client = DocumentProcessorServiceClient.create(settings)) {
      // The full resource name of the processor, e.g.:
      // projects/project-id/locations/location/processor/processor-id
      // You must create new processors in the Cloud Console first
      String name =
          String.format("projects/%s/locations/%s/processors/%s", projectId, location, processorId);

      // Read the file.
      byte[] imageFileData = Files.readAllBytes(Paths.get(filePath));

      // Convert the image data to a Buffer and base64 encode it.
      ByteString content = ByteString.copyFrom(imageFileData);

      RawDocument document =
          RawDocument.newBuilder().setContent(content).setMimeType("application/pdf").build();

      // Configure the process request.
      ProcessRequest request =
          ProcessRequest.newBuilder().setName(name).setRawDocument(document).build();

      // Recognizes text entities in the PDF document
      ProcessResponse result = client.processDocument(request);
      Document documentResponse = result.getDocument();

      // Get all of the document text as one big string
      text = documentResponse.getText();
      
      // Read the text recognition output from the processor
      System.out.println("The document contains the following paragraphs:");
      Document.Page firstPage = documentResponse.getPages(0);
      List<Document.Page.Paragraph> paragraphs = firstPage.getParagraphsList();

      for (Document.Page.Paragraph paragraph : paragraphs) {
        String paragraphText = getText(paragraph.getLayout().getTextAnchor(), text);
        System.out.printf("Paragraph text:\n%s\n", paragraphText);
        }
        }
        return text;
    }

    private String getText(Document.TextAnchor textAnchor, String text) {
    if (textAnchor.getTextSegmentsList().size() > 0) {
      int startIdx = (int) textAnchor.getTextSegments(0).getStartIndex();
      int endIdx = (int) textAnchor.getTextSegments(0).getEndIndex();
      return text.substring(startIdx, endIdx);
    }
    return "[NO TEXT]";
  }
        

    
    
}
