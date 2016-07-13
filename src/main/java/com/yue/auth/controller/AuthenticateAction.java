package com.yue.auth.controller;

import com.yue.auth.bean.User;
import com.yue.auth.service.AuthService;
import com.yue.utils.StringUtils;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by lms on 16-6-20.
 * 验证
 */

@Controller
@Scope("prototype")
public class AuthenticateAction {
    private Logger logger = Logger.getLogger(this.getClass());
    private final String loginView = "login";
    private final String indexView = "index";
    @Resource(name = "authService")
    private AuthService authService;

    @RequestMapping(value = "/login")
    public String login(){
        System.out.println("前往登陆页面!");
        return loginView;
    }


    @RequestMapping(value="/loginOut")
    public String loginOut(){
        Subject currentUser = SecurityUtils.getSubject();
        String result = "logout";
        currentUser.logout();
        System.out.println("退出登陆页面!");
        return loginView;
    }



    @RequestMapping(value="/loginAuthc")
    public String loginAuthc(User user,HttpSession session,HttpServletRequest request){
        System.out.println("登陆验证");
        Subject currentUser = SecurityUtils.getSubject();
        String result = loginView;

        String code = (String) session.getAttribute("VALIDATE_CODE");
        String submitCode = WebUtils.getCleanParam(request,"validateCode");

        if (StringUtils.isEmpty(submitCode)||!StringUtils.equals(code,submitCode)){
            System.out.println("验证码不正确，请重新输入验证码");
            return "redirect:/login";
        }



        if (!currentUser.isAuthenticated()){  //没有认证则登陆
            result = login(currentUser,user.getLoginName(),user.getPassword());
        }else{ //重复登陆
            User shiroUser = (User) currentUser.getPrincipal();
            if (!shiroUser.getLoginName().equals(user.getLoginName())){
                currentUser.logout();
                result=login(currentUser,user.getLoginName(),user.getPassword());
            }

        }
        System.out.println("=========================main" + result);
        return result;
    }


    private String login(Subject currentUser,String loginName,String password){
        String result = "index";
        //此处会调用myrelam中的  doGetAuthenticationInfo身份验证方法
        UsernamePasswordToken token = new UsernamePasswordToken(loginName, password);
        token.setRememberMe(false);
        try {
            currentUser.login(token);
            result = indexView;
        } catch (UnknownAccountException uae) {
            result = "failure";
        } catch (IncorrectCredentialsException ice) {
            result = "failure";
        } catch (LockedAccountException lae) {
            result = "failure";
        } catch (AuthenticationException ae) {
            result = "failure";
        }
        return result;
    }

}
