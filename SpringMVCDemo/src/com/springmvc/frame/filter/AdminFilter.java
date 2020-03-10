package com.springmvc.frame.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class AdminFilter
 */
public class AdminFilter implements Filter {

   
    public AdminFilter() {
    }

	
	public void destroy() {

	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest)request;
		Object user = req.getSession().getAttribute("user");
		if(user==null) {
			req.getRequestDispatcher("login.jsp").forward(request, response);
		}else {
			chain.doFilter(request, response);

		}
		
		
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
