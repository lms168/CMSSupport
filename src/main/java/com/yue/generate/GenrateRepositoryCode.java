package com.yue.generate;

/**
 * Created by lms on 16-7-15.
 */

import com.yue.demo.service.HtmlService;
import com.yue.generate.service.FreemarkerTemplate;
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
        HtmlService htmlService = ctx.getBean("htmlService",HtmlService.class);
        FreemarkerTemplate freemarkerTemplate= ctx.getBean(FreemarkerTemplate.class);

        String repositoryFtl = "/Repository.ftl";
        String serviceFtl = "/Service.ftl";
        String actionFtl = "/Action.ftl";
        String  pkg = "test";
        String Bean="Test";
        String  bean="test";

        try {


            Map<String,Object> map = new HashMap<String, Object>();
            map.put("pkg",pkg);       //包名
            map.put("Bean",Bean);     //类名
            map.put("bean",bean);     //实体名







            String repositoryContent = freemarkerTemplate.getContent(repositoryFtl, map);
            String serviceContent = freemarkerTemplate.getContent(serviceFtl, map);
            String actionContent = freemarkerTemplate.getContent(actionFtl, map);



            if (!StringUtils.isEmpty(repositoryContent)){
                try{
                    String javaRepositoryPath =new File("").getAbsolutePath() + "/src/main/java/com/yue/"+pkg + "/repository";
                    String repositoryFile = Bean+"Repository.java";
                    System.out.println("javaPath="+javaRepositoryPath);
                    htmlService.writeResult(javaRepositoryPath,repositoryFile,repositoryContent);
                }catch (Exception e){
                    e.printStackTrace();
                }


                try {
                    String javaServicePath = new File("").getAbsolutePath() + "/src/main/java/com/yue/" + pkg + "/service";
                    String serviceFile = Bean + "Service.java";
                    System.out.println("javaPath=" + javaServicePath);
                    htmlService.writeResult(javaServicePath, serviceFile, serviceContent);
                }catch (Exception e){
                    e.printStackTrace();
                }

                try {
                    String javaControllerPath = new File("").getAbsolutePath() + "/src/main/java/com/yue/" + pkg + "/controller";
                    String controllerFile = Bean + "Action.java";
                    System.out.println("javaPath=" + javaControllerPath);
                    htmlService.writeResult(javaControllerPath, controllerFile, actionContent);
                }catch (Exception e){
                    e.printStackTrace();
                }


            }










            System.out.println("生成==========");
            System.exit(1);

//            String content = htmlService.all(msg);
//            if (!StringUtils.isEmpty(content)){
//                String javaPath = new File("").getAbsolutePath() + "/src/main/java" + "/com/yue/demo/freeMarkerResult/aaa.html";
//                String jspPath =new File("").getAbsolutePath() + "/src/main/webapp/WEB-INF" + "/views/auth/aaa.html";
//                System.out.println("javaPath="+javaPath);
//                System.out.println("jspPath="+jspPath);
//                htmlService.writeResult(javaPath, content);
//                htmlService.writeResult(jspPath,content);
//
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }







}
