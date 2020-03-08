package com.springmvc.newpackage.dao.abs;

import java.sql.Connection;

import com.springmvc.newpackage.dao.intface.DAOSelectInterface;
import com.springmvc.newpackage.result.Result;
import com.springmvc.newpackage.role.sql.CommoTypeRole;
import com.springmvc.newpackage.sql.SQLMethod;

public abstract class CommoTypeDAOAbs implements DAOSelectInterface  {

	@Override
	public Object select(String roleName, Object... args) {
		return new SQLMethod().SQL(CommoTypeRole.valueOf(roleName), args);
	}
	
	
	public abstract Result searchAllTypeOfCommo(Connection con);
	
}
