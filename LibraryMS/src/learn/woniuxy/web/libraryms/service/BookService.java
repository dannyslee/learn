package learn.woniuxy.web.libraryms.service;

import java.sql.Connection;
import java.util.List;

import learn.woniuxy.web.libraryms.dao.BookDAO;
import learn.woniuxy.web.libraryms.po.BookPO;
import learn.woniuxy.web.libraryms.util.JDBCUtil;

public class BookService {

	public List<BookPO> showAll() {
		//设置book集合
		List<BookPO> books = null;
		JDBCUtil util = new JDBCUtil();
		Connection con = util.getConnection("libraryms");
		books = new BookDAO().findAll(con);
		util.close(con);
		return books;
	}
	
	public List<BookPO> showAllToUpdate(int id){
		List<BookPO> books = null;
		JDBCUtil util = new JDBCUtil();
		Connection con = util.getConnection("libraryms");
		books =  new BookDAO().findAllToUpdate(con, id);
		System.out.println("b-u-S:"+books);
		util.close(con);
		return books;
	}

	public String update(int b_id, double b_price, int w_id, String name, String output) {
		String res = "更新失败";
		JDBCUtil util = new JDBCUtil();
		Connection con = util.getConnection("libraryms?characterEncoding=utf-8");
		res = new BookDAO().findAllUpdate(con,b_id,b_price,w_id,name,output);
		return res;
	}

	public String insert(String name, String output, double b_price, int w_id) {
		String res = "新增失败";
		JDBCUtil util = new JDBCUtil();
		Connection con = util.getConnection("libraryms?characterEncoding=utf-8");
		res = new BookDAO().findAllInsert(con,name,output,b_price,w_id);
		
		return res;
	}

	public String showAllToDelete(int sid) {
		String res ="删除失败";
		JDBCUtil util = new JDBCUtil();
		Connection con = util.getConnection("libraryms?characterEncoding=utf-8");
		res = new BookDAO().findAllDelete(con,sid);
		
		return res;
	}

}