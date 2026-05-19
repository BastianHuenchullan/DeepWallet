package com.duoc.deepwallet.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class DolarExchangeAPI {

    @Value("${dolarapi.base-url}")
    private String dolarapiBaseUrl;

    @Bean
    public WebClient dolarapiWebClient() {
        return WebClient.builder()
                .baseUrl(dolarapiBaseUrl)
                .defaultHeader("Accept", "application/json")
                .build();
    }
}