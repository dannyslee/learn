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
 * Servlet implementation class InsertShowBookServlet
 */
public class InsertShowBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private LibraryService service;
	
	@Override
	public void init() throws ServletException {
		//service = new BookService();
		System.out.println("init");
	}
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//请求转发
		req.getRequestDispatcher("jsp/insert.jsp").forward(req, resp);
		
	}

	
	
	
	@Override
	public void destroy() {
		System.out.println("destroy");
	}
   
   

}
