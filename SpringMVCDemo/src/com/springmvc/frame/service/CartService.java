package com.springmvc.frame.service;


import java.sql.Connection;
import java.util.List;

import com.springmvc.frame.po.ShoppingCartPO;

public interface CartService {

	// 添加
	ShoppingCartPO getInsertCart(int sc_id, int su_id,int s_num);

	// 删除
	boolean getDeleteCart(int s_id);

	// 清空
	boolean getClearCart(int su_id);

	// 修改数量
	boolean getUpdateCart(int s_id, int su_id, int s_num);
	
	// 按条件查询
	ShoppingCartPO getSearchCartByid(int sc_id,int su_id);
	
	// 根据sessionid查询
	List<ShoppingCartPO> searchCartAllbyuid(int su_id);
	
	// 按照s_id查询
	ShoppingCartPO getSearchCartBysid(int s_id);

}
