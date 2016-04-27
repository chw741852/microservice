package com.hong.server.service;

import com.hong.server.dao.UserDao;
import com.hong.server.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by caihongwei on 16/4/27 下午4:52.
 */
@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public User getUser(int id) {
        return userDao.selectByPrimaryKey(id);
    }
}
