package com.example.onefitclone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class OneFitCloneApplication {

    public static void main(String[] args) {
        SpringApplication.run(OneFitCloneApplication.class, args);
    }

}
