package com.springmvc.newpackage.controller;


import com.springmvc.newpackage.result.Result;
import com.springmvc.newpackage.service.factory.ServiceFactory;
import com.woniuxy.springmvc.annotation.framework.Controller;
import com.woniuxy.springmvc.annotation.handlermapping.RequestMapping;
import com.woniuxy.springmvc.annotation.handlermapping.ResponseBody;

@Controller
@RequestMapping("/commo")
public class CommoController {
	/**
	 * 根据获取到的商品类型id，得到该类型下的所有商品 
	 *   +功能：对页面实现分页展示
	 * 
	 * @param t_id
	 * @param page
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/showCommo")
	public Result showAllCommodities(int t_id, int page) {
		return ServiceFactory.getInstance("commo").getCommo().getSearchCommodititesBytid(t_id, page);
	}
	
	@ResponseBody
	@RequestMapping("/showOneCommo")
	public Result showOneCommodity(int c_id) {
		return ServiceFactory.getInstance("commo").getCommo().getSearchCommoditityBycid(c_id);
	}

}
