package com.springmvc.newpackage.dao.abs;

import java.sql.Connection;

import com.springmvc.frame.util.ExecJDBC;
import com.springmvc.newpackage.dao.intface.DAOInsertInterface;
import com.springmvc.newpackage.dao.intface.DAOSelectInterface;
import com.springmvc.newpackage.dao.intface.DAOUpdateInterface;
import com.springmvc.newpackage.result.Result;
import com.springmvc.newpackage.role.sql.CommoRole;
import com.springmvc.newpackage.sql.SQLMethod;

public abstract class CommoDAOAbs implements DAOSelectInterface,DAOUpdateInterface{

	@Override
	public Object select(String roleName, Object... args) {
		return new SQLMethod().SQL(CommoRole.valueOf(roleName), args);
	}
	
	
	
	@Override
	public Object update(String roleName, Object... args) {
		return new SQLMethod().SQL(CommoRole.valueOf(roleName), args);
	}



	// 通过商品类型id，获得商品
	public abstract Result SearchCommodititesBytid(Connection con, int ct_id, int page);
	
	// 通过商品id获取商品
	public abstract Result SearchCommodititesBycid(Connection con, int c_id);

	// 获取商品总数
	public abstract Result SearchCountCommodititesBytid(Connection con, int ct_id);
	
	// 更新库存
	public abstract Result updateStockByid(Connection con, int number,int sc_id);
	
	

}
