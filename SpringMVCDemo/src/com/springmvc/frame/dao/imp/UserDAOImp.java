package com.springmvc.frame.dao.imp;

import java.sql.Connection;

import com.springmvc.frame.dao.UserDAO;
import com.springmvc.frame.po.UserPO;
import com.springmvc.frame.util.ExecJDBC;

public class UserDAOImp implements UserDAO {

	@Override
	public UserPO searchLoginUser(Connection con, String user, String password) {
		//sql语句
		String sql = "select u_id,u_user,u_password,ur_id,u_soft from `user` where u_user= ? and u_password= ? and u_soft=0";
		return ExecJDBC.sql(sql, con, UserPO.class, user,password);
	}

	@Override
	public UserPO searchRegiterUser(Connection con, String user) {
		//sql
		String sql = "select u_id,u_user,u_password,ur_id,u_soft from `user` where u_user=? and u_soft=0";

		return ExecJDBC.sql(sql, con, UserPO.class, user);
	}

	@Override
	public boolean insertRegiterUser(Connection con, String user, String password) {
		//Sql:默认为普通用户
		String sql = "insert into `user`(u_user,u_password,ur_id) values(?,?,1)";
		return ExecJDBC.sql(con, sql, user,password);
	}

	
	
}
