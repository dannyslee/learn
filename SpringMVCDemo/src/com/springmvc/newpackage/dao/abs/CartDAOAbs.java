package com.springmvc.newpackage.dao.abs;

import java.sql.Connection;
import java.util.List;

import com.springmvc.frame.po.ShoppingCartPO;
import com.springmvc.newpackage.dao.intface.DAODeleteInterface;
import com.springmvc.newpackage.dao.intface.DAOInsertInterface;
import com.springmvc.newpackage.dao.intface.DAOSelectInterface;
import com.springmvc.newpackage.dao.intface.DAOUpdateInterface;
import com.springmvc.newpackage.result.Result;
import com.springmvc.newpackage.role.sql.CartRole;
import com.springmvc.newpackage.sql.SQLMethod;

public abstract class CartDAOAbs implements DAOSelectInterface,DAOInsertInterface,DAODeleteInterface,DAOUpdateInterface {
	
	/**
	 * 执行更新
	 */
	@Override
	public Object update(String roleName, Object... args) {
		return new SQLMethod().SQL(CartRole.valueOf(roleName), args);
	}
	/**
	 * 执行删除
	 */
	@Override
	public Object delete(String roleName, Object... args) {
		return new SQLMethod().SQL(CartRole.valueOf(roleName), args);
	}
	/**
	 * 执行插入
	 */
	@Override
	public Object insert(String roleName, Object... args) {
		return new SQLMethod().SQL(CartRole.valueOf(roleName), args);
	}
	/**
	 * 执行查询
	 */
	@Override
	public Object select(String roleName, Object... args) {
		return new SQLMethod().SQL(CartRole.valueOf(roleName), args);
	}

	// 添加
	public abstract Result insertCart(Connection con, int sc_id, int su_id, int s_num);

	// 删除
	public abstract Result deleteCart(Connection con, int s_id);

	// 清空
	public abstract Result clearCart(Connection con, int su_id);

	// 修改数量
	public abstract Result updateCart(Connection con, int s_id, int su_id, int s_num);

	// 根据条件查询购物车中是否存在相关内容
	public abstract Result searchCartByid(Connection con, int sc_id, int su_id);

	// 显示该sesssion用户下，全部的购物车内容
	public abstract Result searchCartAllbyuid(Connection con, int su_id);

	// 通过s_id获取信息
	public abstract Result searchCartAllbysid(Connection con, int s_id);
}
