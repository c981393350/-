package com.qianfeng.controller;
import java.util.HashMap;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class loginController {
	@RequestMapping("login")
	@ResponseBody
	public Map<String,Object> login(String no, String password){
		Map<String,Object> map = new HashMap<>();
		UsernamePasswordToken token = new UsernamePasswordToken(no, password);
	
		Subject subject = SecurityUtils.getSubject();
		
		try {
			
			subject.login(token);
			map.put("code", 1);
		} catch (AuthenticationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			map.put("code", 0);
			map.put("msg", e.getMessage());
		}
		return map;
		
	}
}
