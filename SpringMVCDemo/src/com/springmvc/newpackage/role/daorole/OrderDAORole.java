package com.springmvc.newpackage.role.daorole;

import java.sql.Connection;

import com.springmvc.newpackage.dao.factory.DAOFactory;
import com.springmvc.newpackage.po.OrderPO;
import com.springmvc.newpackage.strategy.DAOTodo;

public enum OrderDAORole implements DAOTodo {
	ORDERDAO_INSERT_ORDERPO{

		@Override
		public Object todo(Object... args) {
			return DAOFactory.getInstance("order").getOrder().saveOrder((Connection)args[0], (OrderPO)args[1]);
		}
		
	},
	ORDERDAO_SELECT_ALL{

		@Override
		public Object todo(Object... args) {
			return DAOFactory.getInstance("order").getOrder().searchAllOrder((Connection)args[0]);
		}
		
	},
	
	ORDERDAO_UPDATE_OSTATUS_AND_OPAYID_BY_OID{

		@Override
		public Object todo(Object... args) {
			return DAOFactory.getInstance("order").getOrder().changeOrderStatusAndPayId((Connection)args[0],(int)args[1],(String)args[2],(String)args[3]);
		}
		
	},
	ORDERDAO_SELECT_UID{

		@Override
		public Object todo(Object... args) {
			return DAOFactory.getInstance("order").getOrder().searchOrdersByUserId((Connection)args[0], (int)args[1]);
		}
		
	}
	
}
