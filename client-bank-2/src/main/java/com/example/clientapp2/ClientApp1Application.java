package com.example.clientapp2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ClientApp1Application {

/*	@Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }*/

	public static void main(String[] args) {
		SpringApplication.run(ClientApp1Application.class, args);
	}

}
