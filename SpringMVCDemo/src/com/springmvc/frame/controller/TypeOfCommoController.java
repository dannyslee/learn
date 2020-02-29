package com.springmvc.frame.controller;

import java.util.List;

import com.springmvc.frame.po.TypeofCommoPO;
import com.springmvc.frame.service.TypeOfCommoService;
import com.springmvc.frame.service.imp.TypeOfCommoServicelmp;
import com.woniuxy.springmvc.annotation.framework.Controller;
import com.woniuxy.springmvc.annotation.handlermapping.RequestMapping;
import com.woniuxy.springmvc.annotation.handlermapping.ResponseBody;

@Controller
@RequestMapping("/type")
public class TypeOfCommoController {
	//展示所有的商品类型
	@ResponseBody
	@RequestMapping("/showType")
	public List<TypeofCommoPO> showAllTypeOfCommo() {
		List<TypeofCommoPO> listTypeofCommoPO = null;
		//业务逻辑层，要反馈得到的showAll~
		//实例化一个servcie对象
		TypeOfCommoService typeOfCommoService = new TypeOfCommoServicelmp();
		//调用该service对象的getSearchAllTypeOfCommo方法,获取所有的商品类型
		listTypeofCommoPO = typeOfCommoService.getSearchAllTypeOfCommo();		
		return listTypeofCommoPO;		
	}
	
}