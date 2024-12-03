package com.example.capability.producer.controller;

import com.example.capability.producer.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class ProduceController {

    @Autowired
    DataService dataService;

    @GetMapping("produce")
    public ResponseEntity<?> getData(){
        return ResponseEntity.ok(dataService.generateData());
    }
}
