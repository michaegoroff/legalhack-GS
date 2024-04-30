package com.example.fourLegal.contract;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DataRawDto{
    @JsonProperty("user_id")
    private String userId;
    @JsonProperty("chat_completions_config")
    private ChatConfigDto config;
    @JsonProperty("prompt")
    private List<PromptDto> prompt = new ArrayList<>();

    public String getUserId(){
        return this.userId;
    }
    public ChatConfigDto getConfig(){
        return this.config;
    }
    public List<PromptDto> getPrompt(){
        return this.prompt;
    }
    public void setUserId(String value){
        this.userId = value;
    }
    public void setConfig(ChatConfigDto value){
        this.config = value;
    }
    public void setPrompt(List<PromptDto> value){
        this.prompt = value;
    }

}