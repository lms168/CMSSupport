package com.yue.auth.bean;

import com.yue.common.IdEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by lms on 16-6-26.
 * 角色表
 */
@Table
@Entity
public class Role extends IdEntity{
    /**
     * 角色名称
     */
    private String roleName;
    /**
     * 角色状态
     */
    private int state=0;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }




}
