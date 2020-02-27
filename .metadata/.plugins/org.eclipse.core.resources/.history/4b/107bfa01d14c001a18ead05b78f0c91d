package learn.woniuxy.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtil {
	private static final String URL ="jdbc:mysql://localhost:3306/woniushop";
	private static final String USER ="root";
	private static final String PASSWORD ="123456";

	static {
		//加载驱动类
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	//链接创建
	public Connection getConnection(){
		Connection con=null;
		try {
			con=DriverManager.getConnection(URL,USER,PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	//关闭流 Connection con
	public void close(Connection con){
		try {
			if(con!=null)
				con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//关闭流 ResultSet set,PreparedStatement state,Connection con
	public void close(ResultSet set,PreparedStatement state,Connection con){
		try {
			if(set!=null)
				set.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(state!=null)
				state.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(con!=null)
				con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//关闭CallableStatement
	public void close(ResultSet set,CallableStatement callablestatement,Connection con){
		try {
			if(set!=null)
				set.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(callablestatement!=null)
				callablestatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(con!=null)
				con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
