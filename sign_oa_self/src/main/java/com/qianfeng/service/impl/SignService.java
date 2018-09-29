package com.qianfeng.service.impl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qianfeng.dao.ISignDao;
import com.qianfeng.entity.Sign;
import com.qianfeng.service.ISignService;
import com.qianfeng.vo.PageBean;
@Service
public class SignService implements ISignService{

	@Autowired
	private ISignDao signDao;

	@Override
	public PageBean<Sign> findAllSignByPage(int page) {
		PageBean<Sign> pageInfo = new PageBean<>();
		
		pageInfo.setCurrentPage(page);
		
		// 获取表中的记录总数
		int count = signDao.count();
		// 计算总页数
		if(count % pageInfo.getPageSize() == 0){
			pageInfo.setTotalPage(count / pageInfo.getPageSize());
		}else{
			pageInfo.setTotalPage(count / pageInfo.getPageSize()+ 1);
		}
		// 根据页码计算分页查询时的开始索引
		int index = (page - 1) * pageInfo.getPageSize();
		Map<String, Object> map = new HashMap<>();
		map.put("index", index);
		map.put("size", pageInfo.getPageSize());
		List<Sign> list = signDao.findByIndexAndSize(map);
		pageInfo.setPageInfos(list);
		
		return pageInfo;
	}
	

}
