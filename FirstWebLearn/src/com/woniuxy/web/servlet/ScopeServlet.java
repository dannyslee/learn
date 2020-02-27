package com.woniuxy.web.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.woniuxy.web.listener.ActivationListener;
import com.woniuxy.web.listener.BindingListener;

/**
 * Servlet implementation class ScopeServlet
 */
public class ScopeServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//request作用域
		req.setAttribute("requestKey", "requsetValue");
		System.out.println(req.getAttribute("requestKey"));
		
		//session作用域
		HttpSession session = req.getSession();
		//System.out.println(session.getId());
		//session.setMaxInactiveInterval(50);
		session.setAttribute("sessionKey", "sessionValue");
		System.out.println(session.getAttribute("sessionKey"));
		
		session.setAttribute("sessionKey", "sV");
		System.out.println(session.getAttribute("sessionKey"));
		
		session.setAttribute("sessionKey", new BindingListener());
		System.out.println(session.getAttribute("sessionKey"));
		
		session.setAttribute("sessionKey", new ActivationListener());
		System.out.println(session.getAttribute("sessionKey"));
		
		//关闭session
		//session.invalidate();
		
		//application作用域
//		ServletContext application = req.getServletContext();
//		application.setAttribute("appKey", "appValue");
//		System.out.println(application.getAttribute("appKey"));
	}

	
	
    

}
