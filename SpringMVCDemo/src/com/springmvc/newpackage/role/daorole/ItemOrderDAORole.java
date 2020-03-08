package com.springmvc.newpackage.role.daorole;

import java.sql.Connection;

import com.springmvc.newpackage.dao.factory.DAOFactory;
import com.springmvc.newpackage.po.ItemOrderPO;
import com.springmvc.newpackage.strategy.DAOTodo;

public enum ItemOrderDAORole implements DAOTodo {
	ORDERITEMDAO_AND_COMMODAO_SELECT_UID_OID{

		@Override
		public Object todo(Object... args) {
			
			return DAOFactory.getInstance("item").getItemOrder().searchOrderItemCommo((Connection)args[0], (int)args[1], (int)args[2]);
		}
		
	},
	
	ORDERITEM_INSERT_ITEMORDERPO{

		@Override
		public Object todo(Object... args) {
			return DAOFactory.getInstance("item").getItemOrder().saveOrderItem((Connection)args[0], (ItemOrderPO)args[1]);
		}
		
	}
}
