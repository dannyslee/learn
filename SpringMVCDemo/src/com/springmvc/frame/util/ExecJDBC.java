package com.springmvc.frame.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * sql执行
 * 
 * @author Administrator
 *
 */

public class ExecJDBC {

	// 任意SQL语言执行
	public static boolean sql(Connection con,String sql, Object... args) {
		
		//如果改为C3P0的话，不需要实例化JDBCUtil对象，直接静态调用
		// 判断参数args是否等于给定长度
		//JDBCUtil util = new JDBCUtil();
		// 连接某库
		//Connection con = util.getConnection("student?characterEncoding=utf-8");// student_ims woniushop
		PreparedStatement state = null;
		ResultSet set = null;
		ResultSetMetaData data = null;
		try {
			state = con.prepareStatement(sql);
			// foreach获取占位符
			int i = 1;
			for (Object arg : args) {
				state.setObject(i, arg);
				System.out.println(i + ":" + arg);// arg.getClass().toString()
				i++;
			}
			// 执行操作
			boolean hasexec = state.execute();
			// 返回布尔值，判断是执行还是查询
			System.out.println(hasexec);
			if (hasexec) {
				// 处理查询字段
				set = state.getResultSet();// 获取数据集
				data = set.getMetaData();// 获取实际数据（重要）
				// 循环打印数值
				for (int a = 1; a <= data.getColumnCount(); a++) {
					// 获得指定列的列名和列值
					System.out.println(data.getColumnName(a) + ":" + data.getColumnType(a));
				}
				if (set.next()) {
					return true;
				}
				// 若返回值為false
			} else {
				// 执行
				int row = state.getUpdateCount();// 获取更新数量
				System.out.println(row);
				if (row > 0) {
					return true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			C3P0Util.close(set, state);
		}

		return false;
	}

	// con无参
	public static boolean sql(String sql, Connection con) {

		// 判断参数args是否等于给定长度
		//JDBCUtil util = new JDBCUtil();
		// 连接某库
		PreparedStatement state = null;
		ResultSet set = null;
		ResultSetMetaData data = null;
		try {
			state = con.prepareStatement(sql);
			// 执行操作
			boolean hasexec = state.execute();
			// 返回布尔值，判断是执行还是查询
			System.out.println(hasexec);
			if (hasexec) {
				// 处理查询字段
				set = state.getResultSet();// 获取数据集
				data = set.getMetaData();// 获取实际数据（重要）
				// 循环打印数值
				for (int a = 1; a <= data.getColumnCount(); a++) {
					// 获得指定列的列名和列值
					System.out.println(data.getColumnName(a) + ":" + data.getColumnType(a));
				}
				if (set.next()) {
					return true;
				}
				// 若返回值為false
			} else {
				// 执行
				int row = state.getUpdateCount();// 获取更新数量
				System.out.println(row);
				if (row > 0) {
					return true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			C3P0Util.close(set, state);
		}

		return false;
	}

	// con连接，有参
	public static boolean sql(String sql, Connection con, Object... args) {

		// 判断参数args是否等于给定长度
		//JDBCUtil util = new JDBCUtil();
		// 连接某库
		PreparedStatement state = null;
		ResultSet set = null;
		ResultSetMetaData data = null;
		try {
			state = con.prepareStatement(sql);
			// foreach获取占位符
			int i = 1;
			for (Object arg : args) {
				state.setObject(i, arg);
				System.out.println(i + ":" + arg);// arg.getClass().toString()
				i++;
			}
			// 执行操作
			boolean hasexec = state.execute();
			// 返回布尔值，判断是执行还是查询
			System.out.println(hasexec);
			if (hasexec) {
				// 处理查询字段
				set = state.getResultSet();// 获取数据集
				data = set.getMetaData();// 获取实际数据（重要）
				// 循环打印数值
				for (int a = 1; a <= data.getColumnCount(); a++) {
					// 获得指定列的列名和列值
					System.out.println(data.getColumnName(a) + ":" + data.getColumnType(a));
				}
				if (set.next()) {
					return true;
				}
				// 若返回值為false
			} else {
				// 执行
				int row = state.getUpdateCount();// 获取更新数量
				System.out.println(row);
				if (row > 0) {
					return true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			C3P0Util.close(set, state);
		}

		return false;
	}

	// 返回相关对象
	// public <T> T
	public static <T> List<T> sql(String sql, Connection con, Class<T> cl) {
		//Map<String, Object> values = new HashMap<>();
		List<T> books = new ArrayList<>();

		// 获取状态，并得到返回集
		PreparedStatement state = null;
		ResultSet set = null;
		// 获取目标类对象
		try {
			state = con.prepareStatement(sql);
			set = state.executeQuery();
			Field[] fields = cl.getDeclaredFields();
			while (set.next()) {
				T po = null;
				po = cl.newInstance();
				// 获取目标类对象属性名
				for (Field field : fields) {
					String name = field.getName();
					Object n = set.getObject(name);
					String methodName = "set" + name.substring(0, 1).toUpperCase() + name.substring(1);
					Class<?> type = field.getType();
					// 获取目标类方法
					Method setMethod = cl.getDeclaredMethod(methodName, type);
					setMethod.invoke(po, n);
				}
				books.add(po);

			}
		} catch (SecurityException | NoSuchMethodException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			C3P0Util.close(set, state);
		}

		return books;

	}
	
	//通过参数获取，获取list对象
	public static <T> List<T> sqlByObj(String sql, Connection con, Class<T> cl, Object... args) {
		
		List<T> list = new ArrayList<T>();
		// 获取Sql数组1(以空格分离)
		String[] checkSqlSpace = sql.split("\\s+");
		// 获取Sql数组2(当查询字段不止一个时，以,分离)
		String[] checkSqlComma = checkSqlSpace[1].split(",");
		// 诊断sql语句
		if (checkSqlComma == null) {//如果以逗号分离的数组为空，说明只有一个字段
			checkSqlComma[0] = checkSqlSpace[1];//让数组2的第一个值为这个单字段
		}
		T po = null;
		// 获取状态，并得到返回集
		PreparedStatement state = null;
		ResultSet set = null;
		// 获取目标类对象
		try {
			state = con.prepareStatement(sql);
			int i = 1;
			for (Object arg : args) {
				state.setObject(i, arg);
				System.out.println(i + ":" + arg);// arg.getClass().toString()
				i++;
			}
			set = state.executeQuery();
			Field[] fields = cl.getDeclaredFields();
			while (set.next()) {
				po = cl.newInstance();
				// 获取目标类对象属性名
				for (Field field : fields) {

					String name = field.getName();
					//遍历所有字段
					for (String sqlField : checkSqlComma) {
						if (sqlField.equals(name)) {//比较获取的字段与类属性是否为同一个，同一个时，执行属性值的赋予
							Object n = set.getObject(name);
							String methodName = "set" + name.substring(0, 1).toUpperCase() + name.substring(1);
							Class<?> type = field.getType();
							// 获取目标类方法
							Method setMethod = cl.getDeclaredMethod(methodName, type);
							setMethod.invoke(po, n);
						}
					}
				}
				list.add(po);

			}
		} catch (SecurityException | NoSuchMethodException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			C3P0Util.close(set, state);
		}

		return list;

	}
	
	//获取单一对象
	public static <T> T sql(String sql, Connection con, Class<T> cl, Object... args) {

		// 获取Sql数组1(以空格分离)
		String[] checkSqlSpace = sql.split("\\s+");
		// 获取Sql数组2(当查询字段不止一个时，以,分离)
		String[] checkSqlComma = checkSqlSpace[1].split(",");
		// 诊断sql语句
		if (checkSqlComma == null) {//如果以逗号分离的数组为空，说明只有一个字段
			checkSqlComma[0] = checkSqlSpace[1];//让数组2的第一个值为这个单字段
		}
		T po = null;
		// 获取状态，并得到返回集
		PreparedStatement state = null;
		ResultSet set = null;
		// 获取目标类对象
		try {
			state = con.prepareStatement(sql);
			int i = 1;
			for (Object arg : args) {
				state.setObject(i, arg);
				System.out.println(i + ":" + arg);// arg.getClass().toString()
				i++;
			}
			set = state.executeQuery();
			//如果传入的类型是long类型，就是接收count
			if(cl.isAssignableFrom(Long.class)) {
				if(set.next()) {
					return (T) new Long(set.getLong(1));
				}
			}
			po = cl.newInstance();
			Field[] fields = cl.getDeclaredFields();
			while (set.next()) {

				// 获取目标类对象属性名
				for (Field field : fields) {

					String name = field.getName();
					//遍历所有字段
					for (String sqlField : checkSqlComma) {
						if (sqlField.equals(name)) {//比较获取的字段与类属性是否为同一个，同一个时，执行属性值的赋予
							Object n = set.getObject(name);
							String methodName = "set" + name.substring(0, 1).toUpperCase() + name.substring(1);
							Class<?> type = field.getType();
							// 获取目标类方法
							Method setMethod = cl.getDeclaredMethod(methodName, type);
							setMethod.invoke(po, n);
						}
					}

				}

			}
		} catch (SecurityException | NoSuchMethodException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			C3P0Util.close(set, state);
		}

		return po;

	}
	

	
	/* 测试上面代码
	 * private static final String DATABASE = "libraryms?characterEncoding=utf-8";
	 * 
	 * public static void main(String[] args) { String sql =
	 * "select output from vi_books where id=? "; JDBCUtil util = new JDBCUtil();
	 * Connection con = util.getConnection(DATABASE); Book sql2 = sql(sql, con,
	 * Book.class,78); System.out.println(sql2.toString()); util.close(con); }
	 * 
	 */

}
