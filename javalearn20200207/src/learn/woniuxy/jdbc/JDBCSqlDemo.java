package learn.woniuxy.jdbc;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
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
public class JDBCSqlDemo {
	
	//创建mysql连接通道
	public static void creatMysqlConnection(String url,String sql) {
		//1.加载驱动
				//数据库驱动类全名 包名+类名
				try {
					Class.forName("com.mysql.jdbc.Driver");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//2.获取数据库连接对象
				//数据库的URL
				//String url = "jdbc:mysql://localhost:3306/woniushop?user=root&password=123456";
				//Connection con
				Properties prop = null;
				FileInputStream fis = null;
				Connection con =null;
				PreparedStatement state = null;//更改原来的Statement state = null;
				ResultSet set = null;
				try {
					//jdbc:mysql://主机：端口号/数据库名称？user=账号&password=密码
					//A:con=DriverManager.getConnection(url,"root","123456")
					
					//B:文件流设置密码
					prop = new Properties();
					
					try {
						 fis = new FileInputStream(new File("jdbc.properties"));
						 
						 try {
							prop.load(fis);
						} catch (IOException e) {
							e.printStackTrace();
						}
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}
					con = DriverManager.getConnection(url,prop);
					
					//C:
					//con = DriverManager.getConnection(url);
					 
					//3.准备sql
					//sql = "SELECT * FROM goodstyle";
					//4.创建状态，提交并执行SQL
					state = con.prepareStatement(sql);//更改原来的 con.createStatement()，若有参数,后写类似以下state.setString(1,str)代码，原来的sql参数用？代替,前面的1，代表参数中的第一个？例如 select a from b where c = ？
					set = state.executeQuery();//更改原来的executeQuery(sql)
					//5.处理执行结果
					//next():判断是否存在下一行查询结果，如果存在，则返回true，将目标数据切到下一行；不存在，则返回fasle
					while(set.next()) {
						//循环一次，处理一行查询结果
						int gt_id = set.getInt("gt_id");
						String gt_name = set.getString("gt_name");
						String gt_img = set.getString("gt_img");
						String gt_description = set.getString("gt_description");
						System.out.println(gt_id+":"+gt_name+":"+gt_img+":"+gt_description+"!");
					}
					 
					 System.out.println(con);
				} catch (SQLException e) {
					e.printStackTrace();
				}finally {
					
					    try {
					    	if(fis!=null)
							    fis.close();
						} catch (IOException e3) {
							// TODO Auto-generated catch block
							e3.printStackTrace();
						}
					    
					    try {
					    	if(set!=null)
					    		set.close();
						} catch (SQLException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
					    
					    try {
					    	if(state!=null)
					    		state.close();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					
						try {
							if(con!=null)
								con.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				}
				
	}

	//执行sql
	public static void  executeSql(String sql) {
		
	}
	
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/woniushop?user=root&password=123456";
		String sql = "SELECT gt_id,gt_name,gt_img,gt_description FROM goodstype";
		creatMysqlConnection(url,sql);
	}
}
