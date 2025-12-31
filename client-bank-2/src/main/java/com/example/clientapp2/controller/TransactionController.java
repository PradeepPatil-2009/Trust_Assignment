package com.example.clientapp2.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.clientapp2.pojo.TransactionRequest;
import com.example.clientapp2.pojo.TransactionResponse;
import com.example.clientapp2.service.TransactionService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/bank")
public class TransactionController {

    private final TransactionService service;

  
    public TransactionController(TransactionService service) {
        this.service = service;
    }

    @PostMapping("/transaction")
    public ResponseEntity<TransactionResponse> process(
           @Valid @RequestBody TransactionRequest request) {

        return ResponseEntity.ok(service.process(request));
    }
}
