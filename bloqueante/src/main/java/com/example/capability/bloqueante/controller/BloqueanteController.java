package com.example.capability.bloqueante.controller;

import com.example.capability.bloqueante.service.RequestDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class BloqueanteController {

    @Autowired
    RequestDataService dataService;

    @GetMapping("/consumer")
    public ResponseEntity<String> getConsumer(){
        System.out.println("En consumer");
        return ResponseEntity.ok(dataService.getDataFromProducer("/api/v1/produce", String.class).getBody());
    }

    @GetMapping("/producer")
    public ResponseEntity<String> getProducer(){
        System.out.println("En producer");
        return ResponseEntity.ok("soy un producer");
    }

}
