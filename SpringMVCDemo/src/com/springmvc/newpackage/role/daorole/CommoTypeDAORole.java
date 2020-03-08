package com.springmvc.newpackage.role.daorole;

import java.sql.Connection;

import com.springmvc.newpackage.dao.factory.DAOFactory;
import com.springmvc.newpackage.strategy.DAOTodo;

public enum CommoTypeDAORole implements DAOTodo  {
	COMMOTYPEDAO_SELECT_ALL{

		@Override
		public Object todo(Object... args) {			
			return DAOFactory.getInstance("type").getCommoType().searchAllTypeOfCommo((Connection)args[0]);
		}
		
	}
}
