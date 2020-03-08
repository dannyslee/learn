package com.springmvc.newpackage.role.daorole;

import java.sql.Connection;

import com.springmvc.newpackage.dao.factory.DAOFactory;
import com.springmvc.newpackage.strategy.DAOTodo;

public enum CartDAORole implements DAOTodo {
	
	CARTDAO_ISNERT_COMMOID_UID_NUMBERID{
		@Override
		public Object todo(Object... args) {
			
			return DAOFactory.getInstance("cart").getCart().insertCart((Connection)args[0], (int)args[1], (int)args[2], (int)args[3]);
		}
	},
	CARTDAO_DELETE_CARTID{

		@Override
		public Object todo(Object... args) {
			return DAOFactory.getInstance("cart").getCart().deleteCart((Connection)args[0], (int)args[1]);
		}
		
	},
	CARTDAO_DELETEALL_UID{

		@Override
		public Object todo(Object... args) {
			return  DAOFactory.getInstance("cart").getCart().clearCart((Connection)args[0], (int)args[1]);
		}
		
	},
	CARTDAO_UPDATE_CARTID_UID_NUMBERID{

		@Override
		public Object todo(Object... args) {
			return DAOFactory.getInstance("cart").getCart().updateCart((Connection)args[0], (int)args[1], (int)args[2], (int)args[3]);
		}
		
	},
	CARTDAO_SELECT_COMMOID_UID{

		@Override
		public Object todo(Object... args) {
			return DAOFactory.getInstance("cart").getCart().searchCartByid((Connection)args[0], (int)args[1], (int)args[2]);
		}
		
	},
	CARTDAO_SELECT_UID{

		@Override
		public Object todo(Object... args) {
			
			return DAOFactory.getInstance("cart").getCart().searchCartAllbyuid((Connection)args[0], (int)args[1]);
		}
		
	},
	CARTDAO_SELECT_CARTID{

		@Override
		public Object todo(Object... args) {
			
			return DAOFactory.getInstance("cart").getCart().searchCartAllbysid((Connection)args[0], (int)args[1]);
		}
		
	};

	
}
