package com.ksk.nosql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class NoSqlApplication {
    public static void main(String[] args) {
        SpringApplication.run(NoSqlApplication.class,args);
    }
}