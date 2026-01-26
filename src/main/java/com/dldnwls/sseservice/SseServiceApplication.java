package com.dldnwls.sseservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class SseServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SseServiceApplication.class, args);
    }

}
