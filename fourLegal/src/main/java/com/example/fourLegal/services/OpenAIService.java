package com.example.fourLegal.services;

import java.util.List;

import com.example.fourLegal.configurations.OpenAIServiceSettings;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.example.fourLegal.contract.ChatConfigDto;
import com.example.fourLegal.contract.ChatResponseDto;
import com.example.fourLegal.contract.DataRawDto;
import com.example.fourLegal.contract.PromptDto;
@Service
public class OpenAIService{

    private RestClient client;
    //openai instance configuration dto
    private ChatConfigDto chatConfigDto;
    private OpenAIServiceSettings openAIServiceSettings;

    public OpenAIService(OpenAIServiceSettings openAIServiceSettings){
        this.openAIServiceSettings = openAIServiceSettings;
        chatConfigDto = new ChatConfigDto();
        chatConfigDto.setModelName(this.openAIServiceSettings.getModelName());
        chatConfigDto.setModelVersion(this.openAIServiceSettings.getModelVersion());
        chatConfigDto.setTemperature(0.0);
        chatConfigDto.setMaxTokens(25000);
        chatConfigDto.setTopP(1);
        chatConfigDto.setFrequencyPenalty(0);
        chatConfigDto.setPresencePenalty(0);

        client = RestClient.create();
    }

    //sends request to openai
    public ChatResponseDto sendPrompt(List<PromptDto> prompts){
        var data = new DataRawDto();
        data.setUserId(openAIServiceSettings.getUserId());
        data.setConfig(chatConfigDto);
        data.setPrompt(prompts);

        var response = client.post()
            .uri(openAIServiceSettings.getEndpoint())
            .header("Ocp-Apim-Subscription-Key", openAIServiceSettings.getSubscriptionKey())
            .header("Content-Type", "application/json")
            .body(data)
            .retrieve()
            .body(ChatResponseDto.class);
        return response;
    }
}