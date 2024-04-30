package com.example.fourLegal.contract;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ChatResponseDto{

    @JsonProperty("openai_response")
    private String openAiResponse;

    public void setOpenAiResponse(String openAiResponse){
        this.openAiResponse = openAiResponse;
    } 

    public String getOpenAiResponse(){
        return this.openAiResponse;
    }

}