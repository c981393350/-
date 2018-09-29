package com.qianfeng.dao;

import com.qianfeng.entity.User;

public interface IUserDao {

	public User findByName(String no);
	
	public int addOne(User user);
}
