package com.yue.auth.bean;

import com.yue.base.entity.IdEntity;

import javax.persistence.*;

/**
 * Created by lms on 16-6-26.
 */
@Table
@Entity
public class UserRole extends IdEntity{
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @JoinColumn(name = "user_id")
    @ManyToOne
    private User user= new User();

    @ManyToOne
    @JoinColumn(name="role_id")
    private Role role = new Role();
}
