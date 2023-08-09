package com.ksk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

@EnableCaching
@SpringBootApplication
@ComponentScan("com.ksk")
public class UsersApplication {
    public static void main(String[] args) {
        SpringApplication.run(UsersApplication.class);
    }
}