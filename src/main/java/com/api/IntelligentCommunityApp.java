package com.api;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.api.dao")
public class IntelligentCommunityApp {
    public static void main(String[] args) {
        SpringApplication.run(IntelligentCommunityApp.class,args);
    }
}
