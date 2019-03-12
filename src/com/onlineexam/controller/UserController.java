package com.onlineexam.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.onlineexam.pojo.UserBean;
import com.onlineexam.service.UserServiec;


@Controller
public class UserController {
	
	@Autowired
	private UserServiec service;
	
	//�����½ҳ��
	@RequestMapping("show")
	public String login1(){
		return "upload";
	}
	
	//��¼��֤
	@RequestMapping("indexss")
	public String index(UserBean user,HttpServletRequest req){
		UserBean u = service.indexss(user);
		System.out.println(u);
		if(u!=null){
			req.getSession().setAttribute("user", u);
			req.setAttribute("user", u);
			return "up";
		}else{
			req.setAttribute("msg", "�û������������");
			return "login";
		}
		
	}
}
