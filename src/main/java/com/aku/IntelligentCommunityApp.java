package com.aku;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.aku.dao")
public class IntelligentCommunityApp {
    public static void main(String[] args) {
        SpringApplication.run(IntelligentCommunityApp.class,args);
    }
}
