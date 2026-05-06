package com.duoc.deepwallet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.duoc.deepwallet.dto.ValorDolarDto;

@Service
public class DolarService {

    @Autowired
    @Qualifier("fastforexWebClient")
    private WebClient dolarWebClient;
    
    public ValorDolarDto obtenerDolar() {
        return dolarWebClient.get()
                .uri(uriBuilder -> uriBuilder
                        .build())
                .retrieve()
                .bodyToMono(ValorDolarDto.class)
                .block();
    }
}
