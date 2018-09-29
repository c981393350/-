package com.qianfeng.service;

import com.qianfeng.entity.Sign;
import com.qianfeng.vo.PageBean;

public interface ISignService {
	public PageBean<Sign> findAllSignByPage(int page);
}
