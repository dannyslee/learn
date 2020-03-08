package com.springmvc.frame.dao;

import java.sql.Connection;

import com.springmvc.frame.po.ItemOrderPO;

public interface ItemOrderDAO {


	boolean saveOrderItem(Connection con, ItemOrderPO itemOrderPO);

}
