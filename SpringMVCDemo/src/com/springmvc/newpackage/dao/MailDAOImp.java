package com.springmvc.newpackage.dao;

import java.sql.Connection;

import com.springmvc.newpackage.dao.abs.MailDAOAbs;
import com.springmvc.newpackage.dao.intface.DAO;
import com.springmvc.newpackage.po.MailPO;
import com.springmvc.newpackage.result.Result;

public class MailDAOImp extends MailDAOAbs implements DAO {

	@Override
	public Result insertMail(Connection con, MailPO mail) {
		return (Result)insert("MAIL_INSERT_MAILPO",con,mail);
	}

	@Override
	public Result searchMail(Connection con, int mu_id) {
		return (Result)insert("MAIL_SELECT_UID",con,mu_id);
	}
	
}
