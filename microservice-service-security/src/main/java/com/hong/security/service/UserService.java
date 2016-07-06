package com.hong.security.service;

import com.hong.security.domain.User;
import com.hong.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
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
    private CrudRepository<User, Long> repository;

    @Transactional
    public long create(User user) {
        if (userRepository.findByUsername(user.getUsername()) != null) {
            return 0;
        }
        user = repository.save(user);

        return user.getId();
    }
}
