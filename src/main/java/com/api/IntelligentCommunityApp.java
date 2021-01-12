package com.api;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
//过滤器去掉@Component，在程序启动类加上@ServletComponentScan，过滤器和urlPatterns属性均生效。
@ServletComponentScan
@MapperScan({"com.api.manage.dao","com.api.app.dao"})
public class IntelligentCommunityApp {
    public static void main(String[] args) {
        SpringApplication.run(IntelligentCommunityApp.class,args);
    }
}
