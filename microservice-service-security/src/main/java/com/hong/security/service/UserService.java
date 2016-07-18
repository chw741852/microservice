package com.hong.security.service;

import com.hong.security.domain.User;
import com.hong.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by caihongwei on 16/7/6 上午10:49.
 */
@Service
@Transactional(readOnly = true)
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    public User save(User user) {
        if (user.isNew() && userRepository.findByUsername(user.getUsername()) != null)
            return null;

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public User findById(long id) {
        return userRepository.findOne(id);
    }

    @Transactional
    public boolean changePassword(String username, String oldPassword, String newPassword) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, oldPassword));

        newPassword = passwordEncoder.encode(newPassword);
        int r = userRepository.updatePasswordByUsername(username, newPassword);
        return r > 0;
    }
}
