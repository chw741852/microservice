package com.hong.security.repository;

import com.hong.security.domain.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by caihongwei on 16/7/6 下午2:33.
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);

    @Modifying
    @Query("update User u set u.password=?1 where u.username=?2")
    int updatePasswordByUsername(String password, String username);
}
