package com.example.capability.nobloqueante.controller;

import com.example.capability.nobloqueante.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@RestController
@RequestMapping("/api/v1")
public class NobloqueanteController {

    @Autowired
    ClientService clientService;

    @GetMapping("/consumer")
    public Mono<ResponseEntity<String>>  getMapping(){
        System.out.println("No bloqueante consumer");
        return clientService.getDataFromProducer("/api/v1/produce",String.class)
                .map(body -> new ResponseEntity<String>("NB:"+body, HttpStatus.OK));
    }

    @GetMapping(value = "/producer", produces = {MediaType.TEXT_EVENT_STREAM_VALUE})
    public Flux<Integer> getProducer(){
        System.out.println("No bloqueante producer");
        return Flux.range(1,50).delayElements(Duration.ofSeconds(1));
    }
}
