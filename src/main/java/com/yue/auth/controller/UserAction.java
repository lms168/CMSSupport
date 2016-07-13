package com.yue.auth.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import com.yue.base.entity.BaseAjaxBean;
import com.yue.base.entity.BaseConditionVO;
import com.yue.auth.bean.User;
import com.yue.auth.service.AuthService;
import com.yue.base.controller.BaseController;
import org.jboss.logging.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by lms on 16-6-20.
 */
@Controller
@Scope("prototype")
@RequestMapping("user")
public class UserAction extends BaseController{
    @Autowired
    private AuthService authService;


    @RequestMapping("/page")
    public ModelAndView pageUser(User user) {
//        User searchUser = new User();
//        searchUser.setUsername(username);
        System.out.println("sss===================" + user.getUsername());
        System.out.println("username====================" + this.request.getParameter("username"));
        BaseConditionVO baseConditionVO = this.getBaseConditionVo();
        Page<User> userPage = authService.findAllDynatic(user,baseConditionVO.getPageable());
        mv.addObject("pageResult",userPage);
        mv.setViewName("customerList");
        return mv;
    }


    @RequestMapping("/findByCusId")
    public ModelAndView findByCusId(User user){
        if (user.getId()!=null){
            user =   authService.findUserById(user.getId());
        }
        mv.addObject("user", user);
        mv.setViewName("addOrEditCus");
        return mv;
    }



    @RequestMapping("/save")
    public ModelAndView saveCustomer(User user){
        try {
            authService.saveUser(user);
        }catch (Exception e){
           return ajaxDoneError("用户保存失败");
        }
        return ajaxDoneSuccess("用户保存成功");
    }


    @RequestMapping("/delete")
    public ModelAndView deleteCustomer(User user){
        try{
            authService.deleteUser(user);
        }catch (Exception e){
         return  ajaxDoneError("删除用户失败");
        }
        return ajaxDoneSuccess("删除用户成功");
    }

}
