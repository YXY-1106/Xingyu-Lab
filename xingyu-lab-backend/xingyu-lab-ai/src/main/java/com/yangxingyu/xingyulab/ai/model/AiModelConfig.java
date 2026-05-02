package com.yangxingyu.xingyulab.ai.model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "ai")
public class AiModelConfig {
    private String apiKey;
    private String baseUrl;
    private String defaultModel;
    private Integer maxTokens;
    private Double temperature;
}
