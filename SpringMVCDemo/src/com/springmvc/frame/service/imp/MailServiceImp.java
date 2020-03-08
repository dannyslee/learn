package com.springmvc.frame.service.imp;

import java.sql.Connection;

import com.springmvc.frame.dao.imp.MailDAOImp;
import com.springmvc.frame.po.MailPO;
import com.springmvc.frame.service.MailService;
import com.springmvc.frame.util.C3P0Util;

public class MailServiceImp implements MailService {

	@Override
	public boolean getInsertMail(MailPO mail) {
		Connection con = C3P0Util.getConnection();
		boolean insertMail = new MailDAOImp().insertMail(con, mail);
		C3P0Util.close(con);
		return insertMail;
	}

}
