package com.hong.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by caihongwei on 16/6/28 下午2:02.
 */
@Controller
public class SecurityController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(ModelMap modelMap, HttpServletRequest request) {
        modelMap.addAttribute("sessionId", request.getSession().getId());

        return "index";
    }
}
