package com.springmvc.newpackage.dao;

import java.sql.Connection;

import com.springmvc.newpackage.dao.abs.OrderDAOAbs;
import com.springmvc.newpackage.dao.intface.DAO;
import com.springmvc.newpackage.po.OrderPO;
import com.springmvc.newpackage.result.Result;

public class OrderDAOImp extends OrderDAOAbs implements DAO {

	@Override
	public Result saveOrder(Connection con, OrderPO orderPO) {
		
		return (Result)insert("ORDER_INSERT_ORDERPO",con,orderPO);
	}

	@Override
	public Result searchAllOrder(Connection con) {
		
		return (Result)select("ORDER_SELECT_ALL",con);
	}

	
	@Override
	public Result searchOrdersByUserId(Connection con, int ou_id) {
		
		return (Result)select("ORDER_SELECT_UID",con,ou_id);
	}

	@Override
	public Result changeOrderStatusAndPayId(Connection con, int o_status, String o_payid, String o_no) {
		
		return (Result)update("ORDER_UPDATE_OSTATUS_AND_OPAYID_BY_OID",con,o_status,o_payid,o_no);
	}



}
