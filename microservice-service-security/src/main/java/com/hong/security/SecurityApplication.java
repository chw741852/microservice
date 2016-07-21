package com.hong.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * Created by caihongwei on 16/6/20 下午5:05.
 */
@SpringBootApplication(scanBasePackages = "com.hong.security")
//@EnableEurekaClient
//@EnableRedisHttpSession
public class SecurityApplication {
    public static void main(String[] args) {
        SpringApplication.run(SecurityApplication.class, args);
    }
}
