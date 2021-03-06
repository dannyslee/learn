package com.woniuxy.web.listener;

import java.util.Enumeration;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class ServletRequestListenerDemo
 *
 */
public class ServletRequestListenerDemo implements ServletRequestListener,HttpSessionListener,ServletContextListener {
	/*
	 * 监听request创建与销毁：SwevletRequestListener
	 * 监听session创建与销毁：HttpSessionListener
	 * 监听application创建与销毁： ServletContextListener
	 * 创建监听器
	 *    1.创建类，实现目标监听器接口；
	 *    2.实现监听器接口中所有方法
	 *    3.对监听器进行配置声明（第三类监听器不需要）
	 *          web.xml(web2.5及以下)
	 *             对listener进行注册
	 *             <listener>
	 *                监听器全名
	 *             </listener>
	 * 
	 *          注解（Web3.0以上）
	 * 
	 * 
	 */

	
    public ServletRequestListenerDemo() {

    }


    public void requestDestroyed(ServletRequestEvent sre)  { 
    	System.out.println("销毁request对象前，调用requestDestroyed");
    }


    public void requestInitialized(ServletRequestEvent sre)  { 
    	System.out.println("创建request对象后，调用requestInitialized");
    }

    public int i=0;
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("sessionCreated");
		if(se.getSession().isNew()) {
			i++;
		}
		
		System.out.println("sessionCreated:"+i);
		
//		for (Enumeration<String> code = se.getSession().getAttributeNames(); code.hasMoreElements();) {
//			System.out.println(code.nextElement());
//			i++;
//		}
//		System.out.println("sessionCreated:"+i);
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("sessionDestroyed");
		i--;
		//se.getSession();
		
	}


	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("contextInitialized");
		//sce.getServletContext();
	}


	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("contextDestroyed");
		//sce.getServletContext();

	}
	
}
