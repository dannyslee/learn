package learn.woniuxy.web.libraryms.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import learn.woniuxy.web.libraryms.po.BookPO;
import learn.woniuxy.web.libraryms.service.BookService;

/**
 * Servlet implementation class BookServlet
 */
public class BookServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//设置编码
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		//设置错误提醒
		String res = "失败！";
		
		//获取页面参数
		String book = req.getParameter("book");
		System.out.println("b-t:"+book);
		
		//获取数据库内容
//				List<BookPO> books =  new BookService().showAll();
//				
//				req.setAttribute("books", books);
//				
//				req.getRequestDispatcher("jsp/index.jsp");
		
		//判断非空
		if(book==null) {
			//默认show值
			 book = "show";
		}
		
		
		//判断操作
		if(book.equals("update")) {
			res = update(req,resp);
            List<BookPO> books =  new BookService().showAll();
			
			req.setAttribute("books", books);
			
			req.getRequestDispatcher("jsp/index.jsp").forward(req, resp);;
		}else if(book.equals("insert")) {
			res = insert(req,resp);
			List<BookPO> books =  new BookService().showAll();
			req.setAttribute("books", books);
			req.getRequestDispatcher("jsp/index.jsp").forward(req, resp);
				
		}else if(book.equals("delete")) {
			//res = delete(req,resp);
			
		}else if(book.equals("search")) {
			//res = search(req,resp);

		}else if(book.equals("show")) {
			
			List<BookPO> books =  new BookService().showAll();
			
			req.setAttribute("books", books);
			
			req.getRequestDispatcher("jsp/index.jsp").forward(req, resp);;
		}
		

		
		
	}

	private String show(HttpServletRequest req, HttpServletResponse resp) {
	
				
		//获取数据库内容
		List<BookPO> books =  new BookService().showAll();
		
		req.setAttribute("books", books);
		
		//req.getRequestDispatcher("jsp/index.jsp").forward(req, resp);;
		
		return null;
	}

	private String search(HttpServletRequest req, HttpServletResponse resp) {
		String res = "查询失败";
		
		
		return res;
	}

	private String delete(HttpServletRequest req, HttpServletResponse resp) {
		String res = "删除失败";
		
		return res;
	}

	private String insert(HttpServletRequest req, HttpServletResponse resp) {
		String res = "添加失败";
		// 更新前获取数据
		String name = req.getParameter("name");
		String output = req.getParameter("output");
		String price = req.getParameter("price");
		//String writer = req.getParameter("writer");
		String wid = req.getParameter("wid");
		// 检查
		double b_price = 0;
		int w_id = 0;
		try {
			b_price = Double.parseDouble(price);
			w_id = Integer.parseInt(wid);

		} catch (Exception e) {
			res = "不合法";
		}
				
		res= new BookService().insert(name,output,b_price,w_id);

			
		return res;
	}

	private String update(HttpServletRequest req, HttpServletResponse resp) {
		String res = "更新失败";

		// 更新前获取数据
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String output = req.getParameter("output");
		String price = req.getParameter("price");
		String writer = req.getParameter("writer");
		String wid = req.getParameter("wid");
		
		// 检查
		int b_id = 0;
		double b_price = 0;
		int w_id = 0;
		try {
			b_id = Integer.parseInt(id);
			b_price = Double.parseDouble(price);
			w_id = Integer.parseInt(wid);

		} catch (Exception e) {
			res = "不合法";
		}
		
		res= new BookService().update(b_id,b_price,w_id,name,output);

		return res;
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("destroy");
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("init");
	}

	
	

}
