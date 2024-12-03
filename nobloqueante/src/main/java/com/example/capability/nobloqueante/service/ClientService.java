package com.example.capability.nobloqueante.service;

import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class ClientService {

    private WebClient webClient;

    @PostConstruct
    private void configureClient(){
        webClient = WebClient.builder().build();
    }

    public <R> Mono<R> getDataFromProducer(String serviceUrl, Class<R> type){
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);
        return webClient.get().uri("http://localhost:8080"+serviceUrl)
                .headers(webClientHeader -> webClientHeader.addAll(requestHeaders))
                .retrieve()
                .bodyToMono(type);
    }
}
