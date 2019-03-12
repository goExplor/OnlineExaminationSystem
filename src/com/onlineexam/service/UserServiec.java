package com.onlineexam.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineexam.mapper.UserMapper;
import com.onlineexam.pojo.UserBean;
@Service
public class UserServiec {

	@Autowired
	private UserMapper mapper;
	
	public UserBean indexss(UserBean user) {
		UserBean u=mapper.indexss(user);
		
		return u;
	}
	
	
}
