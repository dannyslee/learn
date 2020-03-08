package com.springmvc.frame.dao;

import java.sql.Connection;
import java.util.List;

import com.springmvc.frame.po.OrderPO;

public interface OrderDAO {
	
	//保存订单
	boolean saveOrder(Connection con, OrderPO orderPO);
	//查询全部订单
	List<OrderPO> searchAllOrder(Connection con);
	//修改订单状态
	boolean changeOrderStatus(Connection con,int o_id,int o_status);
	//根据用户编号查询订单信息
	List<OrderPO> searchOrdersByUserId(Connection con,int ou_id);
}
