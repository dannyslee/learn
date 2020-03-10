package com.springmvc.newpackage.role.daorole;

import java.sql.Connection;

import com.springmvc.newpackage.dao.factory.DAOFactory;
import com.springmvc.newpackage.result.Result;
import com.springmvc.newpackage.strategy.DAOTodo;

public enum CommoDAORole implements DAOTodo {
	
	COMMODAO_SELECT_CID{

		@Override
		public Object todo(Object... args) {
			return DAOFactory.getInstance("commo").getCommo().SearchCommodititesBycid((Connection)args[0], (int)args[1]);
		}
		
	},
	
	COMMODAO_SELECT_TYPEID_PAGEID{

		@Override
		public Object todo(Object... args) {
			
			return DAOFactory.getInstance("commo").getCommo().SearchCommodititesBytid((Connection)args[0], (int)args[1],(int)args[2]);
		}
		
	},
	
	
//	public Result SearchCommodititesBytidDesc(Connection con, int ct_id,int page) {
//		return (Result) select("COMMO_SELECT_TYPEID_PAGEID_DESC", con, ct_id,page);
//	}
	
	COMMODAO_SELECT_TYPEID_PAGEID_DESC{

		@Override
		public Object todo(Object... args) {
			
			return DAOFactory.getInstance("commo").getCommo().SearchCommodititesBytidDesc((Connection)args[0], (int)args[1],(int)args[2]);
		}
		
	},
	
	
	COMMODAO_SELECT_COMMOID{

		@Override
		public Object todo(Object... args) {
		
			return DAOFactory.getInstance("commo").getCommo().SearchCommodititesBycid((Connection)args[0], (int)args[1]);
		}
		
	},
	
	COMMODAO_COUNT_SELECT_TYPEID{
		
		@Override
		public Object todo(Object... args) {
			return DAOFactory.getInstance("commo").getCommo().SearchCountCommodititesBytid((Connection)args[0], (int)args[1]);
		}
		
	},
	
	COMMODAO_UPDATE_STOCKID_COMMOID{

		@Override
		public Object todo(Object... args) {
			return DAOFactory.getInstance("commo").getCommo().updateStockByid((Connection)args[0],(int)args[1],(int)args[2]);
		}
		
	},
}
