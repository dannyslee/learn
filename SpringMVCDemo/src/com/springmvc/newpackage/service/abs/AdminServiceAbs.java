package com.springmvc.newpackage.service.abs;

import java.math.BigDecimal;
import java.sql.Connection;

import com.springmvc.newpackage.result.Result;
import com.springmvc.newpackage.role.daorole.AdminDAORole;
import com.springmvc.newpackage.role.daorole.CartDAORole;
import com.springmvc.newpackage.service.intface.ServiceDeleteInterface;
import com.springmvc.newpackage.service.intface.ServiceInsertInterface;
import com.springmvc.newpackage.service.intface.ServiceSelectInterface;
import com.springmvc.newpackage.service.intface.ServiceUpdateInterface;
import com.springmvc.newpackage.strategy.DAOMethod;

public abstract class AdminServiceAbs implements ServiceSelectInterface,ServiceInsertInterface,ServiceDeleteInterface,ServiceUpdateInterface {
	@Override
	public Object getUpdate(String roleName, Object... args) {
		return new DAOMethod().toDo(AdminDAORole.valueOf(roleName), args);
	}

	@Override
	public Object getDelete(String roleName, Object... args) {
		return new DAOMethod().toDo(AdminDAORole.valueOf(roleName), args);
	}

	@Override
	public Object getInsert(String roleName, Object... args) {
		return new DAOMethod().toDo(AdminDAORole.valueOf(roleName), args);
	}

	@Override
	public Object getSelect(String className, Object... args) {
		return new DAOMethod().toDo(AdminDAORole.valueOf(className), args);
	}
	
	// 处理商品
	// 获取全部商品信息
	public abstract Result getSelectAllCommo();

	// 更具名字模糊查询 不确定

	public abstract Result getSelectCommoBycname(String c_name);

	// 单项更新
	public abstract Result getUpdateCommoStockBycid(String c_name,String c_img,String c_show,BigDecimal c_pricce,int c_stock,int c_id);

	// 单项删除
	public abstract Result getDeleteCommoBycid(int c_id);

	// 新增数据
	public abstract Result getInsertCommoAll(String c_name, String c_img, String c_cartimg, String c_show,
			BigDecimal c_pricce, int c_stock, int ct_id);

	
	// 处理订单
	// 查询全部订单
	public abstract Result getSelectAllOrder();

	// 根据支付状态，查询订单
	public abstract Result getSelectOrderByStatus(int o_status);

	// 更新订单状态
	public abstract Result getUpdateOrderStatus(int o_status, int o_id);
	
	
	// 处理产品类型
	public abstract Result getInsertType(String t_typename, String t_img, String t_typeshow);

	public abstract Result getUpdateTypeBytid(String t_typename, String t_img, String t_typeshow,
			int t_id);

	public abstract Result getDeleteTypeBytid(int t_id);
	
	public abstract Result getSelectTypeBytid(int t_id);
	
}
