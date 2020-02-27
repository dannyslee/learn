package learn.woniuxy.web.libraryms.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import learn.woniuxy.web.libraryms.service.BookService;
import learn.woniuxy.web.libraryms.service.LibraryService;

/**
 * Servlet implementation class DeleteBookServlet
 */
public class DeleteBookServlet extends HttpServlet {
	
	private LibraryService service;
	
	@Override
	public void init() throws ServletException {
		service = new BookService();
		System.out.println("init");
	}
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String id = req.getParameter("id");
		boolean flag = service.getDelete(Integer.parseInt(id));
		if(flag) {
			resp.sendRedirect("/LibraryMS2/SearchAllBookServlet");
		}
		
	}

	
	
	
	@Override
	public void destroy() {
		System.out.println("destroy");
	}

	
	

}
