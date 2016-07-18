package com.yue.generate.controller;

import com.yue.common.BaseAction;
import com.yue.generate.entity.GenerateForm;
import com.yue.generate.entity.PropertiesBean;
import com.yue.generate.service.GenerateService;
import com.yue.utils.StringUtil;
import com.yue.utils.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lms on 16-7-18.
 */
@Controller
@Scope("prototype")
@RequestMapping("generate")
public class GenerateAction extends BaseAction{

    @Autowired
    private GenerateService generateService;

    Logger logger = Logger.getLogger(this.getClass());

    @RequestMapping("/toAdd")
    public String toGeneratePage(){
        return "generate/add";
    }


    @RequestMapping("/getTableInfo")
    @ResponseBody
    public  List<PropertiesBean> getTableInfo(GenerateForm generateForm) throws ClassNotFoundException {
        List<PropertiesBean> list = new ArrayList<PropertiesBean>();
        if (StringUtils.isEmpty(generateForm.getEntityName())){
            logger.error("实体类不存在");
            return list;
        }
        Class cls = Class.forName(generateForm.getEntityName());
        Field[] fields = cls.getDeclaredFields();

        PropertiesBean propertiesBean = null;
        for (Field field:fields){
            propertiesBean = new PropertiesBean();
            propertiesBean.setFieldName(field.getName());
            String fileType = field.getType().getName();
            list.add(propertiesBean);
        }
        return  list;
    }


    @RequestMapping("/doGenerate")
    public ModelAndView doGenerate(GenerateForm generateForm){
        if (StringUtils.isEmpty(generateForm.getEntityName())){
            return ajaxDoneError("表名不能为空");
        }

        if (generateForm.getOpType().size()==0){
            return ajaxDoneError("请选择要生成那些代码");
        }

        String[] dirs = generateForm.getEntityName().split(".");
        String pkg = dirs[2];
        String Bean = dirs[4];
        String bean = Bean.substring(0, 1).toLowerCase() + Bean.substring(1); //将类名的首字母小写变为对象名
        generateService.generateCode(pkg,Bean,bean);
        return ajaxDoneSuccess("生成代码成功");
    }


}
