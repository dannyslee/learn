package com.springmvc.newpackage.service;

import java.sql.Connection;

import com.springmvc.frame.util.C3P0Util;
import com.springmvc.newpackage.result.Result;
import com.springmvc.newpackage.service.abs.UserServiceAbs;
import com.springmvc.newpackage.service.intface.Service;
import com.springmvc.newpackage.service.intface.ServiceSelectInterface;


public class UserServiceImp extends UserServiceAbs implements Service,ServiceSelectInterface{



	@Override
	public Result getSearchRegiterUser(String user) {
		Connection con = C3P0Util.getConnection();
		Object select = getSelect("USERDAO_SELECT_REGITER_USER",con,user);
		C3P0Util.close(con);
		return (Result)select;
	}

	
	@Override
	public Result getInsertUser(String user, String password) {
		Connection con = C3P0Util.getConnection();
		Object insert = getInsert("USERDAO_INSERT_REGITER_USER_P", con,user,password);
		C3P0Util.close(con);

		return (Result)insert;
	}

	@Override
	public Result getSearchLoginUser(String user, String password) {
		Connection con = C3P0Util.getConnection();	
		Object select = getSelect("USERDAO_SELECT_lOGIN_USER_P",con,user,password);
		C3P0Util.close(con);
		return (Result)select;
	}


	

	

}
