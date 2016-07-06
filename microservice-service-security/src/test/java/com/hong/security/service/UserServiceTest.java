package com.hong.security.service;

import com.hong.security.SecurityApplication;
import com.hong.security.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by caihongwei on 16/7/6 下午2:27.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SecurityApplication.class)
@WebIntegrationTest({"server.port:0", "management.port:0"})
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    public void testCreate() throws Exception {
        User user = new User();
        user.setAccountNonExpired(true);
        user.setAccountNonLocked(true);
        user.setCredentialsNonExpired(true);
        user.setEnabled(true);
        user.setUsername("caihongwei1");
        user.setPassword("123456");

        long id = userService.create(user);
        assertEquals(id, 5);
    }
}