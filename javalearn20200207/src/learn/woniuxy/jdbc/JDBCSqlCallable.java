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
public class JDBCSqlCallable {
	
	
	
	public static void main(String[] args) {
		//获取数据库链接对象
		JDBCUtil util = new JDBCUtil();
		Connection con = util.getConnection();
		
		//准备sql
		String sql = "{CALL proc_show(?,?)}";
		
		//创建状态
		CallableStatement state = null; //存储过程
		
		
		//获取输出参数
		String acc;
		try {
			state = con.prepareCall(sql);//存储过程的
			//设置参数
			
			//输入参数
			state.setString(1, "13912167612");
			
			//输出参数
			state.registerOutParameter(2, java.sql.Types.CHAR);
			
			//执行sql
			state.execute();
			
			//获取输出值
			acc = state.getString(2);//指的是第二个问号
			System.out.println(acc);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(state!=null)
				    state.close();
				util.close(null, null, con);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
