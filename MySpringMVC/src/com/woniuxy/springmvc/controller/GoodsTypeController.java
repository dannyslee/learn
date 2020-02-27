package com.woniuxy.springmvc.controller;

import com.woniuxy.springmvc.annotation.Controller;
import com.woniuxy.springmvc.annotation.RequestMapping;

@Controller
@RequestMapping("/gt")
public class GoodsTypeController {
	@RequestMapping("/show")
	public void show() {
		System.out.println("this is a GoodsTypeController show demo");
	}
}
