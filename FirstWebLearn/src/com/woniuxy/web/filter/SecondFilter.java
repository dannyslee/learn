package com.woniuxy.web.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Servlet Filter implementation class SecondFilter
 */
public class SecondFilter implements Filter {

    /**
     * Default constructor. 
     */
    public SecondFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("SecondFilter-doFilter执行，用于SecondFilter对象的过滤规则");
		
		System.out.println("2放行前 ");
		chain.doFilter(request, response);
		//放行后，处理 响应
		System.out.println("2放行……");
		//response.setContentType("text/html;charset=utf-8");
		System.out.println("2放行后");
;
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
