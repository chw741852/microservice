package com.hong.security.service;

import com.hong.security.domain.Authority;
import com.hong.security.repository.AuthorityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by caihongwei on 16/7/8 上午10:11.
 */
@Service
@Transactional(readOnly = true)
public class AuthorityService {
    @Autowired
    private AuthorityRepository repository;

    @Transactional
    public Authority save(Authority authority) {
        return repository.save(authority);
    }
}
