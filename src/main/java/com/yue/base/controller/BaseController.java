package com.yue.base.controller;

import com.yue.base.entity.BaseAjaxBean;
import com.yue.base.entity.BaseConditionVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by lms on 16-7-3.
 */
public class BaseController {
    @Autowired
    protected HttpServletRequest request;

    public BaseConditionVO getBaseConditionVO() {
        return baseConditionVO;
    }

    protected BaseConditionVO baseConditionVO;

    protected ModelAndView mv = new ModelAndView();

    protected BaseAjaxBean baseAjaxBean = new BaseAjaxBean();

    /**
     * 获取分析信息组装bean
     * @return
     */
    protected BaseConditionVO getBaseConditionVo(){
        System.out.println("注入get");
        return (BaseConditionVO)request.getAttribute("baseConditionVO");
    }




//    protected BaseAjaxBean getBaseAjaxBean() {
//        baseAjaxBean = (BaseAjaxBean) request.getAttribute("baseAjaxBean");
//        if (baseAjaxBean==null){
//            baseAjaxBean = new BaseAjaxBean();
//        }
//        return baseAjaxBean;
//
//    }


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


}
