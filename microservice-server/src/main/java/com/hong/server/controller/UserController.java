package com.hong.server.controller;

import com.hong.server.domain.User;
import com.hong.server.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by caihongwei on 16/4/27 下午2:33.
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    private Logger logger = LogManager.getLogger(UserController.class);

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable int id) {
        logger.debug("Get user by id: {}", id);
        return userService.getUser(id);
    }
}
