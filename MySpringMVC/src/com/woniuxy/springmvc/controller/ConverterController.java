package com.woniuxy.springmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.woniuxy.springmvc.annotation.RequestMapping;
import com.woniuxy.springmvc.annotation.RequestParam;
import com.woniuxy.springmvc.po.UserPO;

@RequestMapping("/util")
public class ConverterController {
	@RequestMapping("/converter")
	public String  doConverter(@RequestParam("UserPO") UserPO po,HttpServletRequest req) {
		//req.setAttribute("Userpo", po);
		return "UserPO";
	}
}
