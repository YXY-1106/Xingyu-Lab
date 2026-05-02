package com.yangxingyu.xingyulab.framework.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Xingyu Lab API")
                        .version("1.0.0")
                        .description("兴宇实验室 API 接口文档")
                        .contact(new Contact()
                                .name("yangxingyu")
                                .url("https://github.com/yangxingyu")));
    }
}
