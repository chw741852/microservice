package com.hong.security;

import com.hong.security.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by caihongwei on 16/7/6 上午10:44.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SecurityApplication.class)
@WebIntegrationTest({"server.port:0", "management.port:0"})
public class DataTest {
    @Autowired
    private UserDetailsService userDetailsService;

    @Test
    public void testCreateUser() {
        User user = (User) userDetailsService.loadUserByUsername("");
    }
}
