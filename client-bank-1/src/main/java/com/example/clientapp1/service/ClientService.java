package com.example.clientapp1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ClientService {

    private final RestTemplate restTemplate;
    private final String applicationName;
    private final String password;

   
    public ClientService(
            RestTemplate restTemplate,
            @Value("${spring.application.name}") String applicationName,
            @Value("${client.password}") String password) {

        this.restTemplate = restTemplate;
        this.applicationName = applicationName;
        this.password = password;
    }

    public void sendToServer(String xml) {

        String authValue = applicationName + ":" + password;
        System.out.println("authValue :: " + authValue);

        HttpHeaders headers = new HttpHeaders();
       
        headers.setContentType(MediaType.APPLICATION_XML);
       headers.setAccept(List.of(MediaType.APPLICATION_XML));
        
        headers.set(HttpHeaders.AUTHORIZATION, "Bearer " + authValue);

        HttpEntity<String> entity = new HttpEntity<>(xml, headers);

        restTemplate.postForEntity(
                "http://localhost:8080/server/transaction/process",
                entity,
                String.class
        );
    }
}
