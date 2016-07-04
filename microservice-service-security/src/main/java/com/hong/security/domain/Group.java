package com.hong.security.domain;

import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;

/**
 * Created by caihongwei on 16/7/4 下午9:10.
 * 权限组
 */
@Entity
public class Group extends AbstractPersistable<Long> {
    @Column(length = 50)
    private String groupName;

    @OneToMany
    private List<User> users;

    @ManyToMany
    private List<Authority> authorities;

    @LastModifiedDate
    private Date updatedDate;

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<Authority> authorities) {
        this.authorities = authorities;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }
}
