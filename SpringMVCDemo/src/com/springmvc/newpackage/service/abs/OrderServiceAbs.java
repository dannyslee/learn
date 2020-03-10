package com.springmvc.newpackage.service.abs;

import java.sql.Connection;

import com.springmvc.newpackage.po.OrderPO;
import com.springmvc.newpackage.result.Result;
import com.springmvc.newpackage.role.daorole.OrderDAORole;
import com.springmvc.newpackage.service.intface.ServiceInsertInterface;
import com.springmvc.newpackage.service.intface.ServiceSelectInterface;
import com.springmvc.newpackage.service.intface.ServiceUpdateInterface;
import com.springmvc.newpackage.strategy.DAOMethod;

public abstract class OrderServiceAbs implements ServiceSelectInterface,ServiceUpdateInterface,ServiceInsertInterface {

	@Override
	public Object getSelect(String className, Object... args) {
		return new DAOMethod().toDo(OrderDAORole.valueOf(className), args);
	}
	
	

	@Override
	public Object getInsert(String roleName, Object... args) {
		// TODO Auto-generated method stub
		return new DAOMethod().toDo(OrderDAORole.valueOf(roleName), args);
	}



	@Override
	public Object getUpdate(String roleName, Object... args) {
		// TODO Auto-generated method stub
		return new DAOMethod().toDo(OrderDAORole.valueOf(roleName), args);
	}



	// 保存订单
	public abstract Result getSaveOrder(OrderPO orderPO);

	// 查询全部订单
	public abstract Result getSearchAllOrder();

	// 修改订单状态
	public abstract Result getChangeOrderStatusAndPayId(int o_status,String o_payid,String o_no);


	// 根据用户编号查询订单信息
	public abstract Result getSearchOrdersByUserId(int ou_id);
	// 根据用户id与订单好，查询订单详情

}
