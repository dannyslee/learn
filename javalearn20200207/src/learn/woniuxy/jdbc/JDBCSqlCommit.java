package learn.woniuxy.jdbc;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * 服务端
 * @author Administrator
 *
 */
public class JDBCSqlCommit {
	
	
	
	public static void main(String[] args) {
		//获取数据库链接对象
		JDBCUtil util = new JDBCUtil();
		Connection con = util.getConnection();
		
		
		//关闭自动提交
        try {
        	con.setAutoCommit(false);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
				
		//准备sql
		String sql1 = "update users set u_password= ? where u_account = ?";
		String sql2 = "update users set u_password= ? where u_account = ?";
		
		//创建状态
		PreparedStatement state1 = null; 
		PreparedStatement state2 = null; 
		
		//获取输出参数
		try {
			state1 = con.prepareStatement(sql1);
			state2 = con.prepareStatement(sql2);
			
			//設置參數
			state1.setString(1, "777666");
			state1.setString(2,"13912167612");
			
			state2.setString(1, "777888");
			state2.setString(2,"13992666891");
			
			//執行sql
			int row1 = state1.executeUpdate();
			int row2 = state2.executeUpdate();
			
			System.out.println(row1+" | "+row2);
			
			//判斷是否提交
			if(row1>0&&row2>0) {
				//提交
				con.commit();
			}else {
				//回滾
				con.rollback();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			try {
				state1.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			util.close(null, state2, con);

		}
		
	}
}
