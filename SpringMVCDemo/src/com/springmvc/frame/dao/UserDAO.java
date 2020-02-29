package com.springmvc.frame.dao;

import java.sql.Connection;

import com.springmvc.frame.po.UserPO;

public interface UserDAO {
	
	//查询
	//登录,是否存在该用户,若存在，返回相关结果
	UserPO searchLoginUser(Connection con,String user,String password);
	
	//注册查询，通过注册账号(不需要考虑密码问题)，判断是否存在该用户，有则返回相关结果
	UserPO searchRegiterUser(Connection con,String user);
	
	//插入
	//注册，新用户实现注册
	boolean insertRegiterUser(Connection con,String user,String password);
	
	
}
