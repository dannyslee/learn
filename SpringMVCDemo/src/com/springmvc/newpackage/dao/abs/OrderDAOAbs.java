package com.springmvc.newpackage.dao.abs;

import java.sql.Connection;
import java.util.List;

import com.springmvc.newpackage.dao.intface.DAOInsertInterface;
import com.springmvc.newpackage.dao.intface.DAOSelectInterface;
import com.springmvc.newpackage.dao.intface.DAOUpdateInterface;
import com.springmvc.newpackage.po.OrderPO;
import com.springmvc.newpackage.result.Result;
import com.springmvc.newpackage.role.sql.OrderRole;
import com.springmvc.newpackage.sql.SQLMethod;

public abstract class OrderDAOAbs implements DAOSelectInterface,DAOInsertInterface,DAOUpdateInterface {

	@Override
	public Object select(String roleName, Object... args) {	
		return new SQLMethod().SQL(OrderRole.valueOf(roleName), args);
	}
	
	
	
	 @Override
	public Object insert(String roleName, Object... args) {
		return new SQLMethod().SQL(OrderRole.valueOf(roleName), args);
	}

	 

	@Override
	public Object update(String roleName, Object... args) {
		// TODO Auto-generated method stub
		return new SQLMethod().SQL(OrderRole.valueOf(roleName), args);
	}



	//保存订单
	public abstract Result saveOrder(Connection con, OrderPO orderPO);
	//查询全部订单
	public abstract Result searchAllOrder(Connection con);
	//修改订单状态
	public abstract Result changeOrderStatusAndPayId(Connection con,int o_status,String o_payid,String o_no);
	//根据用户编号查询订单信息
	public abstract Result searchOrdersByUserId(Connection con,int ou_id);
	//根据用户id与订单好，查询订单详情
	
	
	
}
