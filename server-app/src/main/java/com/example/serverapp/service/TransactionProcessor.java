package com.example.serverapp.service;

import java.time.OffsetDateTime;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.example.serverapp.entity.TransactionLog;
import com.example.serverapp.pojo.TransactionResponse;
import com.example.serverapp.repo.TransactionLogRepository;
import com.example.serverapp.xml.TransactionXml;

@Service
public class TransactionProcessor {

    private final TransactionLogRepository repository;

    private final Set<String> trxCache = ConcurrentHashMap.newKeySet();

    public TransactionProcessor(TransactionLogRepository repository) {
        this.repository = repository;
    }

    @Async("transactionExecutor")
    public CompletableFuture<TransactionResponse> processAsync(TransactionXml request) {

        long startTime = System.currentTimeMillis();

        if (!trxCache.add(request.getTrxId())) {
            return CompletableFuture.completedFuture(
                    buildResponse(request, "FAILED", "Duplicate Transaction", 0)
            );
        }

        try {
            validate(request);
            simulateProcessing();

            long processingTime = System.currentTimeMillis() - startTime;

            // DB logging intentionally skipped during high-load execution

            return CompletableFuture.completedFuture(
                    buildResponse(request, "SUCCESS", "Completed", processingTime)
            );

        } catch (Exception ex) {
            return CompletableFuture.completedFuture(
                    buildResponse(request, "FAILED", "Processing Error", 0)
            );
        }
    }

    private void validate(TransactionXml request) {
        if (request.getAmount() == null || request.getAmount() <= 0) {
            throw new IllegalArgumentException("Invalid amount");
        }
    }

    private void simulateProcessing() throws InterruptedException {
        Thread.sleep(10);
    }
    /*
    private void simulateProcessing()  {
       
    }*/

    @SuppressWarnings("unused")
    private void save(TransactionXml req, String status, String reason) {
        TransactionLog log = new TransactionLog();
        log.setTrxId(req.getTrxId());
        log.setBankId(req.getBankId());
        log.setStatus(status);
        log.setReason(reason);
        log.setCreatedAt(OffsetDateTime.now());
        repository.save(log);
    }

    private TransactionResponse buildResponse(
            TransactionXml req,
            String status,
            String message,
            long timeTaken) {

        return new TransactionResponse(
                req.getTrxId(),
            //    req.getStan(),
                status,
                message,
                timeTaken,
                req.getBankId()
        );
    }
}
