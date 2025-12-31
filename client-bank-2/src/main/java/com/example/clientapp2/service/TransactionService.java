package com.example.clientapp2.service;

import java.time.OffsetDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.clientapp2.pojo.TransactionRequest;
import com.example.clientapp2.pojo.TransactionResponse;
import com.example.clientapp2.utility.GenerateRandomNumber;
import com.example.clientapp2.utility.TxnIdGenerator;
import com.example.clientapp2.xmlRequest.TxnRequestXml;

@Service
public class TransactionService {

    private final TxnIdGenerator txnIdGenerator;
    private final JsonToXmlConverter xmlConverter;
    private final ClientService serverClient;
    private final GenerateRandomNumber generateRandomNumber;
    
    @Value("${spring.application.name}")
    private String applicationName;
   
    public TransactionService(
            TxnIdGenerator txnIdGenerator,
            JsonToXmlConverter xmlConverter,
            ClientService serverClient,
            GenerateRandomNumber generateRandomNumber) {

        this.txnIdGenerator = txnIdGenerator;
        this.xmlConverter = xmlConverter;
        this.serverClient = serverClient;
        this.generateRandomNumber = generateRandomNumber;
    }

    public TransactionResponse process(TransactionRequest req) {

        
        String txnId = txnIdGenerator.generateTxnId();
        System.out.println("Txn ID :: " +txnId);
       
        String stanStr = generateRandomNumber.generate(6);
        int stan = Integer.parseInt(stanStr);

     
        TxnRequestXml xml = new TxnRequestXml();
        xml.setTrxId(txnId);
        xml.setStan(stan);
        xml.setBankId(applicationName);
        xml.setCustomerId(req.getCustomerId());
        xml.setFromAccount(req.getFromAccount());
        xml.setToAccount(req.getToAccount());
        xml.setAmount(req.getAmount());
        xml.setCurrency(req.getCurrency());
        xml.setTimestamp(OffsetDateTime.now());

       
        String xmlPayload = xmlConverter.convertToXml(xml);
        
        System.out.println("Request Payload : "+xmlPayload );
        serverClient.sendToServer(xmlPayload);

      
        return new TransactionResponse(
                txnId,
                stan,
                "FORWARDED",
                "Transaction forwarded to server"
        );
    }
}
