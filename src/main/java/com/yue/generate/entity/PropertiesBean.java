package com.yue.generate.entity;

/**
 * Created by lms on 16-7-18.
 * 属性bean
 */
public class PropertiesBean {
    private Integer index;
    private String fieldName;
    private String labelName;
    private Integer ifEditField;
    private Integer ifSearchField;
    private String tagType;
    private String  searchMatch;

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getLabelName() {
        return labelName;
    }

    public void setLabelName(String labelName) {
        this.labelName = labelName;
    }

    public Integer getIfEditField() {
        return ifEditField;
    }

    public void setIfEditField(Integer ifEditField) {
        this.ifEditField = ifEditField;
    }

    public Integer getIfSearchField() {
        return ifSearchField;
    }

    public void setIfSearchField(Integer ifSearchField) {
        this.ifSearchField = ifSearchField;
    }

    public String getSearchMatch() {
        return searchMatch;
    }

    public void setSearchMatch(String searchMatch) {
        this.searchMatch = searchMatch;
    }

    public String getTagType() {
        return tagType;
    }

    public void setTagType(String tagType) {
        this.tagType = tagType;
    }
}
