package com.woniuxy.springmvc.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.woniuxy.springmvc.annotation.Controller;
import com.woniuxy.springmvc.annotation.RequestMapping;
import com.woniuxy.springmvc.annotation.ResponseBody;
import com.woniuxy.springmvc.annotation.ResponseRedirect;
import com.woniuxy.springmvc.po.UserPO;

@Controller
@RequestMapping("/u")
public class UserController {
	@RequestMapping("/login")
	public void login(HttpServletRequest req) {
		System.out.println("UserController获取到：" + req.getRequestURI());
	}

	@RequestMapping("/reg")
	public void register(HttpServletResponse resp) {
		try {
			resp.setContentType("text/html; charset=UTF-8");
			resp.getWriter().write("牛逼呀！兄弟！");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@RequestMapping("/prim")
	public void primitiveDemo(byte b, short s, long l, float f, double d, char c, boolean bool, String str,
			BigDecimal bd, String[] arr) {
		// 客户端传入基本数据类型演示
		System.out.println(b);
		System.out.println(s);
		System.out.println(l);
		System.out.println(f);
		System.out.println(d);
		System.out.println(c);
		System.out.println(bool);
		System.out.println(str);
		System.out.println(bd);
		System.out.println(str);
	}

	@RequestMapping("/arr")
	public void primitiveArr(Demo demo) {
		System.out.println(demo.toString());
	}
	
	@ResponseRedirect
	@RequestMapping("/test")
	public String test() {
		System.out.println("test执行了~~~");
		return "index.jsp";
	}
	
	@RequestMapping("/json")
	@ResponseBody
	public List<UserPO> jsonTest(){
		List<UserPO> u =null;
		UserPO po =new UserPO(1,"admin","123");
		UserPO po1 =new UserPO(2,"adminn","133");
		u = new ArrayList<>();		
		u.add(po1);
		u.add(po);
		return u;		
	}
}
