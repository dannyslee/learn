package com.springmvc.newpackage.dao.abs;

import java.sql.Connection;

import com.springmvc.newpackage.dao.intface.DAOInsertInterface;
import com.springmvc.newpackage.dao.intface.DAOSelectInterface;
import com.springmvc.newpackage.result.Result;
import com.springmvc.newpackage.role.sql.UserRole;
import com.springmvc.newpackage.sql.SQLMethod;

public abstract class UserDAOAbs implements DAOSelectInterface,DAOInsertInterface{
	
	@Override
	public Object select(String roleName, Object... args) {	
		return new SQLMethod().SQL(UserRole.valueOf(roleName), args);
	}

	
	 @Override
	public Object insert(String roleName, Object... args) {	
		return new SQLMethod().SQL(UserRole.valueOf(roleName), args);
	}




	//查询
	//登录,是否存在该用户,若存在，返回相关结果
	public abstract Result searchLoginUser(Connection con,String user,String password);
	
	//注册查询，通过注册账号(不需要考虑密码问题)，判断是否存在该用户，有则返回相关结果
	public abstract Result searchRegiterUser(Connection con,String user);
	
	//插入
	//注册，新用户实现注册
	public abstract Result insertRegiterUser(Connection con,String user,String password);
}
