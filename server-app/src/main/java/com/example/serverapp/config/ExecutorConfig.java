package com.example.serverapp.config;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.LinkedBlockingQueue;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExecutorConfig {

    @Bean
    public ExecutorService executorService() {
        return new ThreadPoolExecutor(
            100,                     // core threads
            500,                     // maximum threads
            60L,                     // keep-alive time
            TimeUnit.SECONDS,         // time unit for keep-alive
            new LinkedBlockingQueue<>(10000)  // work queue
        );
    }
}
