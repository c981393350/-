package com.qianfeng.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qianfeng.entity.Sign;
import com.qianfeng.service.ISignService;
import com.qianfeng.vo.JsonBean;
import com.qianfeng.vo.PageBean;

@Controller
public class SignController {
	@Autowired
	private ISignService signService;
//	@RequestMapping(value="/emp/page/{page}", method=RequestMethod.GET)
	@RequestMapping("sign/{page}")
	@ResponseBody
	public JsonBean findAllUser(@PathVariable("page") int page){
		JsonBean bean = new JsonBean();
		PageBean<Sign> pageInfo = signService.findAllSignByPage(page);
		bean.setCode(1);
		bean.setMsg(pageInfo);
		return bean;
	}
}
