package com.yue.auth.bean;

import com.yue.common.IdEntity;

import javax.persistence.*;

/**
 * Created by lms on 16-6-26.
 * 权限角色关联表
 */
@Entity
@Table
public class PermissionRole extends IdEntity{
    /**
     * 权限id
     */
    @ManyToOne
    @JoinColumn(name="permission_id")
    private Permission permission = new Permission();

    /**
     * 角色id
     */
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role = new Role();

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Permission getPermission() {
        return permission;
    }

    public void setPermission(Permission permission) {
        this.permission = permission;
    }


}
