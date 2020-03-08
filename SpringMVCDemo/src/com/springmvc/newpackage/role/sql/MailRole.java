package com.springmvc.newpackage.role.sql;

import java.sql.Connection;

import com.springmvc.frame.util.ExecJDBC;
import com.springmvc.newpackage.po.MailPO;
import com.springmvc.newpackage.result.Result;
import com.springmvc.newpackage.sql.SQLtodo;

public enum MailRole implements SQLtodo {
	MAIL_INSERT_MAILPO{

		@Override
		public Object sql(Object... args) {
			String sql = "insert into mail(m_name,m_tel,m_address,mu_id) values(?,?,?,?)";
			return new Result(ExecJDBC.sql(sql, (Connection)args[0], ((MailPO)args[1]).getM_name(),((MailPO)args[1]).getM_tel(),((MailPO)args[1]).getM_address(),((MailPO)args[1]).getMu_id()));
		}
		
	},
	
	MAIL_SELECT_UID{

		@Override
		public Object sql(Object... args) {
			String sql = "select m_id,m_name,m_tel,m_address from mail where mu_id=? and m_soft=0";
			return new Result(ExecJDBC.sqlByObj(sql, (Connection)args[0], MailPO.class, (int)args[1]));
		}
		
	},
}
