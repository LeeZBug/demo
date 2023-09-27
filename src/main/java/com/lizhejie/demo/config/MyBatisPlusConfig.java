package com.lizhejie.demo.config;

import com.lizhejie.demo.interceptor.AuditInterceptor;
import org.apache.ibatis.plugin.Interceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyBatisPlusConfig {

    @Bean
    public Interceptor auditInterceptor() {
        return new AuditInterceptor();
    }
}