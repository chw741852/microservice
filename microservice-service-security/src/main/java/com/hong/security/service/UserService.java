package com.hong.security.service;

import com.hong.security.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by caihongwei on 16/7/18 下午8:58.
 */
@Service
@Transactional(readOnly = true)
public class UserService {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserMapper userMapper;

    @Transactional
    public boolean changePassword(String username, String oldPassword, String newPassword) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, oldPassword));

        return userMapper.updatePasswordByUsername(username, passwordEncoder.encode(newPassword)) > 0;
    }
}
