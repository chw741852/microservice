package com.hong.hystrix;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by caihongwei on 16/3/28 下午3:34.
 */
@SpringBootApplication
@EnableHystrixDashboard
@EnableEurekaClient
@Controller
public class HystrixApplication {
    @RequestMapping("/")
    public String home() {
        return "forward:/hystrix";
    }

    public static void main(String[] args) {
        new SpringApplicationBuilder(HystrixApplication.class).web(true).run(args);
    }
}
