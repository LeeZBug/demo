package com.lizhejie.demo;

import cn.dev33.satoken.SaManager;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lizhejie.demo.model.dao")
public class DemoApplication {
    public static void main(String[] args) throws JsonProcessingException {
        SpringApplication.run(DemoApplication.class, args);
//        System.out.println("启动成功，Sa-Token 配置如下：" + SaManager.getConfig());
    }
}

