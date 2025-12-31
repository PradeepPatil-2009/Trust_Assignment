
/*
package com.example.serverapp.controller;

import java.util.concurrent.CompletableFuture;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.serverapp.pojo.TransactionResponse;
import com.example.serverapp.service.TransactionProcessor;
import com.example.serverapp.xml.TransactionXml;

import jakarta.validation.Valid;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping("/server/transaction")
@Tag(
    name = "Transaction Processing API",
    description = "Processes transaction requests from Bank A and Bank B"
)
public class TransactionController {

    private final TransactionProcessor processor;

    public TransactionController(TransactionProcessor processor) {
        this.processor = processor;
    }

    @Operation(
        summary = "Process a transaction",
        description = "Accepts JSON or XML transaction requests and processes them asynchronously",
        responses = {
            @ApiResponse(
                responseCode = "200",
                description = "Transaction processed successfully",
                content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = TransactionResponse.class)
                )
            ),
            @ApiResponse(
                responseCode = "400",
                description = "Invalid request data"
            ),
            @ApiResponse(
                responseCode = "401",
                description = "Unauthorized - invalid client credentials"
            ),
            @ApiResponse(
                responseCode = "500",
                description = "Internal server error"
            )
        }
    )
 /*   @PostMapping(
        value = "/process",
        consumes = {
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE
        },
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    */

/*	@PostMapping(
		    value = "/process",
		    consumes = MediaType.APPLICATION_XML_VALUE,
		    produces = MediaType.APPLICATION_JSON_VALUE
		)


    public CompletableFuture<ResponseEntity<TransactionResponse>> process(
            @Valid @RequestBody TransactionXml request) {

        return processor.process(request)
                .thenApply(ResponseEntity::ok);
    }
}
*/
package com.example.serverapp.controller;

import java.util.concurrent.CompletableFuture;

import jakarta.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.example.serverapp.pojo.TransactionResponse;
import com.example.serverapp.service.TransactionProcessor;
import com.example.serverapp.xml.TransactionXml;

@RestController
@RequestMapping("/server/transaction")
public class TransactionController {

    private final TransactionProcessor processor;

    public TransactionController(TransactionProcessor processor) {
        this.processor = processor;
    }

    @PostMapping(
        value = "/process",
        consumes = {
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE
        },
        produces = {
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE
        }
    )
    public CompletableFuture<TransactionResponse> process(
            @Valid @RequestBody TransactionXml request) {

        
        return processor.processAsync(request);
    }
}
