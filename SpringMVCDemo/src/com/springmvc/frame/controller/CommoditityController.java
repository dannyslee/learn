package com.springmvc.frame.controller;

import java.util.List;

import com.springmvc.frame.dto.CommoditityDTO;
import com.springmvc.frame.po.CommoditityPO;
import com.springmvc.frame.service.CommoditityService;
import com.springmvc.frame.service.imp.CommoditityServiceImp;
import com.woniuxy.springmvc.annotation.framework.Controller;
import com.woniuxy.springmvc.annotation.handlermapping.RequestMapping;
import com.woniuxy.springmvc.annotation.handlermapping.ResponseBody;

@Controller
@RequestMapping("/commo")
public class CommoditityController {
	//根据获取到的商品类型id，得到该类型下的所有商品
	//+功能：对页面实现分页展示
	@ResponseBody
	@RequestMapping("/showCommo")
	public CommoditityDTO showAllCommodities(int t_id,int page) {
		List<CommoditityPO> commoditityPO =null;
		CommoditityDTO CommoditityDTO=null;
		//service根据获取的商品类型id，返回商品
		CommoditityService commoditityService = new CommoditityServiceImp();
		//.getSearchAllCommodities(t_id);
		commoditityPO = commoditityService.getSearchCommodititesBytid(t_id,page);
		if(commoditityPO!=null) {
			CommoditityDTO = new CommoditityDTO(commoditityService);
		}
		return CommoditityDTO;	
	}
	
}