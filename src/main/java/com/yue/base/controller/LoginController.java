package com.yue.base.controller;

import java.util.ArrayList;
import java.util.List;

import com.yue.auth.service.AuthService;
import org.apache.log4j.Logger;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yue.auth.bean.User;

@Controller
@Scope("prototype")
public class LoginController extends BaseController {
	private static Logger log = Logger.getLogger(LoginController.class);
	@Autowired
	private AuthService authService;


	@RequestMapping(value="/index1")
	@RequiresRoles("admin")
	public String index1(){
		System.out.println("=========================index1");
		return "customerList";
	}
	
	@ResponseBody
	@RequestMapping(value="/json")
	public List<String> json() {
		List<String> list = new ArrayList<String>();
		for (int i = 0; i<10; i++){
			list.add("xxxxxx" + i);
		}
		return list;
	}
	
	@ResponseBody
	@RequestMapping("/save")
	public String saveUser() {
		log.warn("访问--------------------" + LoginController.class.getResource("/"));
		User user = new User();
		user.setUsername("mengxy");
		user.setPassword("mengxy");
		this.authService.saveUser(user);
		return "ajaxResult";
	}
	@ResponseBody
	@RequestMapping("/findbyid/{id}")
	public User findById(@PathVariable long id){
		return this.authService.findUserById(id);
	}
	
	@ResponseBody
	@RequestMapping("/findbyusername/{username}")
	public List<User> findByUsername(@PathVariable String username){
//		return this.authService.findUserByLoginName(username);
		return null;
	}
}
