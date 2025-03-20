package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class JavaSpringPracticeApplication {
    public static void main(String[] args) {
        SpringApplication.run(JavaSpringPracticeApplication.class, args);
    }
}