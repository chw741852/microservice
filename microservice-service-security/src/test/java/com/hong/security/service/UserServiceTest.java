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
        user.setUsername("cai2");
        user.setPassword("123456");

        user = userService.save(user);
        assertEquals(user.getId(), Long.valueOf(3));
    }

    @Test
    public void testUpdate() {
        User user = userService.findById(1);
        assertEquals(user.getPassword(), "123456");

        user.setPassword("123123");
        userService.save(user);

        User newUser = userService.findById(1);
        assertEquals(newUser.getPassword(), "123123");
    }

    @Test
    public void testChangePassword() {
        String username = "cai2";
        String oldPassword = "1234567";
        String newPassword = "123123";

        boolean b = userService.changePassword(username, oldPassword, newPassword);
        assertFalse(b);
    }
}