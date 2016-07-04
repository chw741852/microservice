package com.hong.security.domain;

import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import java.util.Date;

/**
 * Created by caihongwei on 16/6/20 下午3:23.
 * 权限
 */
@Entity
public class Authority extends AbstractPersistable<Long> implements GrantedAuthority {
    private String authority;

    @LastModifiedDate
    private Date updatedTime;

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return authority;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }
}
