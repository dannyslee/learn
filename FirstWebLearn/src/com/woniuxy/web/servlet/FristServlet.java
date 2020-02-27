package com.woniuxy.web.servlet;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FristServlet extends HttpServlet {

	
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
		// TODO Auto-generated method stub
		// super.service(req, resp);
		System.out.println("service");
		// 获取config信息
		ServletConfig conf = getServletConfig();
		System.out.println("Servlet类名" + conf.getServletName());
		// 获取Servlet配置的初始化参数
		System.out.println(conf.getInitParameter("user"));
		System.out.println(conf.getInitParameter("password"));
		// 将获取的元素以保存（键值对形式）
		Enumeration<String> enus = conf.getInitParameterNames();
		// 判断释放存在下一个元素
		while (enus.hasMoreElements()) {
			// 获取下一个元素
			String key = enus.nextElement();
			System.out.println(conf.getInitParameter(key));
		}

		// 获取info信息
		//String str = getServletInfo();
		//System.out.println("getServletInfo():" + str);
		resp.setContentType("Text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		//out.write(),可以写在控制台，print(),写入并打印
		out.print("<html>");
		out.print("<head><title>Servlet</title></head>");
		out.print("<body>");
		out.print("<form action=\"../null\" method=\"post\">");
		out.print("<input type=\"text\" id=\"account\" name=\"account\"/>");
		out.print("<input type=\"submit\" value=\"submint\"/>");
		out.print("</form>");
		out.print("</body>");
		out.print("</html>");
		
		System.out.println(req.getParameter("account"));//获取html数据 name
			
	}
	
	

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		// super.destroy();
		System.out.println("destroy");
		// 由服务器自动调用，用于对Servlet占用资源进行释放（死亡）
		
	}

	
	
	
	
}
