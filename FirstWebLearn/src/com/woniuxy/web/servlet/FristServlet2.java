package com.woniuxy.web.servlet;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FristServlet2 extends HttpServlet {

	
	/*
	 * 创建Servlet
	 * 1.创建Class类，继承HttpServlet；
	 * 2.重写service方法(doGet、doPost)
	 * 3.配置声明；
	 *     web2.5
	 *        配置web.xml
	 *        操作 
	 *           servlet注册
	 *              <servlet>
	 *                 <servlet-name>类名</servlet-class>
	 *                 <servlet-class>类全名（全限定类名）</servlet-class>
	 *              </servlet>
	 *           servlet映射
	 *              <servlet-mapping>
	 *                 <servlet-name>类名</servlet-name>
	 *                 <url-pattern>/客户端访问名称</url-pattern>
	 *              </servlet-mapping>
	 *     web3.0及以后
	 *         注解
	 */
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		//super.init();
		System.out.println("init");
		//由服务器自动调用，用于对Servlet进行初始化工作，作用类似于构造方法（出生）
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		//设置请求编码
//		req.setCharacterEncoding("UTF-8");
//
//		//获取url
//		System.out.println("URL:"+req.getRequestURL());
//		
//		//获取URI
//		System.out.println("URL:"+req.getRequestURI());
//		
//		//获取项目名称
//		System.out.println("项目名称"+req.getContextPath());
//		
//		//获取当前请求方式‘
//		System.out.println("请求方式："+req.getMethod());
//		
//		//获取请求头信息（某一个字段）
//		System.out.println("请求头字段："+req.getHeader("Accept"));
//		
		//获取请求：一键多参
//		String[] vals = req.getParameterValues("language");
//		for(String val:vals) {
//			System.out.println(val);
//		}
		
		//获取所有页面参数
//		Map<String,String[]> reqs = req.getParameterMap();
//		System.out.println(reqs.get("demo")[0]);
		
		//响应常用方法
		//设置响应编码，必须在操作响应对象前操作
//		resp.setCharacterEncoding("UTF-8");
		//设置相应内容类型
		resp.setContentType("Text/html;charset=utf8");
		//设置指向客户端的输出流
//		resp.getOutputStream(); //字节流
//		resp.getWriter(); //字符流
		//设置响应头
//		resp.setHeader(name, value);
		//设置客户端响应状态码
//		resp.sendError(404,"看？");
		PrintWriter pw = resp.getWriter();
//		String a = null;pw.write(a)
		pw.write("xxxx");//pw.print()
		pw.flush();
		pw.close();

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		// super.destroy();
		System.out.println("destroy");
		// 由服务器自动调用，用于对Servlet占用资源进行释放（死亡）
		
	}

	
	
	
	
}
