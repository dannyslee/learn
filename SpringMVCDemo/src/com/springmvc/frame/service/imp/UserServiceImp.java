package com.springmvc.frame.service.imp;

import java.sql.Connection;

import com.springmvc.frame.dao.UserDAO;
import com.springmvc.frame.dao.imp.UserDAOImp;
import com.springmvc.frame.po.UserPO;
import com.springmvc.frame.service.UserService;
import com.springmvc.frame.util.C3P0Util;

public class UserServiceImp implements UserService {

	@Override
	public UserPO getSearchLoginUser(String user, String password) {
		UserPO searchLoginUser=null;
		//创建目标访问对象
		UserDAO userDAO = new UserDAOImp();
		//获取数据库连接
		Connection con = C3P0Util.getConnection();
		//查询所有类型
		searchLoginUser = userDAO.searchLoginUser(con, user, password);
		//关闭连接
		C3P0Util.close(con);
		return searchLoginUser;
	}

	@Override
	public UserPO getSearchRegiterUser(String user) {
		UserPO searchLoginUser = null;
		// 创建目标访问对象
		UserDAO userDAO = new UserDAOImp();
		// 获取数据库连接
		Connection con = C3P0Util.getConnection();
		// 查询所有类型
		searchLoginUser = userDAO.searchRegiterUser(con, user);
		// 关闭连接
		C3P0Util.close(con);
		return searchLoginUser;
	}

	@Override
	public boolean getInsertUser(String user, String password) {
		// 创建目标访问对象
		UserDAO userDAO = new UserDAOImp();
		// 获取数据库连接
		Connection con = C3P0Util.getConnection();
		// 查询所有类型
		boolean insertRegiterUser = userDAO.insertRegiterUser(con, user,password);
		// 关闭连接
		C3P0Util.close(con);
		return insertRegiterUser;
	}

	


}
