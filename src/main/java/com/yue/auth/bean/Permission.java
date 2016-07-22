package com.yue.auth.bean;

import com.sun.org.apache.xpath.internal.operations.Bool;
import com.yue.common.IdEntity;
import jdk.nashorn.internal.ir.annotations.Ignore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

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
     * 权限名称
     */
    @Column(name = "name")
    private String  name;
    /**
     * 父权限id
     */
    @Column(name = "p_id")
    private Long pId=0l;

    /**
     * 权限的初始状态，默认为无效
     */
    private Integer state=0;


    /**
     *菜单序号
     */
    private Integer indexNum;

    /**
     * 是否处于打开状态
     */
    @Transient
    private Boolean open = true;

    /**
     * 是否选中
     */
    @Transient
    private Boolean checked = false;


    public Boolean getOpen() {
        return open;
    }

    public void setOpen(Boolean open) {
        this.open = open;
    }

    public Boolean getChecked() {
        return checked;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }






    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getIndexNum() {
        return indexNum;
    }

    public void setIndexNum(Integer indexNum) {
        this.indexNum = indexNum;
    }





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
