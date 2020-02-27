package learn.woniuxy.web.libraryms.util;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;




/**
 * sql执行
 * @author Administrator
 *
 */

public class ExecJDBC {
	
	//任意SQL语言执行
	public boolean sql(String sql,Object... args) {
		
		//判断参数args是否等于给定长度
		JDBCUtil util = new JDBCUtil();
		//连接某库
		Connection con = util.getConnection("student?characterEncoding=utf-8");//student_ims woniushop
		PreparedStatement state = null;
		ResultSet set = null;
		ResultSetMetaData data = null; 
		try {
			state = con.prepareStatement(sql);
			//foreach获取占位符
			int i=1;
			for(Object arg:args) {
					state.setObject(i, arg);
					System.out.println(i+":"+arg);//arg.getClass().toString()
					i++;
			}			
			//执行操作
			boolean hasexec = state.execute();
			//返回布尔值，判断是执行还是查询
			System.out.println(hasexec);
			if(hasexec) {
				//处理查询字段
				set = state.getResultSet();//获取数据集	
				data = set.getMetaData();//获取实际数据（重要）
				//循环打印数值
				for (int a = 1; a <= data.getColumnCount(); a++) {
					// 获得指定列的列名和列值
					System.out.println(data.getColumnName(a)+":"+data.getColumnType(a));
			     }
				if(set.next()) {
					return true;
				}			
			//若返回值為false
			}else {
				//执行
				int row = state.getUpdateCount();//获取更新数量
				System.out.println(row);
				if(row>0) {
					return true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			util.close(set, state, con);
		}
		
		return false;
	}
	
	//查询SQL语言执行：视图
	public List<Object> sql(Object sql, Object... args) {
		// 转为string类型
		String sql1 = (String) sql;
		// 设置返回值集合
		List<Object> list = new ArrayList<Object>();

		// 判断参数args是否等于给定长度
		JDBCUtil util = new JDBCUtil();
		// 连接某库
		Connection con = util.getConnection("student?characterEncoding=utf-8");// student_ims woniushop
		PreparedStatement state = null;
		ResultSet set = null;
		ResultSetMetaData data = null;
		try {
			state = con.prepareStatement(sql1);
			// foreach获取占位符
			// int i=1;
//			for(Object arg:args) {
//					state.setObject(i, arg);
//					System.out.println(i+":"+arg);//arg.getClass().toString()
//					i++;
//			}			
			// 执行操作
			set = state.executeQuery();
			// 返回布尔值，判断是执行还是查询
//			System.out.println(hasexec);
//			if(hasexec) {
			// 处理查询字段
			set = state.getResultSet();// 获取数据集
			// 判断是否有值
			if (!set.next()) {
				return null;
			}

			int i = 1;
			while (set.next()) {
				for (Object arg : args) {
					arg = set.getObject(i);
					list.add(arg);
					// System.out.println(i+":"+arg);//arg.getClass().toString()
					i++;
				}
			}
			// 循环取出每一个值
//				data = set.getMetaData();//获取实际数据（重要）
//				//循环打印数值
//				for (int a = 1; a <= data.getColumnCount(); a++) {
//					// 获得指定列的列名和列值
//					System.out.println(data.getColumnName(a)+":"+data.getColumnType(a));
//			
//			     }
//				if(set.next()) {
//					return null;
//				}			
			// 若返回值為false
//			}else {
//				//执行
//				int row = state.getUpdateCount();//获取更新数量
//				System.out.println(row);
//				if(row>0) {
//					return true;
//				}
//			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			util.close(set, state, con);
		}

		return list;
	}
	

	
	

}