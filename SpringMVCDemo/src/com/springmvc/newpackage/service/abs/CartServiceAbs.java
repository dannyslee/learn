package com.springmvc.newpackage.service.abs;

import java.util.List;

import com.springmvc.frame.po.ShoppingCartPO;
import com.springmvc.newpackage.result.Result;
import com.springmvc.newpackage.role.daorole.CartDAORole;
import com.springmvc.newpackage.service.intface.ServiceDeleteInterface;
import com.springmvc.newpackage.service.intface.ServiceInsertInterface;
import com.springmvc.newpackage.service.intface.ServiceSelectInterface;
import com.springmvc.newpackage.service.intface.ServiceUpdateInterface;
import com.springmvc.newpackage.strategy.DAOMethod;

public abstract class CartServiceAbs implements ServiceSelectInterface,ServiceInsertInterface,ServiceDeleteInterface,ServiceUpdateInterface {

	@Override
	public Object getUpdate(String roleName, Object... args) {
		return new DAOMethod().toDo(CartDAORole.valueOf(roleName), args);
	}

	@Override
	public Object getDelete(String roleName, Object... args) {
		return new DAOMethod().toDo(CartDAORole.valueOf(roleName), args);
	}

	@Override
	public Object getInsert(String roleName, Object... args) {
		return new DAOMethod().toDo(CartDAORole.valueOf(roleName), args);
	}

	@Override
	public Object getSelect(String className, Object... args) {
		return new DAOMethod().toDo(CartDAORole.valueOf(className), args);
	}
	
	
	// 添加
	 public abstract Result getInsertCart(int sc_id, int su_id, int s_num);

	// 删除
	 public abstract Result getDeleteCart(int s_id);

	// 清空
	 public abstract Result getClearCart(int su_id);

	// 修改数量
	 public abstract Result getUpdateCart(int s_id, int su_id, int s_num);

	// 按条件查询
	 public abstract Result getSearchCartByid(int sc_id, int su_id);

	// 根据sessionid查询
	 public abstract Result searchCartAllbyuid(int su_id);

	// 按照s_id查询
	 public abstract Result getSearchCartBysid(int s_id);

}
