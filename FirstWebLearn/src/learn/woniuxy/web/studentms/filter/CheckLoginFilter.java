package learn.woniuxy.web.studentms.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import sun.awt.RepaintArea;

/**
 * Servlet Filter implementation class CheckLoginFilter
 */
public class CheckLoginFilter implements Filter {

  
    public CheckLoginFilter() {
    }

	public void destroy() {
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// 设置请求与响应编码，设置后，servlet的编码就不用再设置
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		// 登录权限控制
		HttpServletRequest req = (HttpServletRequest) request;

		if (req.getRequestURI().contains("class")
				|| req.getRequestURI().contains("student") ) {
			System.out.println("contains");
			if (req.getSession().getAttribute("account") == null) {
				System.out.println("3:放行前");
				request.getRequestDispatcher("jsp/index.jsp").forward(request, response);				
				return;
			} 

		}
		chain.doFilter(request, response);
		
		System.out.println("3:放行后");
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
