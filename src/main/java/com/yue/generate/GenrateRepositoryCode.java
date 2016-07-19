package com.yue.generate;

/**
 * Created by lms on 16-7-15.
 */

import com.yue.demo.service.HtmlService;
import com.yue.generate.service.FreemarkerTemplate;
import com.yue.generate.service.GenerateService;
import com.yue.utils.FileUtils;
import com.yue.utils.StringUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;
import java.util.*;

/**
 * dao层代码生成
 */
public class GenrateRepositoryCode {
    public static void main(String[] args){
        String paths[] = {"classpath:applicationContext.xml"};
        //这个xml文件是Spring配置beans的文件，顺带一提，路径 在整个应用的根目录
        ApplicationContext ctx = new ClassPathXmlApplicationContext(paths);
        GenerateService generateService = ctx.getBean("generateService",GenerateService.class);
        String  pkg = "test";
        String Bean="Test";
        String  bean="test";
        try {
            List<String> opTypes = new ArrayList<String>();
            opTypes.add("query");
            generateService.generateCode(pkg,Bean,bean,opTypes);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }







}
