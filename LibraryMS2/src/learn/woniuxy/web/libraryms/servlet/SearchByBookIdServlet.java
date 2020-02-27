package learn.woniuxy.web.libraryms.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import learn.woniuxy.web.libraryms.po.Book;
import learn.woniuxy.web.libraryms.service.BookService;
import learn.woniuxy.web.libraryms.service.LibraryService;

/**
 * Servlet implementation class SearchByBookIdServlet
 */
public class SearchByBookIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LibraryService service;
	
	@Override
	public void init() throws ServletException {
		service = new BookService();
		System.out.println("init");
	}
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取id键内容
		String id = req.getParameter("id");
				
		//通过获取到的id，执行相应的service
		Book book = service.getSearchById(Integer.parseInt(id));
		
		//请求作用域
		req.setAttribute("book", book);
		
		//请求转发
		req.getRequestDispatcher("jsp/update.jsp").forward(req, resp);
		
	}

	
	
	
	@Override
	public void destroy() {
		System.out.println("destroy");
	}

}
