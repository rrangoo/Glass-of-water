package com.glassofwater.gow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class GowApplication {

    public static void main(String[] args) {
        SpringApplication.run(GowApplication.class, args);
    }

}
