package com.woniuxy.springmvc.controller;

import com.woniuxy.springmvc.annotation.Controller;
import com.woniuxy.springmvc.annotation.RequestMapping;

@Controller
@RequestMapping("/gc")
public class GoodsController {
	@RequestMapping("/show")
	public void show() {
		System.out.println("this is a show demo");
	}
}
