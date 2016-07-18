package com.yue.generate.service;

import com.yue.demo.service.HtmlService;
import com.yue.generate.entity.GenerateSerachBean;
import com.yue.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.*;

/**
 * Created by lms on 16-7-18.
 */
@Service("generateService")
public class GenerateService {
    @Autowired
    private HtmlService htmlService;
    @Autowired
    private FreemarkerTemplate freemarkerTemplate;

    /**
     * 生成后端代码
     */
    public void generateCode(String pkg, String Bean,String bean) {
        String repositoryFtl = "/Repository.ftl";
        String serviceFtl = "/Service.ftl";
        String actionFtl = "/Action.ftl";



        Map<String, Object> map = new HashMap<String, Object>();
        map.put("pkg", pkg);       //包名
        map.put("Bean", Bean);     //类名
        map.put("bean", bean);     //实体名


        String repositoryContent = freemarkerTemplate.getContent(repositoryFtl, map);
        String serviceContent = freemarkerTemplate.getContent(serviceFtl, map);
        String actionContent = freemarkerTemplate.getContent(actionFtl, map);


        if (!StringUtils.isEmpty(repositoryContent)) {
            try {
                String javaRepositoryPath = new File("").getAbsolutePath() + "/src/main/java/com/yue/" + pkg + "/repository";
                String repositoryFile = Bean + "Repository.java";
                System.out.println("javaPath=" + javaRepositoryPath);
                htmlService.writeResult(javaRepositoryPath, repositoryFile, repositoryContent);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


        if (!StringUtils.isEmpty(serviceContent)) {
            try {
                String javaServicePath = new File("").getAbsolutePath() + "/src/main/java/com/yue/" + pkg + "/service";
                String serviceFile = Bean + "Service.java";
                System.out.println("javaPath=" + javaServicePath);
                htmlService.writeResult(javaServicePath, serviceFile, serviceContent);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


        if (!StringUtils.isEmpty(actionContent)) {
            try {
                String javaControllerPath = new File("").getAbsolutePath() + "/src/main/java/com/yue/" + pkg + "/controller";
                String controllerFile = Bean + "Action.java";
                System.out.println("javaPath=" + javaControllerPath);
                htmlService.writeResult(javaControllerPath, controllerFile, actionContent);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


        System.out.println("生成==========");

    }







    public void generateView(List<GenerateSerachBean> serachBeans ){
        String ftl = "/view/page.ftl";
        try {



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


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
