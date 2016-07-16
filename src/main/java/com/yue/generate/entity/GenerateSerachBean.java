package com.yue.generate.entity;

import java.util.List;
import java.util.Map;

/**
 * Created by lms on 16-7-15.
 * 查询标签
 */
public class GenerateSerachBean {
    /**
     * labelName
     */
    private String labelName;
    /**
     * 标签类型：text,select......
     */
    private String tagType;

    /**
     * 标签名称
     */
    private String name;
    /**
     * 标签值
     */
    private String value;

    /**
     * select标签的option值
     */
    private Map<String,Object> selectOptions;

    public String getLabelName() {
        return labelName;
    }

    public void setLabelName(String labelName) {
        this.labelName = labelName;
    }

    public String getTagType() {
        return tagType;
    }

    public void setTagType(String tagType) {
        this.tagType = tagType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Map<String, Object> getSelectOptions() {
        return selectOptions;
    }

    public void setSelectOptions(Map<String, Object> selectOptions) {
        this.selectOptions = selectOptions;
    }

}
