package com.springmvc.frame.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.woniuxy.springmvc.annotation.framework.Controller;
import com.woniuxy.springmvc.annotation.handlermapping.RequestMapping;
import com.woniuxy.springmvc.annotation.handlermapping.ResponseBody;

import cn.dsna.util.images.ValidateCode;

@Controller
@RequestMapping("/test")
public class TestController {

	@ResponseBody
	@RequestMapping("/login")
	public String login(String account, String pass) {
		System.out.println(account + pass);
		return "AMD!YES!";
	}

	@ResponseBody
	@RequestMapping("/ajax")
	public String ajaxtest(String name, int age) {
		System.out.println(name + ":" + age);
		return "测试成功";
	}
	
	@ResponseBody
	@RequestMapping("/ajax2")
	public boolean ajaxtest2() {
		System.out.println(false);
		return false;
	}
	
	
	@ResponseBody
	@RequestMapping("/ajax3")
	public boolean ajaxtest3() {
		System.out.println(true);
		return true;
		
	}
	
	
	
	@RequestMapping("/getpic")
	public void getPicture(HttpServletResponse resp,HttpServletRequest req) {
		// 获取验证码
		System.out.println("获取验证码");
		// 创建验证码对象
		ValidateCode code = new ValidateCode(100, 36, 4, 3);
		// 获取验证码字符串
		String codeStr = code.getCode();
		// 存入session
		req.getSession().setAttribute("loginCode", codeStr);
		System.out.println(codeStr);
		// 获取验证码图片
		// BufferedImage buffImg = code.getBuffImg();
		// 用于指定输出流输出验证码图片
		try {
			code.write(resp.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	

}
