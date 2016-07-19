package com.yue.demo.service;

import com.yue.generate.service.FreemarkerTemplate;
import com.yue.demo.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lms on 16-7-15.
 */
@Service("htmlService")
public class HtmlService {

    @Autowired
    private FreemarkerTemplate freemarkerTemplate;


    public String all(String ftlName) throws Exception {
        Map<String,Object> rootMap = new HashMap<String,Object>();

        Article article = new Article();
        article.setTitle("关于小网客");
        article.setContent("解决方案咨询<br>大数据处理<br>系统架构<br>企业信息化咨询<br>Email:smallnetvisitor@qq.com<br>来自北京");
        rootMap.put("article", article);
        String result = freemarkerTemplate.getContent(ftlName,rootMap);

        System.out.println("result============"+result);

        return result;


    }






}
