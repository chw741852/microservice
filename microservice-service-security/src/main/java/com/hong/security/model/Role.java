package com.hong.security.model;

import org.springframework.data.annotation.Id;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

/**
 * Created by caihongwei on 16/6/20 下午3:23.
 */
@Entity
public class Role implements GrantedAuthority {
    @Id @GeneratedValue
    private Long id;
    private String authority;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return authority;
    }
}
