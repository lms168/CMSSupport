package com.yue.demo.entity;

import java.io.Serializable;

/**
 * Created by lms on 16-7-15.
 */
public class Article  implements Serializable {
    private static final long serialVersionUID = 554206256994693476L;
    private String title;
    private String content;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
