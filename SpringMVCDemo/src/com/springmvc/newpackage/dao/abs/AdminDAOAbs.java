package com.springmvc.newpackage.dao.abs;

import java.math.BigDecimal;
import java.sql.Connection;

import com.springmvc.newpackage.dao.intface.DAODeleteInterface;
import com.springmvc.newpackage.dao.intface.DAOInsertInterface;
import com.springmvc.newpackage.dao.intface.DAOSelectInterface;
import com.springmvc.newpackage.dao.intface.DAOUpdateInterface;
import com.springmvc.newpackage.result.Result;
import com.springmvc.newpackage.role.sql.AdminRole;
import com.springmvc.newpackage.sql.SQLMethod;

public abstract class AdminDAOAbs implements DAOSelectInterface,DAODeleteInterface,DAOUpdateInterface,DAOInsertInterface {

	@Override
	public Object insert(String roleName, Object... args) {
		
		return new SQLMethod().SQL(AdminRole.valueOf(roleName), args);
	}

	@Override
	public Object update(String roleName, Object... args) {
		// TODO Auto-generated method stub
		return new SQLMethod().SQL(AdminRole.valueOf(roleName), args);
	}

	@Override
	public Object delete(String roleName, Object... args) {
		// TODO Auto-generated method stub
		return new SQLMethod().SQL(AdminRole.valueOf(roleName), args);
	}

	@Override
	public Object select(String roleName, Object... args) {
		// TODO Auto-generated method stub
		return new SQLMethod().SQL(AdminRole.valueOf(roleName), args);
	}
	
	//处理商品
	//获取全部商品信息
	public abstract Result selectAllCommo(Connection con);
	
	//更具名字模糊查询 不确定
	
	public abstract Result selectCommoBycname(Connection con,String c_name);
	//单项更新
	public abstract Result updateCommoStockBycid(Connection con,String c_name,String c_img,String c_show,BigDecimal c_pricce,int c_stock,int c_id);
	//单项删除
	public abstract Result deleteCommoBycid(Connection con,int c_id);
	//新增数据
	public abstract Result insertCommoAll(Connection con,String c_name,String c_img,String c_cartimg,String c_show,BigDecimal c_pricce,int c_stock,int ct_id);
	
	
	//处理订单
	//查询全部订单
	public abstract Result selectAllOrder(Connection con);
	
	//根据支付状态，查询订单
	public abstract Result selectOrderByStatus(Connection con,int o_status);
	
	//更新订单状态
	public abstract Result updateOrderStatus(Connection con,int o_status,int o_id);
	
	//处理产品类型
	public abstract Result insertType(Connection con,String t_typename,String t_img,String t_typeshow);
	
	public abstract Result updateTypeBytid(Connection con,String t_typename,String t_img,String t_typeshow,int t_id);
	
	public abstract Result deleteTypeBytid(Connection con,int t_id);
	
	public abstract Result selectTypeBytid(Connection con, int t_id);
	
}
