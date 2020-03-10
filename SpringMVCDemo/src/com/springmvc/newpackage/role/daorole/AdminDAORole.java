package com.springmvc.newpackage.role.daorole;

import java.math.BigDecimal;
import java.sql.Connection;

import com.springmvc.newpackage.dao.AdminDAO;
import com.springmvc.newpackage.strategy.DAOTodo;

public enum AdminDAORole implements DAOTodo {
	
	ADMINCOMMODAO_SELECT_ALL{

		@Override
		public Object todo(Object... args) {
			
			return new AdminDAO().selectAllCommo((Connection)args[0]);
		}
		
	},
	
	ADMINCOMMODAO_SELECT_BY_CNAME{

		@Override
		public Object todo(Object... args) {
			
			return new AdminDAO().selectCommoBycname((Connection)args[0], (String)args[1]);
		}
		
	},
	
	ADMINCOMMODAO_UPDATE_CSTOCK_BY_CID{

		@Override
		public Object todo(Object... args) {
			
			return new AdminDAO().updateCommoStockBycid((Connection)args[0], (String)args[1],(String)args[2],(String)args[3],(BigDecimal)args[4], (int)args[5],(int)args[6]);
		}
		
	},
	
	ADMINCOMMODAO_DELETE_BY_CID{

		@Override
		public Object todo(Object... args) {
			// TODO Auto-generated method stub
			return new AdminDAO().deleteCommoBycid((Connection)args[0], (int)args[1]);
		}
		
	},
	
	ADMINCOMMODAO_INSERT_ALL{

		@Override
		public Object todo(Object... args) {
			// TODO Auto-generated method stub
			return new AdminDAO().insertCommoAll((Connection)args[0], (String)args[1],(String)args[2],(String)args[3],(String)args[4],(BigDecimal)args[5],(int)args[6],(int)args[7]);
		}
		
	},
	
	
	/**
	 * 订单
	 */
	
	ADMINORDERDAO_SELECT_ALL{

		@Override
		public Object todo(Object... args) {
			// TODO Auto-generated method stub
			return new AdminDAO().selectAllOrder((Connection)args[0]);
		}
		
	},
	
	ADMINORDERDAO_SELECT_BY_OSTATUS{

		@Override
		public Object todo(Object... args) {
			// TODO Auto-generated method stub
			return new AdminDAO().selectOrderByStatus((Connection)args[0], (int)args[1]);
		}
		
	},
	
//	ADMINORDERDAO_UPDATE_OSTATUS_BY_OID{
//
//		@Override
//		public Object todo(Object... args) {
//			// TODO Auto-generated method stub
//			return new AdminDAO().updateCommoStockBycid((Connection)args[0], (String)args[1],(String)args[2],(String)args[3],(BigDecimal)args[4], (int)args[5],(int)args[6]);
//		}
//		
//	},
	
	ADMINTYPEDAO_INSERT_ALL{

		@Override
		public Object todo(Object... args) {
			return new AdminDAO().insertType((Connection)args[0], (String)args[1], (String)args[2], (String)args[3]);
		}
		
	},
	
	ADMINTYPEDAO_UPDAET_BY_TID{

		@Override
		public Object todo(Object... args) {
			// TODO Auto-generated method stub
			return new AdminDAO().updateTypeBytid((Connection)args[0], (String)args[1], (String)args[2], (String)args[3], (int)args[4]);
		}
		
	},
	
	ADMINTYPEDAO_DELETE_BY_TID{

		@Override
		public Object todo(Object... args) {
			// TODO Auto-generated method stub
			return new AdminDAO().deleteTypeBytid((Connection)args[0], (int)args[1]);
		}
		
	},
	
	ADMINTYPEDAO_SELECT_BY_TID{

		@Override
		public Object todo(Object... args) {
			
			return new AdminDAO().selectTypeBytid((Connection)args[0], (int)args[1]);
		}
		
	}
	
}
