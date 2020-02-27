package com.woniuxy.web.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Servlet Filter implementation class FirstFilter
 */
public class FirstFilter implements Filter {
	/*
	 * 1.创建类，实现Filter接口
	 * 2.实现接口中所有方法
	 * 3.对Filter进行配置声明
	 *         web.xml(web2.5及以下)
	 *           Filter注册
	 *           <filter>
	 *              <filter-name>类名</filter-name>
	 *               <filter-class>类全名</filter-calss>
	 *           </filter>
	 *           Filter注册
	 *           <filter-mapping>
	 *              <filter-name>类名</filter-name>
	 *               1.过滤的页面路径，例如/jsp/* 或者 /jsp/forward.jsp
	 *               <url-pattern>/*</url-pattern> 
	 *               2.扩展路径，例如 *.jsp 过滤所有jsp后缀内容
                      <url-pattern>*.jsp</url-pattern> 
	 *           </filter-mapping>
	 * 
	 */

    /**
     * Default constructor. 
     */
    public FirstFilter() {
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		System.out.println("FirstFilter-destroy执行，用于FirstFilter对象的资源释放");

	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		System.out.println("FirstFilter-doFilter执行，用于FirstFilter对象的过滤规则");
		//设置请求编码
		response.setCharacterEncoding("utf-8");
		//放行前，处理 请求
		
		System.out.println("放行前 ");
		chain.doFilter(request, response);
		//放行后，处理 响应
		System.out.println("放行……");
		//response.setContentType("text/html;charset=utf-8");
		System.out.println("放行后");

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("FirstFilter-init执行，用于FirstFilter对象的初始化工作");
	}

}
