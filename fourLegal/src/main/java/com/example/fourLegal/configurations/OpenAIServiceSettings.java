package com.example.fourLegal.configurations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.properties")
public class OpenAIServiceSettings {
    @Value("${azure.user.id}")
    private String userId;
    @Value("${azure.subscription.key}")
    private String subscriptionKey;
    @Value("${azure.openai.endpoint}")
    private String endpoint;

    @Value("${openai.model.name}")
    private String modelName;
    @Value("${openai.model.version}")
    private String modelVersion;

    public String getUserId(){
        return this.userId;
    }
    public String getSubscriptionKey(){
        return this.subscriptionKey;
    }

    public String getModelName(){
        return this.modelName;
    }

    public String getModelVersion(){
        return this.modelVersion;
    }

    public String getEndpoint(){
        return this.endpoint;
    }
}
