package learn.woniuxy.web.libraryms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import learn.woniuxy.web.libraryms.po.Book;
import learn.woniuxy.web.libraryms.util.ExecJDBC;
import learn.woniuxy.web.libraryms.util.JDBCUtil;

public class BookDAO implements LibraryMSDAO {

	@Override
	public boolean insert(Connection con, Object... args) {
		String sql = "insert into  book(b_name,b_output,b_price,b_createdate,b_writer_id) values(?,?,?,?,?)";
		Boolean flag = new ExecJDBC().sql(sql, con, args);
		if(flag) {
			return true;
		} 
		return false;
	}

	@Override
	public boolean delete(Connection con, int bid) {
		String sql = "delete from book where b_id=? ";
		Boolean flag = new ExecJDBC().sql(sql, con, bid);
		if(flag) {
			return true;
		}
		return false;
	}

	@Override
	public boolean update(Connection con, Object... args) {
		  String sql = "update book set b_name=?,b_output=?,b_price=? where b_id=? ";
		    Boolean flag = new ExecJDBC().sql(sql, con,args);
			if(flag) {
				return true;
			}		
			return false;
	}
	
	@Override
	
	public List<Book> searchAll(Connection con) {
		List<Book> books = null;
		String sql = "select id,name,output,price,writer,wid,createdate from vi_books order by id desc";
		books = new ExecJDBC().sql(sql, con,Book.class);
		return books;	
	}
	
	
	
//	public List<Book> searchAll(Connection con) {
//		//准备sql
//		String sql = "select id,name,output,price,writer,wid,createdate from vi_books order by id desc";
//		//List集合存储数据
//		List<Book> books = new ArrayList<>();
//		//获取状态，并得到返回集
//		PreparedStatement state = null;
//		ResultSet set = null;
//		try {
//			state = con.prepareStatement(sql);
//			set = state.executeQuery();
//			while(set.next()) {
//				int id = set.getInt("id");
//				String name = set.getString("name");
//				System.out.println("B-D"+name);
//				String output = set.getString("output");
//			    double price = set.getDouble("price");
//				String writer = set.getString("writer");
//				int wid = set.getInt("wid");
//				Timestamp createdate = set.getTimestamp("createdate");
//				books.add(new Book(id, name, output, price, writer,wid,createdate));
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally {
//			new JDBCUtil().close(set, state, null);
//		}
//		
//		return books;
//		
//	}


	@Override
	public Book searchById(Connection con, int bid) {
		Book book = null;
		String sql = "select id,name,output,price,writer,wid,createdate from vi_books where id=? ";
		book = new ExecJDBC().sql(sql, con,Book.class,bid);
		return book;			
	}
	
//	public Book searchById(Connection con, int bid) {
//		// sql
//				String sql = "select id,name,output,price,writer,wid,createdate from vi_books where id=? ";
//				// 获取状态，并得到返回集
//				PreparedStatement state = null;
//			    Book book = null;
//				ResultSet set = null;
//				try {
//					state = con.prepareStatement(sql);
//					state.setInt(1, bid);
//					set = state.executeQuery();
//					while (set.next()) {
//						int sid = set.getInt("id");
//						int wid = set.getInt("wid");
//						String name = set.getString("name");
//						System.out.println("F-t-U-D:" + name);
//						String output = set.getString("output");
//						double price = set.getDouble("price");
//						String writer = set.getString("writer");
//						Timestamp createdate = set.getTimestamp("createdate");
//						book = new Book(sid, name, output, price, writer,wid,createdate);
//					}
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				} finally {
//					new JDBCUtil().close(set, state, null);
//				}
//
//				return book;
//
//	}

}
