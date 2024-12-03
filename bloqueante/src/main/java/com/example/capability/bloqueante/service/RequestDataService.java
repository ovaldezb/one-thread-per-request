package com.example.capability.bloqueante.service;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;


@Service
public class RequestDataService {

    RestTemplate restTemplate;

    @PostConstruct
    public void getRestTemplate(){
        restTemplate = new RestTemplate();
    }

    public <R> ResponseEntity<R> getDataFromProducer(String serviceUrl, Class<R> type){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        return restTemplate.exchange("http://localhost:8080"+serviceUrl, HttpMethod.GET, entity, type);
    }
}
