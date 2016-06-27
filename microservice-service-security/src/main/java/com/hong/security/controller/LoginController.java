package com.hong.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by caihongwei on 16/6/23 下午3:15.
 */
@Controller
public class LoginController {
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {

        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(String username, String password, HttpServletRequest request) {
        try {
            request.login(username, password);
        } catch (ServletException e) {
            e.printStackTrace();
        }
        System.out.println(username);
        System.out.println(password);

        return "";
    }

    @RequestMapping(value = "logout", method = RequestMethod.POST)
    public String logout() {

        return "";
    }
}
