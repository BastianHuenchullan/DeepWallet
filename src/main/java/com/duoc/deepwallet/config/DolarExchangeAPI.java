package com.duoc.deepwallet.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class DolarExchangeAPI {

    @Value("${fastforex.base-url}")
    private String FastForexBaseUrl;

    @Bean
    public WebClient fastforexWebClient() {
        return WebClient.builder()
                .baseUrl(FastForexBaseUrl)
                .defaultHeader("Accept", "application/json")
                .build();
    }
}