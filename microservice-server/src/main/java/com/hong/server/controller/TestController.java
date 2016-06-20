package com.hong.server.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by caihongwei on 16/3/28 上午10:56.
 */
@RestController
public class TestController {
    @Value("${info.description:local info}")
    private String info;

    @RequestMapping("/")
    public String home() {
        return info;
    }
}
