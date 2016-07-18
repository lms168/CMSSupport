package com.yue.generate.service;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import java.util.Map;

/**
 * Created by lms on 16-7-15.
 */

public class FreemarkerTemplate {


    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * web类型的
     */
    private FreeMarkerConfigurer freeMarkerConfigurer;

    /**
     * 非web类型的
     */
    private Configuration freeMarkerConfiguration;


    public void setFreeMarkerConfigurer(FreeMarkerConfigurer freeMarkerConfigurer) {
        this.freeMarkerConfigurer = freeMarkerConfigurer;
    }

    public void setFreeMarkerConfiguration(Configuration freeMarkerConfiguration) {
        this.freeMarkerConfiguration = freeMarkerConfiguration;
    }


    public String getContent(String templateName, Object model) {
        try {
            Template t = freeMarkerConfigurer.getConfiguration().getTemplate(templateName);
            return FreeMarkerTemplateUtils.processTemplateIntoString(t, model);
        } catch (Exception ex) {
                logger.info("在WEB-INFO下面没有找到模板文件，将在classPath路径下面进行寻找");
            try {
                Template t = freeMarkerConfiguration.getTemplate(templateName);
                return FreeMarkerTemplateUtils.processTemplateIntoString(t, model);
            } catch (Exception e) {
                e.printStackTrace();
                logger.equals(e.getMessage());
            }
        }

        return null;
    }



}
