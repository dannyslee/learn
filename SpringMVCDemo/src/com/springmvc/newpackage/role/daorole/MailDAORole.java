package com.springmvc.newpackage.role.daorole;

import java.sql.Connection;

import com.springmvc.newpackage.dao.factory.DAOFactory;
import com.springmvc.newpackage.po.MailPO;
import com.springmvc.newpackage.strategy.DAOTodo;

public enum MailDAORole implements DAOTodo{
	MAILDAO_INSERT_MAILPO{

		@Override
		public Object todo(Object... args) {
			return DAOFactory.getInstance("mail").getMail().insertMail((Connection)args[0], (MailPO)args[1]);
		}
		
	},
	
	MAILDAO_SELECT_UID{

		@Override
		public Object todo(Object... args) {
			return DAOFactory.getInstance("mail").getMail().searchMail((Connection)args[0], (int)args[1]);
		}
		
	},
}
