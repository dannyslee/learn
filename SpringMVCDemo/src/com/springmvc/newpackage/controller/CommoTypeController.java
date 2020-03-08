package com.springmvc.newpackage.controller;


import com.springmvc.newpackage.result.Result;
import com.springmvc.newpackage.service.factory.ServiceFactory;
import com.woniuxy.springmvc.annotation.framework.Controller;
import com.woniuxy.springmvc.annotation.handlermapping.RequestMapping;
import com.woniuxy.springmvc.annotation.handlermapping.ResponseBody;

@Controller
@RequestMapping("/type")
public class CommoTypeController {
	@ResponseBody
	@RequestMapping("/showType")
	public Result showAllTypeOfCommo() {
		return ServiceFactory.getInstance("type").getCommoType().getSearchAllTypeOfCommo();		
	}
}
