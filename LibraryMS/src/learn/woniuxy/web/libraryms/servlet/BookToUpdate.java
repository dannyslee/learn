package learn.woniuxy.web.libraryms.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jdt.internal.compiler.ast.TryStatement;

import jdk.nashorn.internal.ir.TryNode;
import learn.woniuxy.web.libraryms.po.BookPO;
import learn.woniuxy.web.libraryms.service.BookService;

/**
 * Servlet implementation class BookToUpdate
 */
public class BookToUpdate extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//反馈
		String res = null;
		//编码
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		//获取id
		String book = req.getParameter("book");
		//System.out.println("b-Up-t:"+book);

		String id = req.getParameter("id");
		//System.out.println("b-Up-t:"+id);
		//检测
		if(book==null ) {
			res = "无法获取数据";
			return;
		}
	
		
		if(book.equals("update")) {
			int sid = 0;
			if(id==null) {
				res = "无法获取数据";
				return;
			}
			
			try {
				sid = Integer.parseInt(id);
			} catch (Exception e) {
				res="无法获取数据";
				return;
			}
			
			if(sid==0) {
				res="数据错误";
				return;
			}
			//获取数据
			List<BookPO> books = new BookService().showAllToUpdate(sid);
			//设置工作域
			req.setAttribute("books", books);
			//请求转发
			req.getRequestDispatcher("jsp/update.jsp").forward(req, resp);
		}else if(book.equals("insert")){
			List<BookPO> books = new BookService().showAll();
			//设置工作域
			req.setAttribute("books", books);
	
			//请求转发
			req.getRequestDispatcher("jsp/insert.jsp").forward(req, resp);
			
		}else if(book.equals("delete")) {
			int sid = 0;
			if(id==null) {
				res = "无法获取数据";
				return;
			}
			
			try {
				sid = Integer.parseInt(id);
			} catch (Exception e) {
				res="无法获取数据";
				return;
			}
			
			if(sid==0) {
				res="数据错误";
				return;
			}
			res = new BookService().showAllToDelete(sid);
			System.out.println(res);
			List<BookPO> books =  new BookService().showAll();	
			req.setAttribute("books", books);
			//请求转发
			req.getRequestDispatcher("jsp/index.jsp").forward(req, resp);
		}
	
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("des");
	}

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("init");
	}
	
	
	

}
