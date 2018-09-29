package com.qianfeng.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qianfeng.dao.IUserDao;
import com.qianfeng.entity.User;
import com.qianfeng.service.IUserService;
@Service
public class UserService implements IUserService{

	@Autowired
	private IUserDao userDao;
	@Override
	public Map<String,Object> addOneUser(User user) {
		Map<String, Object> map = new HashMap<>();
		try {
			int one = userDao.addOne(user);
			map.put("data", one);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}

}
