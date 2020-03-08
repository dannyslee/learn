package com.springmvc.newpackage.service;

import java.sql.Connection;

import com.springmvc.frame.util.C3P0Util;
import com.springmvc.newpackage.po.MailPO;
import com.springmvc.newpackage.result.Result;
import com.springmvc.newpackage.service.abs.MailServiceAbs;
import com.springmvc.newpackage.service.intface.Service;

public class MailServiceImp extends MailServiceAbs implements Service {

	@Override
	public Result getInsertMail(MailPO mail) {
		Connection con = C3P0Util.getConnection();
		return 	(Result)getInsert("MAILDAO_INSERT_MAILPO", con,mail);

	}

	@Override
	public Result getSearchMail(int mu_id) {
		Connection con = C3P0Util.getConnection();
		return (Result)getInsert("MAILDAO_SELECT_UID", con,mu_id);
	}

}
