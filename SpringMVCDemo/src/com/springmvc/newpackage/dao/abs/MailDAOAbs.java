package com.springmvc.newpackage.dao.abs;

import java.sql.Connection;

import com.springmvc.newpackage.dao.intface.DAOInsertInterface;
import com.springmvc.newpackage.dao.intface.DAOSelectInterface;
import com.springmvc.newpackage.po.MailPO;
import com.springmvc.newpackage.result.Result;
import com.springmvc.newpackage.role.sql.MailRole;
import com.springmvc.newpackage.sql.SQLMethod;

public abstract class MailDAOAbs implements DAOSelectInterface,DAOInsertInterface {

	@Override
	public Object insert(String roleName, Object... args) {
		return new SQLMethod().SQL(MailRole.valueOf(roleName), args);
	}

	@Override
	public Object select(String roleName, Object... args) {
		return new SQLMethod().SQL(MailRole.valueOf(roleName), args);
	}
	
	//生成订单时，添加
	public abstract Result insertMail(Connection con, MailPO mail);
	
	//通过uid查看
	public abstract Result searchMail(Connection con,int mu_id);
}
