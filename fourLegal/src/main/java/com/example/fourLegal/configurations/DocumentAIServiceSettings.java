package com.example.fourLegal.configurations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.properties")
public class DocumentAIServiceSettings {
    @Value("${documentai.project.id}")
    private String projectId;
    @Value("${documentai.locality}")
    private String locality;
    @Value("${documentai.processor.id}")
    private String processorId;

    public String getProjectId(){
        return this.projectId;
    }
    public String getLocality(){
        return this.locality;
    }
    public String getProcessorId(){
        return this.processorId;
    }

}
