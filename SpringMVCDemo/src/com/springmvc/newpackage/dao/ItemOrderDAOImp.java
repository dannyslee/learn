package com.springmvc.newpackage.dao;

import java.sql.Connection;

import com.springmvc.newpackage.dao.abs.ItemOrderDAOAbs;
import com.springmvc.newpackage.dao.intface.DAO;
import com.springmvc.newpackage.po.ItemOrderPO;
import com.springmvc.newpackage.result.Result;

public class ItemOrderDAOImp extends ItemOrderDAOAbs implements DAO {

	@Override
	public Result searchOrderItemCommo(Connection con, int ou_id, int o_id) {
		
		return (Result)select("ORDERITEM_AND_COMMO_SELECT_UID_OID",con,ou_id,o_id);
	}

	@Override
	public Result saveOrderItem(Connection con, ItemOrderPO itemOrderPO) {
		
		return (Result)insert("ORDERITEM_INSERT_ITEMORDERPO",con,itemOrderPO);
	}
	
}
