package com.api;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;

//过滤器去掉@Component，在程序启动类加上@ServletComponentScan，过滤器和urlPatterns属性均生效。
@ServletComponentScan
@SpringBootApplication
@MapperScan({"com.api.manage.dao","com.api.app.dao","com.api.butlerApp.dao","com.api.alipay.dao","com.api.systemDataBigScreen.dao","com.api.common.dao","com.api.mapper","com.api.wx.mapper"})
@EnableCaching//开启缓存
public class IntelligentCommunityApp {
    public static void main(String[] args) {
        SpringApplication.run(IntelligentCommunityApp.class,args);
    }
}
