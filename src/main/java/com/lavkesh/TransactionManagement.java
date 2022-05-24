package com.lavkesh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class TransactionManagement {

    public static void main(String[] args) {
        SpringApplication.run(TransactionManagement.class, args);
    }

}
