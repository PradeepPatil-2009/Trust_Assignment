package com.example.clientapp1.utility;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TxnIdGenerator {

    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyyMMdd");

    private final AtomicLong sequence = new AtomicLong(0);
    private final GenerateRandomNumber generateRandomNumber = new GenerateRandomNumber();
    


    @Value("${client.id}")
    private int clientId;

    public synchronized String generateTxnId() {

        if (clientId < 0 || clientId > 99) {
        	throw new IllegalArgumentException("client.id must be a two-digit value between 00 and 99");

        }

        String date = LocalDate.now().format(DATE_FORMAT);
        String client = String.format("%02d", clientId);

        long uniqueSeed = sequence.incrementAndGet();
        String random = String.format(
                "%04d",
                (Integer.parseInt(generateRandomNumber.generate(4)) + uniqueSeed) % 10000
        );

        return "TRX-" + date + "-" + client + random;
    }
}
