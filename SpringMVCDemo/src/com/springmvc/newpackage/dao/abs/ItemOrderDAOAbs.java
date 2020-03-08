package com.springmvc.newpackage.dao.abs;

import java.sql.Connection;

import com.springmvc.newpackage.dao.intface.DAOInsertInterface;
import com.springmvc.newpackage.dao.intface.DAOSelectInterface;
import com.springmvc.newpackage.po.ItemOrderPO;
import com.springmvc.newpackage.result.Result;
import com.springmvc.newpackage.role.sql.ItemOrderRole;
import com.springmvc.newpackage.sql.SQLMethod;

public abstract class ItemOrderDAOAbs implements DAOSelectInterface,DAOInsertInterface {

	@Override
	public Object insert(String roleName, Object... args) {
		return new SQLMethod().SQL(ItemOrderRole.valueOf(roleName), args);
	}

	@Override
	public Object select(String roleName, Object... args) {
		return new SQLMethod().SQL(ItemOrderRole.valueOf(roleName), args);
	}
	
	public abstract Result searchOrderItemCommo(Connection con,int ou_id,int o_id);
	
	public abstract Result saveOrderItem(Connection con, ItemOrderPO itemOrderPO);
	
}
