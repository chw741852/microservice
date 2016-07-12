package com.hong.security.repository;

import com.hong.security.domain.Authority;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by caihongwei on 16/7/8 上午10:10.
 */
@Repository
public interface AuthorityRepository extends CrudRepository<Authority, Long> {
}
