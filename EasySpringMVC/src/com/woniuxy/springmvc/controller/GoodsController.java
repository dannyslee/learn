package com.woniuxy.springmvc.controller;

import com.woniuxy.springmvc.annotation.framework.Controller;
import com.woniuxy.springmvc.annotation.handlermapping.RequestMapping;

@Controller
@RequestMapping("/goods")
public class GoodsController {
	@RequestMapping("/show")
	public void show() {
		System.out.println("xxx");
	}
}
