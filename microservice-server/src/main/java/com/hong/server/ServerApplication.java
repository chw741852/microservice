package com.hong.server;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * Created by caihongwei on 16/3/28 上午10:46.
 */
@SpringBootApplication(scanBasePackages = "com.hong.server")
@EnableEurekaClient
@EnableZuulProxy
@EnableHystrix
public class ServerApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(ServerApplication.class).web(true).run(args);
    }
}
