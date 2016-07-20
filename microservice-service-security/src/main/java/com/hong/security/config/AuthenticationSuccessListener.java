package com.hong.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;

/**
 * 账号登录失败监听器
 * Created by caihongwei on 16/7/20 下午1:54.
 */
@Component
public class AuthenticationSuccessListener implements ApplicationListener<AuthenticationSuccessEvent> {
    @Autowired
    private LoginAttemptService loginAttemptService;

    @Override
    public void onApplicationEvent(AuthenticationSuccessEvent event) {
        WebAuthenticationDetails auth = (WebAuthenticationDetails) event.getAuthentication().getDetails();

        loginAttemptService.loginSuccessed(auth.getRemoteAddress());
    }
}
