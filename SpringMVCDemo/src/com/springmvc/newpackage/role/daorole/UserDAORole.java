package com.springmvc.newpackage.role.daorole;


import java.sql.Connection;

import com.springmvc.newpackage.dao.factory.DAOFactory;
import com.springmvc.newpackage.strategy.DAOTodo;

public enum UserDAORole implements DAOTodo{
	
	
	USERDAO_SELECT_lOGIN_USER_P{

		@Override
		public Object todo(Object... args) {
			
			return DAOFactory.getInstance("user").getUser().searchLoginUser((Connection)args[0], (String)args[1], (String)args[2]);
		}
		
	},
	
	USERDAO_SELECT_REGITER_USER{

		@Override
		public Object todo(Object... args) {
			return DAOFactory.getInstance("user").getUser().searchRegiterUser((Connection)args[0], (String)args[1]);
		}
		
	},
	
	USERDAO_INSERT_REGITER_USER_P{

		@Override
		public Object todo(Object... args) {
			return DAOFactory.getInstance("user").getUser().insertRegiterUser((Connection)args[0], (String)args[1], (String)args[2]);
		}
		
	}
	
	

}
