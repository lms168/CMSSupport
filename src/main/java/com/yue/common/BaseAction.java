package com.yue.common;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by lms on 16-7-3.
 */
public class BaseAction implements InitializingBean {



    @Autowired
    protected HttpServletRequest request;



    public BasePageVO getBasePageVO() {
        return basePageVO;
    }

    protected BasePageVO basePageVO;

    protected ModelAndView mv = new ModelAndView();



    /**
     * 获取分析信息组装bean
     * @return
     */
    protected BasePageVO getBaseConditionVo(){
        return (BasePageVO)request.getAttribute("basePageVO");
    }




    protected ModelAndView ajaxDone(int statusCode, String message, String forwardUrl) {
        ModelAndView mav = new ModelAndView("ajaxDone");
        mav.addObject("statusCode", statusCode);
        mav.addObject("message", message);
        mav.addObject("forwardUrl", forwardUrl);
        return mav;
    }


    protected ModelAndView ajaxDoneSuccess(String message) {
        return ajaxDone(200, message, "");
    }


    protected ModelAndView ajaxDoneError(String message) {
        return ajaxDone(300, message, "");
    }


    public void afterPropertiesSet() throws Exception {
        System.out.println("============================执行=======================");

    }
}
