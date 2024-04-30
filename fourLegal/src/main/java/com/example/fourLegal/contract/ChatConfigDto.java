package com.example.fourLegal.contract;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ChatConfigDto {
    @JsonProperty("model_name")
    private String modelName;
    @JsonProperty("model_version")
    private String modelVersion;
    private double temperature;
    @JsonProperty("max_tokens")
    private int maxTokens;
    @JsonProperty("top_p")
    private int topP;
    @JsonProperty("frequency_penalty")
    private int frequencyPenalty;
    @JsonProperty("presence_penalty")
    private int presencePenalty;

    public String getModelName() {
        return modelName;
    }
    public void setModelName(String modelName) {
        this.modelName = modelName;
    }
    public String getModelVersion() {
        return modelVersion;
    }
    public void setModelVersion(String modelVersion) {
        this.modelVersion = modelVersion;
    }
    public double getTemperature() {
        return temperature;
    }
    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }
    public int getMaxTokens() {
        return maxTokens;
    }
    public void setMaxTokens(int maxTokens) {
        this.maxTokens = maxTokens;
    }
    public int getTopP() {
        return topP;
    }
    public void setTopP(int topP) {
        this.topP = topP;
    }
    public int getFrequencyPenalty() {
        return frequencyPenalty;
    }
    public void setFrequencyPenalty(int frequencyPenalty) {
        this.frequencyPenalty = frequencyPenalty;
    }
    public int getPresencePenalty() {
        return presencePenalty;
    }
    public void setPresencePenalty(int presencePenalty) {
        this.presencePenalty = presencePenalty;
    }

    
}
