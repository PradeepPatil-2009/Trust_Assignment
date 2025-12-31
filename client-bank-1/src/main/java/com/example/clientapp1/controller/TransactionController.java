package com.example.clientapp1.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.clientapp1.pojo.TransactionRequest;
import com.example.clientapp1.pojo.TransactionResponse;
import com.example.clientapp1.service.TransactionService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/bank")
public class TransactionController {

    private final TransactionService service;

    public TransactionController(TransactionService service) {
        this.service = service;
    }

    
    @PostMapping(
        value = "/transaction",
        consumes = "application/json",
        produces = "application/json"
    )
    public ResponseEntity<TransactionResponse> process(
            @Valid @RequestBody TransactionRequest request) {

        TransactionResponse response = service.process(request);
        return ResponseEntity.ok(response);
    }
}
