package com.yue.auth.bean;

import com.yue.base.entity.IdEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by lms on 16-6-26.
 * 权限列表
 */
@Table
@Entity
public class Permission extends IdEntity{

    /**
     * 权限编号
     */
    @Column(name="permiss_right")
    private String permissRight;

    /**
     * 父权限id
     */
    @Column(name = "p_id")
    private Long pId=0l;

    /**
     * 权限的初始状态，默认为无效
     */
    private Integer state=0;

    public String getPermissRight() {
        return permissRight;
    }

    public void setPermissRight(String permissRight) {
        this.permissRight = permissRight;
    }

    public Long getpId() {
        return pId;
    }

    public void setpId(Long pId) {
        this.pId = pId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
