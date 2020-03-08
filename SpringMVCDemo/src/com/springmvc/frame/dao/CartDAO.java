package com.springmvc.frame.dao;

import java.sql.Connection;
import java.util.List;

import com.springmvc.frame.po.ShoppingCartPO;

public interface CartDAO {
	//添加
	boolean insertCart(Connection con,int sc_id,int su_id,int s_num);
	//删除
	boolean deleteCart(Connection con,int s_id);
	//清空
	boolean clearCart(Connection con,int su_id);
	//修改数量
	boolean updateCart(Connection con,int s_id,int su_id,int s_num);
	
	//根据条件查询购物车中是否存在相关内容
	ShoppingCartPO searchCartByid(Connection con,int sc_id,int su_id);
	
	//显示该sesssion用户下，全部的购物车内容
	List<ShoppingCartPO> searchCartAllbyuid(Connection con,int su_id);
	
	//通过s_id获取信息
	ShoppingCartPO searchCartAllbysid(Connection con,int s_id);
}
