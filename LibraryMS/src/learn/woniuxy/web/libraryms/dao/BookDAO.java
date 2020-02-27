package learn.woniuxy.web.libraryms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import learn.woniuxy.web.libraryms.po.BookPO;
import learn.woniuxy.web.libraryms.util.JDBCUtil;

public class BookDAO {
	public List<BookPO> findAll(Connection con) {
		
		//准备sql
		String sql = "select b_id id ,b_name name,b_output output,b_price price,w_name writer,b_writer_id wid,b_createdate createdate from writer join book on writer.w_id = book.b_writer_id order by id desc";
		//List集合存储数据
		List<BookPO> books = new ArrayList<>();
		//获取状态，并得到返回集
		PreparedStatement state = null;
		ResultSet set = null;
		try {
			state = con.prepareStatement(sql);
			set = state.executeQuery();
			while(set.next()) {
				int id = set.getInt("id");
				String name = set.getString("name");
				System.out.println("B-D"+name);
				String output = set.getString("output");
			    double price = set.getDouble("price");
				String writer = set.getString("writer");
				Timestamp createdate = set.getTimestamp("createdate");
				books.add(new BookPO(id, name, output, price, writer,createdate));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			new JDBCUtil().close(set, state, null);
		}
		
		return books;
	}
	
	public List<BookPO> findAllToUpdate(Connection con,int id) {
		// 容器
		List<BookPO> books = new ArrayList<>();
		// sql
		String sql = "select id,name,output,price,writer,wid,createdate from vi_books where id=? ";
		// 获取状态，并得到返回集
		PreparedStatement state = null;
	
		ResultSet set = null;
		try {
			state = con.prepareStatement(sql);
			state.setInt(1, id);
			set = state.executeQuery();
			while (set.next()) {
				int sid = set.getInt("id");
				int wid = set.getInt("wid");
				String name = set.getString("name");
				System.out.println("F-t-U-D:" + name);
				String output = set.getString("output");
				double price = set.getDouble("price");
				String writer = set.getString("writer");
				Timestamp createdate = set.getTimestamp("createdate");
				books.add(new BookPO(sid, name, output, price, writer,wid,createdate));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			new JDBCUtil().close(set, state, null);
		}

		return books;
		
	}

	public String findAllUpdate(Connection con,int b_id, double b_price, int w_id, String name, String output) {
		String res = "更新失败";
		String sql = "update book set b_name=?,b_output=?,b_price=? where b_writer_id=? ";
		PreparedStatement state = null;
		try {
			state = con.prepareStatement(sql);
			state.setString(1,name);
			state.setString(2, output);
			state.setDouble(3, b_price);
			state.setInt(4, w_id);
			int row = state.executeUpdate();
			if(row>0) {
				res="更新成功";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			new JDBCUtil().close(null, state, null);
		}
		return res;
	}

	public String findAllInsert(Connection con, String name, String output, double b_price, int w_id) {
		String res= "插入失败！";
		//处理时间
		Date date = new Date();
		Timestamp createdate =  dateToSqlDate(date);
		String sql = "insert into  book(b_name,b_output,b_price,b_createdate,b_writer_id) values(?,?,?,?,?)";
		PreparedStatement state = null;
		try {
			state = con.prepareStatement(sql);
			state.setString(1,name);
			state.setString(2, output);
			state.setDouble(3, b_price);
			state.setTimestamp(4, createdate);
			state.setInt(5, w_id);
			int row = state.executeUpdate();
			if(row>0) {
				res="更新成功";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			new JDBCUtil().close(null, state, null);
		}
		
		return res;
	}
	
	
	

	public String findAllDelete(Connection con, int sid) {
		String res = "删除失败";
		String sql = "delete from book where b_id=? ";
		PreparedStatement state = null;
		try {
			state = con.prepareStatement(sql);
			state.setInt(1, sid);
			int row = state.executeUpdate();
			System.out.println(res);

			if(row>0) {
				res="删除成功";
				System.out.println(res);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			new JDBCUtil().close(null, state, null);
		}
		
		return res;
	}
	
	
	//时间处理
		public static Timestamp dateToSqlDate(Date date) {
			String strDate = dateToStr(date,"yyyy-MM-dd HH:mm:ss");
			return strToSqlDate(strDate,"yyyy-MM-dd HH:mm:ss");		
		}

		private static Timestamp strToSqlDate(String strDate, String string) {
			DateFormat df = new SimpleDateFormat(string);		
	        Date date = null;
	        try {
				date = df.parse(strDate);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return new Timestamp(date.getTime());
		}

		private static String dateToStr(Date date, String string) {
			DateFormat df = new SimpleDateFormat(string);		
			return df.format(date);
		}
}
