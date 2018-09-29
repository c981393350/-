package com.qianfeng.dao;

import java.util.List;
import java.util.Map;

import com.qianfeng.entity.Sign;


public interface ISignDao {
	public List<Sign> findByIndexAndSize(Map<String, Object> info);

	public int count();
}
