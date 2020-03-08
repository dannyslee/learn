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
	public Result changeOrderStatus(Connection con, int o_id, int o_status) {
		
		return (Result)select("ORDER_SELECT_ALL",con,o_id,o_status);
	}

	@Override
	public Result searchOrdersByUserId(Connection con, int ou_id) {
		
		return (Result)select("ORDER_SELECT_UID",con,ou_id);
	}



}
