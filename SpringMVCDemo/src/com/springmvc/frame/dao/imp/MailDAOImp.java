package com.springmvc.frame.dao.imp;

import java.sql.Connection;

import com.springmvc.frame.dao.MailDAO;
import com.springmvc.frame.po.MailPO;
import com.springmvc.frame.util.ExecJDBC;

public class MailDAOImp implements MailDAO {

	@Override
	public boolean insertMail(Connection con, MailPO mail) {
		String sql = "insert into mail(m_name,m_tel,m_address,mu_id) values(?,?,?,?)";
		return ExecJDBC.sql(sql, con, mail.getM_name(),mail.getM_tel(),mail.getM_address(),mail.getMu_id());
	}

}
