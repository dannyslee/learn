package learn.woniuxy.jdbc;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

/**
 * 服务端
 * @author Administrator
 *
 */
public class JDBCCURDDemo {
	
	//创建数据库连接
	public static Statement createMysqlConnection(String url) {
		// 1.加载驱动器
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//获取数据库连接对象
		Connection con = null;
		Statement state = null;
		try {
			con = DriverManager.getConnection(url);
			//3.准备sql语言
			
			//4.创建对象
			state = con.createStatement();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return state;
	}
	
	//执行sql增删改语句
	public static void disposeMysql(Statement state,String sql) {
		 try {
			int row = state.executeUpdate(sql);
			if(row>0) {
				System.out.println("更新成功");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(state!=null)
					state.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		 
	}
	
	//使用execute增删改查
	public static void executeMysql(Statement state,String sql) {
		ResultSet set = null;
		try {
			boolean haveexecute = state.execute(sql);
			System.out.println(haveexecute);
			if(haveexecute) {//查询
				//获取结果集
				set = state.getResultSet();
				while(set.next()) {
					System.out.println(set.getInt(1)+set.getString(2)+set.getString(3)+set.getString(4));
				}
			}else {//操作
				int row = state.getUpdateCount();
				System.out.println(row);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(set!=null)
				   set.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if(state!=null)
				   state.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	//实现根据账号修改密码
	public static void changePassword(Statement state,String account,String password) {
		
		//对比账号密码是否有问题
		String sql = "select u_account,u_password from users where u_account='"+account+"'and u_password='"+password+"'";
		
		ResultSet set = null;
		
		try {
			boolean haveexecute = state.execute(sql);
			//System.out.println(haveexecute);
			if(haveexecute) {//查询
				//判断
				set = state.getResultSet();
				if(!(set.next())) {
					System.out.println("账户或密码有误");
				}else {
					//获取结果集
					Scanner sc = new Scanner(System.in);
					System.out.println("请输入新密码：");
					String new_pass = sc.next();
					String sql2 = "update users set u_password='"+new_pass+"'where u_account = '"+account+"'";
					int row = state.executeUpdate(sql2);
					if(row>0) {
						System.out.println("更改成功");
					}
				}
				
			}else {
				System.out.println("错误操作");
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(set!=null)
				   set.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if(state!=null)
				   state.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
	
	
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/woniushop?user=root&password=123456";
		String sqlI = "insert into users(u_account,u_password) values(1391297612,123456)";
		String sqlQ = "SELECT gt_id,gt_name,gt_img,gt_description FROM goodstype";
		
		Statement state = createMysqlConnection(url);
	
		//executeMysql(state, sqlQ);
		//executeMysql(state, sqlI);
		//disposeMysql(state,sql);
		
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入账号：");
		String account = sc.next();
		System.out.println("请输入密码：");
		String password = sc.next();
		
		
		changePassword(state,account,password);
	}
}
