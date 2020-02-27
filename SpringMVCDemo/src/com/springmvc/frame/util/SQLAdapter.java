package com.springmvc.frame.util;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SQLAdapter {
	public static void main(String[] args) throws Exception {
		//		Connection con=JDBCUtil.getConnection();
		//		String sql="DELETE FROM student WHERE id=?";
		//		Object[] param={10};
		//		boolean re=update(con, sql, param);
		//		JDBCUtil.close(con, null, null);
		//		System.out.println(re);

		//查询单行
		//		Connection con=JDBCUtil.getConnection();
		//		String sql="SELECT sid,sname,sex,age,tel,class_id,cname FROM vi_allStudents WHERE sid=?";
		//		Object[] param={1};
		//		Vi_allStudentsPO stu=queryOneRow(con, sql, param, Vi_allStudentsPO.class);
		//		JDBCUtil.close(con, null, null);
		//		System.out.println(stu);

		//查询多行
//		Connection con=JDBCUtil.getConnection();
//		String sql="SELECT sid,sname,sex,age,tel,class_id,cname FROM vi_allStudents";
//		List<Vi_allStudentsPO> stus=query(con, sql,null, Vi_allStudentsPO.class);
//		JDBCUtil.close(con, null, null);
//		System.out.println(stus);
		//查询单行单列
//		Connection con=JDBCUtil.getConnection();
//		String sql="SELECT sex FROM vi_allStudents WHERE sid=?";
//		Object[] params={8};
//		String sname=queryOneRowOneColumn(con, sql, params, String.class);
//		JDBCUtil.close(con, null, null);
//		System.out.println(sname);
	}
	public String findPassByAccount(Connection con,String account){
		String sql="SELECT pass FROM `user` WHERE account=?";
		Object[] params={account};
		return queryOneRowOneColumn(con, sql, params, String.class);
	}
	public boolean insert(Connection con,String account,String pass){
		String sql="INSERT INTO `user`(account,pass) VALUES(?,?)";
		Object[] params={account,pass};
		return update(con, sql, params);
	}
	
	public static <T> T queryOneRowOneColumn(Connection con,String sql,Object[] params,Class<T> cl){
		T result=null;
		//检查数据有效性
		if(con==null||sql==null||cl==null){
			return result;
		}
		//创建状态
		PreparedStatement state=null;
		ResultSet set=null;
		try {
			state=con.prepareStatement(sql);
			//设置参数
			if(params!=null){
				for (int i = 0; i < params.length; i++) {
					state.setObject(i+1, params[i]);
				}
			}
			//执行SQL
			set=state.executeQuery();
			//处理查询结果
			if(set.next()){
				result=(T) set.getObject(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			C3P0Util.close(state, set);
		}
		return result;
	}
	
	public static <T> List<T> query(Connection con,String sql,Object[] params,Class<T> cl){
		List<T> list=new ArrayList<T>();
		//检查参数有效性
		if(con==null || sql==null || cl==null){
			return list;
		}
		PreparedStatement state=null;
		ResultSet set=null;
		try {
			state=con.prepareStatement(sql);
			//设置参数
			if(params!=null){
				for (int i = 0; i < params.length; i++) {
					state.setObject(i+1, params[i]);
				}
			}
			//执行SQL
			set=state.executeQuery();
			//处理查询结果
			while(set.next()){
				//创建目标类对象，用于存储查询单行结果
				try {
					T po=cl.newInstance();
					//获取目标类所有属性
					Field[] fields=cl.getDeclaredFields();
					for (Field field : fields) {
						//获取属性名称
						String fieldName=field.getName();
						//根据属性名称尝试从结果集中查询结果
						Object obj=null;
						try {
							obj=set.getObject(fieldName);
						} catch (Exception e) {
							continue;
						}
						if(obj==null){
							continue;
						}
						//获取属性类型
						Class fieldTypeCl=field.getType();
						//判断查询结果是否属于该属性类型
						if(!fieldTypeCl.isInstance(obj)){
							continue;
						}
						//获取set方法名称
						String setMethodName="set"+fieldName.substring(0,1).toUpperCase()+fieldName.substring(1);
						//获取目标set方法
						Method setMethod=cl.getDeclaredMethod(setMethodName, fieldTypeCl);
						//执行set方法
						setMethod.invoke(po, obj);
					}
					list.add(po);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			//资源释放
			C3P0Util.close(state, set);
		}
		return list;
	}

	public static <T> T queryOneRow(Connection con,String sql,Object[] params,Class<T> cl) throws Exception{
		T po=null;
		//检查参数合法性
		if(con==null || sql==null || cl==null){
			return po;
		}
		PreparedStatement state=null;
		ResultSet set=null;
		try {
			state=con.prepareStatement(sql);
			//设置参数
			if(params!=null){
				for (int i = 0; i < params.length; i++) {
					state.setObject(i+1, params[i]);
				}
			}
			//执行SQL
			set=state.executeQuery();
			//处理结果集
			if(set.next()){
				//创建目标类对象
				po=cl.newInstance();
				//获取本类属性
				Field[] fields=cl.getDeclaredFields();
				for (Field field : fields) {
					//获取属性名称
					String fieldName=field.getName();
					try {
						//尝试利用属性名从结果集中获取列值
						Object obj=null;
						try {
							obj=set.getObject(fieldName);
						} catch (Exception e) {
							continue;
						}
						if(obj==null){
							continue;
						}
						//获取属性类型
						Class fieldTypeCl=field.getType();
						//判断查询结果是否为当前属性类型值
						if(!fieldTypeCl.isInstance(obj)){
							continue;
						}
						//获取set方法名称
						String setMethodName="set"+fieldName.substring(0,1).toUpperCase()+fieldName.substring(1);
						//获取set方法Method对象
						Method setMethod=cl.getDeclaredMethod(setMethodName, fieldTypeCl);
						//执行set方法将查询结果列值赋给对应变量
						setMethod.invoke(po, obj);
					} catch (Exception e) {
						continue;
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			C3P0Util.close(state, set);
		}
		return po;
	}
	public static boolean update(Connection con,String sql,Object[] params){
		boolean re=false;
		//检查参数合法
		if(con==null || sql==null){
			return re;
		}
		PreparedStatement state=null;
		try {
			//创建状态
			state=con.prepareStatement(sql);
			//设置参数
			if(params!=null){
				for (int i = 0; i < params.length; i++) {
					state.setObject(i+1, params[i]);
				}
			}
			//执行SQL
			int row=state.executeUpdate();
			if(row>0){
				re=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			C3P0Util.close(state);
		}
		return re;
	}
}
