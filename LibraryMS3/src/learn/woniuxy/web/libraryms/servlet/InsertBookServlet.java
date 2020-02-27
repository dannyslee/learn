package learn.woniuxy.web.libraryms.servlet;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import learn.woniuxy.web.libraryms.service.BookService;
import learn.woniuxy.web.libraryms.service.LibraryService;
import learn.woniuxy.web.libraryms.util.CheckUtil;

/**
 * Servlet implementation class InsertBookServlet
 */
public class InsertBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LibraryService service;
	
	@Override
	public void init() throws ServletException {
		service = new BookService();
		System.out.println("init");
	}
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 设置编码
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		// 获取页面参数，并封装为book，或直接传参进行
		String name = req.getParameter("name");
		String output = req.getParameter("output");
		String price = req.getParameter("price");
		String wid = req.getParameter("wid");
		//获取当前插入时间
		Date date = new Date();
		Timestamp createdate = CheckUtil.dateToSqlDate(date);
		//执行插入
		boolean flag = service.getInsert(name,output,price,createdate,wid);
		System.out.println(flag);
		//返回到界面
		if(flag) {
			resp.sendRedirect("/LibraryMS2/SearchAllBookServlet");
		}

	}

	
	
	
	@Override
	public void destroy() {
		System.out.println("destroy");
	}


}
