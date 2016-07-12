package com.hong.security.service;

import com.hong.security.domain.Group;
import com.hong.security.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by caihongwei on 16/7/7 下午10:59.
 */
@Service
@Transactional(readOnly = true)
public class GroupService {
    @Autowired
    private GroupRepository repository;

    @Transactional
    public Group save(Group group) {
        return repository.save(group);
    }

    @Transactional
    public void delete(long id) {
        repository.delete(id);
    }

    public Group findById(long id) {
        return repository.findOne(id);
    }
}
