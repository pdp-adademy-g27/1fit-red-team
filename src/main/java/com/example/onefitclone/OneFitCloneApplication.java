package com.example.onefitclone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
public class OneFitCloneApplication {

    public static void main(String[] args) {
        SpringApplication.run(OneFitCloneApplication.class, args);
    }

}
