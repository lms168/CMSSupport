package com.yue.auth.controller;

import com.yue.auth.bean.User;
import com.yue.auth.service.AuthService;
import com.yue.common.BaseController;
import com.yue.common.BasePageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
        BasePageVO basePageVO = this.getBaseConditionVo();
        Page<User> userPage = authService.findAllDynatic(user,basePageVO.getPageable());
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
