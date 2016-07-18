package com.yue.generate;

/**
 * Created by lms on 16-7-15.
 */

import com.yue.demo.service.HtmlService;
import com.yue.generate.entity.GenerateSerachBean;
import com.yue.generate.service.FreemarkerTemplate;
import com.yue.utils.StringUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;
import java.util.*;

/**
 * 页面代码生成
 */
public class GenrateViewCode {
    public static void main(String[] args){
        String paths[] = {"classpath:applicationContext.xml"};
        //这个xml文件是Spring配置beans的文件，顺带一提，路径 在整个应用的根目录
        ApplicationContext ctx = new ClassPathXmlApplicationContext(paths);
        HtmlService htmlService = ctx.getBean("htmlService",HtmlService.class);
        FreemarkerTemplate freemarkerTemplate= ctx.getBean(FreemarkerTemplate.class);

        String ftl = "/view/page.ftl";
        try {
            List<GenerateSerachBean> serachBeans = new ArrayList<GenerateSerachBean>();


            GenerateSerachBean generateSerachBean1 = new GenerateSerachBean();
            generateSerachBean1.setTagType("text");
            generateSerachBean1.setLabelName("客户名");
            generateSerachBean1.setName("username");
            generateSerachBean1.setValue("${user.username}");


            GenerateSerachBean generateSerachBean2 = new GenerateSerachBean();
            generateSerachBean2.setTagType("select");
            generateSerachBean2.setLabelName("是否锁定");
            generateSerachBean2.setName("locked");
            generateSerachBean2.setValue("${user.locked}");


            Map<String,Object> objectMap = new HashMap<String, Object>();
            objectMap.put("true", "是");
            objectMap.put("false", "否");


            generateSerachBean2.setSelectOptions(objectMap);

            serachBeans.add(generateSerachBean1);
            serachBeans.add(generateSerachBean2);









            /////////////编辑菜单
            List<Map<String,String>> listBtn = new ArrayList<Map<String,String>>();
            Map<String,String> addBtn = new HashMap<String, String>();
            addBtn.put("class","add");
            addBtn.put("href","/user/find");
            addBtn.put("rel","addOrEdit");
            addBtn.put("target","dialog");
            addBtn.put("title", "添加");


            Map<String,String> editBtn = new HashMap<String, String>();
            editBtn.put("class","edit");
            editBtn.put("href","/user/find?id={id}");
            editBtn.put("rel","addOrEdit");
            editBtn.put("target","dialog");
            editBtn.put("title", "修改");

            listBtn.add(addBtn);
            listBtn.add(editBtn);



            List<Map<String,String>> tableColNames = new ArrayList<Map<String,String>>();//表头信息
            Map<String,String> th_xh = new HashMap<String, String>();
            th_xh.put("width", "80");
            th_xh.put("name", "序号");

            Map<String,String> th_yhm = new HashMap<String, String>();
            th_yhm.put("width", "120");
            th_yhm.put("name", "用户号");


            Map<String,String> th_dlm = new HashMap<String, String>();
            th_dlm.put("width", "100");
            th_dlm.put("name", "登录名");


            Map<String,String> th_zt = new HashMap<String, String>();
            th_zt.put("width", "150");
            th_zt.put("name", "状态");

            tableColNames.add(th_xh);
            tableColNames.add(th_yhm);
            tableColNames.add(th_dlm);
            tableColNames.add(th_zt);


            List<String> tableColValues = new ArrayList<String>();//表头信息
            tableColValues.add("${stauts.index+1}");
            tableColValues.add("${item.username}");
            tableColValues.add("${item.loginName}");
            tableColValues.add("${item.locked}");






            Map<String,Object> map = new HashMap<String, Object>();
            map.put("actionUrl","/user/page");
            map.put("searchList",serachBeans);   //添加查询列表
            map.put("opBtnList",listBtn); //操作按钮
            map.put("tableColNames",tableColNames);//表头信息
            map.put("tableColValues",tableColValues);//表中的内容


            //控制表格行是否显示id
            Set<String> classValues = new HashSet<String>();
            for(Map<String,String> btn:listBtn){
                classValues.add(btn.get("class"));
            }
            if (classValues.contains("delete")||classValues.contains("edit")){
                map.put("showId", true);
            }



            String content = freemarkerTemplate.getContent(ftl, map);

            if (!StringUtils.isEmpty(content)){
                String jspPath =new File("").getAbsolutePath() + "/src/main/webapp/WEB-INF" + "/views/auth";
                String jspFileName = "newPage.jsp";
                htmlService.writeResult(jspPath,jspFileName,content);
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
