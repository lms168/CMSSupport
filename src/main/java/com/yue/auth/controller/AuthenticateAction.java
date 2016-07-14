package com.yue.auth.controller;
import com.yue.auth.bean.User;
import com.yue.auth.service.AuthService;
import com.yue.utils.StringUtils;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


/**
 * Created by lms on 16-6-20.
 * 登陆验证
 */

@Controller
@Scope("prototype")
public class AuthenticateAction{
    private Logger logger = Logger.getLogger(this.getClass());
    private final String loginView = "login";
    private final String indexView = "index";
    @Resource(name = "authService")
    private AuthService authService;

    @RequestMapping(value = "/login")
    public String login(HttpServletRequest request){
        return loginView;
    }


    @RequestMapping(value="/loginOut")
    public String loginOut(){
        Subject currentUser = SecurityUtils.getSubject();
        currentUser.logout();
        return loginView;
    }



    @RequestMapping(value="/loginAuthc")
    public String loginAuthc(User user,HttpSession session,HttpServletRequest request){
        Subject currentUser = SecurityUtils.getSubject();
        String result = loginView;
        String code = (String) session.getAttribute("VALIDATE_CODE");
        String submitCode = WebUtils.getCleanParam(request,"validateCode");

        if (StringUtils.isEmpty(submitCode)||!StringUtils.equals(code,submitCode)){
            logger.error("验证码不正确，请重新输入验证码");
            request.setAttribute("message","验证码不正确");
            return result;
        }


        try {
            if (!currentUser.isAuthenticated()){  //没有认证则登陆
                    authService.checkLogin(currentUser, user.getLoginName(), user.getPassword());
            }else{ //重复登陆
                String shiroUserLoginName =  (String)currentUser.getPrincipal();
                if (!shiroUserLoginName.equals(user.getLoginName())){
                    currentUser.logout();
                    authService.checkLogin(currentUser, user.getLoginName(), user.getPassword());
                }else{
                    result=indexView;
                }
            }
        } catch (UnknownAccountException uae) {
            logger.error("用户名不存在");
            request.setAttribute("message","登陆名不存在");
            result = loginView;
        } catch (IncorrectCredentialsException ice) {
            logger.error("密码不正确");
            request.setAttribute("message","密码不正确");
            result = loginView;
        } catch (LockedAccountException lae) {
            logger.error("用户处于锁定状态");
            request.setAttribute("message","用户处于锁定状态");
            result = loginView;
        } catch (AuthenticationException ae) {
            logger.error("账户不存在");
            request.setAttribute("message","账户不存在");
            result = loginView;
        }
        System.out.println("=========================" + result);
        return result;
    }

}
