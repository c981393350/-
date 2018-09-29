package com.qianfeng.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qianfeng.entity.User;
import com.qianfeng.service.IUserService;

@Controller
public class UserController {
	@Autowired
	private IUserService userService;
	
	@ResponseBody
	@RequestMapping("register")
	public Map<String,Object> insertOne(User user){
		Map<String,Object> map = new HashMap<>();
		Map<String,Object> map2 = new HashMap<>();
		try {
			map = userService.addOneUser(user);
			map2.put("code", 0);
			map2.put("data", map);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			map2.put("code", 1);
			map2.put("msg", e.getMessage());
		}
		return map2;
		
	}
}
