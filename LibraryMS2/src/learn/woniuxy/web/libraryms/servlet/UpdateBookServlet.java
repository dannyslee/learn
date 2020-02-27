package learn.woniuxy.web.libraryms.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import learn.woniuxy.web.libraryms.service.BookService;
import learn.woniuxy.web.libraryms.service.LibraryService;

/**
 * Servlet implementation class UpdateBookServlet
 */
public class UpdateBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LibraryService service;
	
	@Override
	public void init() throws ServletException {
		service = new BookService();
		System.out.println("init");
	}
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		//获取页面参数，并封装为book（1），或直接传参进行
		String id  = req.getParameter("id");
		String name = req.getParameter("name");
		String output = req.getParameter("output");
		String price = req.getParameter("price");
		//String writer = req.getParameter("writer");
		//String wid = req.getParameter("wid");
		
		//执行更新
		boolean flag = service.getUpdate(name,output,price,id);
		
		//判断更新
		if(flag) {
			resp.sendRedirect("/LibraryMS2/SearchAllBookServlet");
		}
		
		
	}

	
	
	
	@Override
	public void destroy() {
		System.out.println("destroy");
	}


}
