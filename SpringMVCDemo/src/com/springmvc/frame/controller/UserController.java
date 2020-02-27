package com.springmvc.frame.controller;

import com.woniuxy.springmvc.annotation.Controller;
import com.woniuxy.springmvc.annotation.RequestMapping;
import com.woniuxy.springmvc.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {
	@ResponseBody
	@RequestMapping("/login")
	public String login(String account,String pass) {
		System.out.println(account+pass);
		return "AMD!YES!";
	}
}
