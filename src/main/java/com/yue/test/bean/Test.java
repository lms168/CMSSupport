package com.yue.test.bean;

import com.yue.common.IdEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by lms on 16-7-18.
 */
@Table(name="Test")
@Entity
public class Test extends IdEntity{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



}
