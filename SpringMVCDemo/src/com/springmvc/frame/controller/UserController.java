package com.springmvc.frame.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import com.woniuxy.springmvc.annotation.Controller;
import com.woniuxy.springmvc.annotation.RequestMapping;
import com.woniuxy.springmvc.annotation.ResponseBody;

import cn.dsna.util.images.ValidateCode;

@Controller
@RequestMapping("/user")
public class UserController {
	@ResponseBody
	@RequestMapping("/login")
	public String login(String account,String pass) {
		System.out.println(account+pass);
		return "AMD!YES!";
	}
	@RequestMapping("/getpic")
	public void getPicture(HttpServletResponse resp) {
		//获取验证码
		System.out.println("获取验证码");
		//创建验证码对象
		ValidateCode code = new ValidateCode(500,200,8,5);
		//获取验证码字符串
		String codeStr = code.getCode();
		System.out.println(codeStr);
		//获取验证码图片
		//BufferedImage buffImg = code.getBuffImg();
		//用于指定输出流输出验证码图片
		try {
			code.write(resp.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
