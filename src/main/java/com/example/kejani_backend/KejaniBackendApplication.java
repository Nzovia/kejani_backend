package com.example.kejani_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan({"com.example.kejani_backend.scheduler"})
//@EntityScan("com.delivery.domain")
public class KejaniBackendApplication {
    public static void main(String[] args) {
        SpringApplication.run(KejaniBackendApplication.class, args);
    }

}
