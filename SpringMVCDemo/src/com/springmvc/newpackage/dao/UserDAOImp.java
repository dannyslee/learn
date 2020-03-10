package com.springmvc.newpackage.dao;

import java.sql.Connection;

import com.springmvc.newpackage.dao.abs.UserDAOAbs;
import com.springmvc.newpackage.dao.intface.DAO;
import com.springmvc.newpackage.result.Result;
import com.springmvc.newpackage.role.sql.UserRole;
import com.springmvc.newpackage.sql.SQLMethod;

public  class UserDAOImp extends UserDAOAbs implements DAO{
	
	
	@Override
	public Result searchLoginUser(Connection con, String user, String password) {					
		return (Result)select("USER_SELECT_USER_P",con,user,password);
	}
	
	

	@Override
	public Result searchRegiterUser(Connection con, String user) {
		return (Result)select("USER_SELECT_USER",con,user);
	}

	@Override
	public Result insertRegiterUser(Connection con, String user, String password) {
		
		return (Result)insert("USER_INSERT_USER_P",con,user,password);
	}



}
