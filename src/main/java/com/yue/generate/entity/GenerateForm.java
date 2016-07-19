package com.yue.generate.entity;

import java.util.List;

/**
 * Created by lms on 16-7-18.
 * 代码生成页面包装类
 */
public class GenerateForm {

    private String entityName;
    private List<String> opType;
    private List<PropertiesBean> propertiesBeans;


    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }


    public List<PropertiesBean> getPropertiesBeans() {
        return propertiesBeans;
    }

    public void setPropertiesBeans(List<PropertiesBean> propertiesBeans) {
        this.propertiesBeans = propertiesBeans;
    }

    public List<String> getOpType() {
        return opType;
    }

    public void setOpType(List<String> opType) {
        this.opType = opType;
    }

}
