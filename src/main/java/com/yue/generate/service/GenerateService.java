package com.yue.generate.service;

import com.yue.generate.entity.GenerateForm;
import com.yue.generate.entity.GenerateOpBean;
import com.yue.generate.entity.PropertiesBean;
import com.yue.utils.FileUtils;
import com.yue.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by lms on 16-7-18.
 */
@Service("generateService")
public class GenerateService {
    @Autowired
    private FreemarkerTemplate freemarkerTemplate;
    private String projectPath = "/home/lms/CmsSupport/";

    /**
     * 查询页面
     * @param generateForm
     * @param bean
     * @param Bean
     * @param pkg
     */
    public void generatePageView(GenerateForm generateForm, String bean, String Bean, String pkg){
        try {
            String pageViewFtl = "/view/page.ftl";

            List<PropertiesBean> propertiesBeanList = generateForm.getPropertiesBeans();

            /////////////////////////搜索条件集合
            List<GenerateOpBean> serachBeans = new ArrayList<GenerateOpBean>();
            GenerateOpBean generateOpBean = null;
            for (PropertiesBean propertiesBean:propertiesBeanList){
                if (propertiesBean.getIfSearchField()==1){
                    generateOpBean = new GenerateOpBean();
                    generateOpBean.setTagType(propertiesBean.getTagType());
                    generateOpBean.setLabelName(propertiesBean.getLabelName());
                    generateOpBean.setName(propertiesBean.getFieldName());
                    generateOpBean.setValue("${"+bean+"."+propertiesBean.getFieldName()+"}");
                    serachBeans.add(generateOpBean);
                }
            }





        //// ////////////////////编辑菜单集合
        List<Map<String,String>> listBtn = new ArrayList<Map<String,String>>();
                if (generateForm.getOpType().contains("add")){
                    Map<String,String> addBtn = new HashMap<String, String>();
                    addBtn.put("class","add");
                    addBtn.put("href","/"+bean+"/find");
                    addBtn.put("rel","addOrEdit"+Bean);
                    addBtn.put("target","dialog");
                    addBtn.put("title", "添加");
                    listBtn.add(addBtn);
                }else if (generateForm.getOpType().contains("edit")){
                    Map<String,String> editBtn = new HashMap<String, String>();
                    editBtn.put("class","edit");
                    editBtn.put("href","/"+bean+"/find?id={id}");
                    editBtn.put("rel","addOrEdit"+Bean);
                    editBtn.put("target","dialog");
                    editBtn.put("title", "修改");
                    listBtn.add(editBtn);
                }else if (generateForm.getOpType().contains("delete")){
                    Map<String,String> deleteBtn = new HashMap<String, String>();
                    deleteBtn.put("class","delete");
                    deleteBtn.put("href","/"+bean+"/delete?id={id}");
                    deleteBtn.put("rel","delete"+Bean);
                    deleteBtn.put("target","ajaxTodo");
                    deleteBtn.put("title", "确定要删除吗?");
                    listBtn.add(deleteBtn);
                }







        ////////////////////////////////////表头信息集合
        List<Map<String,String>> tableColNames = new ArrayList<Map<String,String>>();
        Map<String,String> th = null;
        for(PropertiesBean propertiesBean:propertiesBeanList){
            th = new HashMap<String, String>();
            //th.put("with","80");
            th.put("name", propertiesBean.getLabelName());
            tableColNames.add(th);
        }


        ///////////////////////////////////////////////////////表格内容集合
        List<String> tableColValues = new ArrayList<String>();
        tableColValues.add("${stauts.index+1}");
        for (PropertiesBean propertiesBean:propertiesBeanList){
            tableColValues.add("${item."+propertiesBean.getFieldName()+"}");
        }


        Map<String,Object> map = new HashMap<String, Object>();
        map.put("actionUrl","/"+bean+"/page");
        map.put("searchList",serachBeans);   //添加查询列表
        map.put("opBtnList",listBtn); //操作按钮
        map.put("tableColNames",tableColNames);//表头信息
        map.put("tableColValues",tableColValues);//表中的内容



        //////////////////////////////////////////////////////控制表格行是否显示id
        if (generateForm.getOpType().contains("delete")||generateForm.getOpType().contains("edit")){
            map.put("showId", true);
        }



        //开始执行生成逻辑
        String content = freemarkerTemplate.getContent(pageViewFtl, map);
        if (!StringUtils.isEmpty(content)){
            String jspPath =projectPath + "/src/main/webapp/WEB-INF" + "/views/"+pkg;
            String jspFileName = "page"+Bean+".jsp";
            System.out.println("jspPath="+jspPath);
            FileUtils.writeResult(jspPath, jspFileName, content);

        }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("生成==========");
    }


    /**
     * 添加修改页面
     * @param generateForm
     * @param bean
     * @param Bean
     * @param pkg
     */
    public void generateAddOrEditView(GenerateForm generateForm, String bean, String Bean, String pkg){
        try {
            String pageViewFtl = "/view/addOrEdit.ftl";
            List<PropertiesBean> propertiesBeanList = generateForm.getPropertiesBeans();

            /////////////////////////编辑条件集合
            List<GenerateOpBean> serachBeans = new ArrayList<GenerateOpBean>();
            GenerateOpBean generateOpBean = null;
            for (PropertiesBean propertiesBean:propertiesBeanList){
                if (propertiesBean.getIfEditField()==1){
                    generateOpBean = new GenerateOpBean();
                    generateOpBean.setTagType(propertiesBean.getTagType());
                    generateOpBean.setLabelName(propertiesBean.getLabelName());
                    generateOpBean.setName(propertiesBean.getFieldName());
                    generateOpBean.setValue("${"+bean+"."+propertiesBean.getFieldName()+"}");
                    serachBeans.add(generateOpBean);
                }
            }



            Map<String,Object> map = new HashMap<String, Object>();
            map.put("actionUrl","/"+bean+"/save");
            map.put("id",bean+".id");
            map.put("searchList",serachBeans);   //添加查询列表



            //开始执行生成逻辑
            String content = freemarkerTemplate.getContent(pageViewFtl, map);
            if (!StringUtils.isEmpty(content)){
                String jspPath =projectPath + "/src/main/webapp/WEB-INF" + "/views/"+pkg;
                String jspFileName = "addOrEdit"+Bean+".jsp";
                System.out.println("jspPath="+jspPath);
                FileUtils.writeResult(jspPath, jspFileName, content);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("生成==========");
    }


    /**
     * 生成后端代码
     */
    public void generateCode(String pkg, String Bean,String bean,List<String> opTypes) {
        String repositoryFtl = "/Repository.ftl";
        String serviceFtl = "/Service.ftl";
        String actionFtl = "/Action.ftl";

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("pkg", pkg);       //包名
        map.put("Bean", Bean);     //类名
        map.put("bean", bean);     //实体名
        map.put("opTypes",opTypes); //操作集合

        this.generateBackGroundCode(repositoryFtl,"repository","Repository", map);
        this.generateBackGroundCode(serviceFtl, "service","Service",map);
        this.generateBackGroundCode(actionFtl, "controller","Action",map);
        System.out.println("生成==========");

    }


    /**
     * 生成后端代码
     * @param ftl
     * @param pkgName          实体类所在的包的名称
     * @param classSuffix       实体类所在的包生成类时候的后缀
     * @param model
     */
    private void generateBackGroundCode(String ftl,String pkgName,String classSuffix,Map<String, Object> model){
        String content = freemarkerTemplate.getContent(ftl, model);
        if (!StringUtils.isEmpty(content)) {
            try {
                ///src/main/java/com/yue/controller
                String javaPath = projectPath + "/src/main/java/com/yue/" + model.get("pkg") + "/"+pkgName;
                //TestAction.java
                String javaFile =  model.get("Bean") + classSuffix+".java";
                System.out.println("javaPath=" + javaPath);
                FileUtils.writeResult(javaPath, javaFile, content);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
