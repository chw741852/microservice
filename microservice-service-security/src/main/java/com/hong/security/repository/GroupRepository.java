package com.hong.security.repository;

import com.hong.security.domain.Group;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by caihongwei on 16/7/8 上午10:09.
 */
@Repository
public interface GroupRepository extends CrudRepository<Group, Long> {
}
