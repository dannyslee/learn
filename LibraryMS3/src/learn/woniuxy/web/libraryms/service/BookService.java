package learn.woniuxy.web.libraryms.service;

import java.sql.Connection;
import java.util.List;

import learn.woniuxy.web.libraryms.dao.BookDAO;
import learn.woniuxy.web.libraryms.dao.LibraryMSDAO;
import learn.woniuxy.web.libraryms.po.Book;
import learn.woniuxy.web.libraryms.util.JDBCUtil;

public class BookService implements LibraryService{
	
    private static final String DATABASE = "libraryms?characterEncoding=utf-8";
	
    @Override
	public Boolean getInsert(Object... args) {
		boolean flag = false;
		JDBCUtil util = new JDBCUtil();
		Connection con = util.getConnection(DATABASE);
		flag = new BookDAO().insert(con, args);
		return flag;
	}

	@Override
	public Boolean getDelete(int bid) {
		boolean flag = false;
		JDBCUtil util = new JDBCUtil();
		Connection con = util.getConnection(DATABASE);
		flag = new BookDAO().delete(con, bid);
		return flag;
	}

	@Override
	public Boolean getUpdate(Object... args) {
		boolean flag = false;
		JDBCUtil util = new JDBCUtil();
		Connection con = util.getConnection(DATABASE);
		flag = new BookDAO().update(con, args);
		return flag;
	}

	@Override
	public Book getSearchById(int bid) {
		Book book = null;
		JDBCUtil util = new JDBCUtil();
		Connection con = util.getConnection(DATABASE);
		book = new BookDAO().searchById(con, bid);
		return book;
	}

	@Override
	public List<Book> getSearchAll() {
		List<Book> books = null;
		JDBCUtil util = new JDBCUtil();
		Connection con = util.getConnection(DATABASE);
		books = new BookDAO().searchAll(con);
		return books;
	}

	

}