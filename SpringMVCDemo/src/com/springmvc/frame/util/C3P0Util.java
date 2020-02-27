package com.springmvc.frame.util;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0Util {
	//创建连接池对象
	private static ComboPooledDataSource pool = new ComboPooledDataSource("mysql");//MYSQL数据库
//	static {
//		//驱动类
//		try {
//			pool.setDriverClass("com.mysql.jdbc.Driver");
//		} catch (PropertyVetoException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		//url
//		pool.setJdbcUrl("jdbc:mysql://localhost:3306/student?characterEncoding=utf-8");
//		//账号user
//		pool.setUser("root");
//		//密码password
//		pool.setPassword("123456");
//		//初始化连接数，默认值为3
//		pool.setInitialPoolSize(4);
//		//最大连接数，默认值15
//		pool.setMaxPoolSize(6);
//		//最小连接数，默认值4
//		pool.setMinPoolSize(4);
//		//超时时间
//		pool.setCheckoutTimeout(60000);
//		//设置未被使用的连接存货时间，默认0s
//		pool.setMaxIdleTime(120);	
//	}
	
//	public static void main(String[] args) throws InterruptedException {
//		System.out.println("开始测试连接池是否正确使用");
//		//Connection con = getConnection();
//		
//		//查看当前连接池中闲置连接数
//		new Thread(new Runnable() {
//			
//			@Override
//			public void run() {
//				while(true) {
//					try {
//						Thread.sleep(200);
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//					//获取当前连接池闲置连接数
//					try {
//						System.out.println(pool.getNumIdleConnections());
//					} catch (SQLException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				}
//			}
//		}).start();
//		
//		Connection c1 = getConnection();
//		Thread.sleep(500);
//		Connection c2 = getConnection();
//		Thread.sleep(500);
//
//		Connection c3 = getConnection();
//		Thread.sleep(500);
//
//		Connection c4 = getConnection();
//		Thread.sleep(500);
//
//		Connection c5 = getConnection();
//		Thread.sleep(500);
//
//		Connection c6 = getConnection();
//		Thread.sleep(500);
//
//		close(c1);
//		Thread.sleep(500);
//		
//		close(c2);
//		Thread.sleep(500);
//		
//		close(c3);
//		Thread.sleep(500);
//		
//		close(c4);
//		Thread.sleep(500);
//		
//		close(c5);
//		Thread.sleep(500);
//		
//		close(c6);
//		Thread.sleep(500);
//		
//		
//	}
	
	
	/**
	 * 获取闲置连接对象
	 * @return
	 */
	public static Connection getConnection() {
		Connection con =null;
		
		try {
			con = pool.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
		
	}
	
	/**
	 * 将连接对象还回连接池
	 * @param con
	 */
	public static void close(Connection con) {
			try {
				if(con!=null)
				     con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	/**
	 * 关闭状态
	 * @param state
	 */	
	public static void close(Statement state) {
			try {
				if(state!=null)
				    state.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	/**
	 * 关闭状态与结果集
	 * @param state
	 * @param set
	 */
	public static void close(Statement state,ResultSet set) {
		
		try {
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
