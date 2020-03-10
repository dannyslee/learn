package com.springmvc.newpackage.dao;

import java.math.BigDecimal;
import java.sql.Connection;

import com.springmvc.newpackage.dao.abs.AdminDAOAbs;
import com.springmvc.newpackage.result.Result;

public class AdminDAO extends AdminDAOAbs {

	@Override
	public Result selectAllCommo(Connection con) {
		
		return (Result)select("ADMINCOMMO_SELECT_ALL",con);
	}

	@Override
	public Result selectCommoBycname(Connection con, String c_name) {
		// TODO Auto-generated method stub
		return (Result)select("ADMINCOMMO_SELECT_BY_CNAME",con,c_name);
	}

	@Override
	public Result updateCommoStockBycid(Connection con, String c_name,String c_img,String c_show,BigDecimal c_pricce,int c_stock,int c_id) {
		// TODO Auto-generated method stub
		return (Result)update("ADMINCOMMO_UPDATE_CSTOCK_BY_CID",con,c_name,c_img,c_show,c_pricce,c_stock,c_id);
	}

	@Override
	public Result deleteCommoBycid(Connection con, int c_id) {
		// TODO Auto-generated method stub
		return (Result)update("ADMINCOMMO_DELETE_BY_CID",con,c_id);
	}

	@Override
	public Result insertCommoAll(Connection con, String c_name, String c_img, String c_cartimg, String c_show,
			BigDecimal c_price, int c_stock, int ct_id) {
		// TODO Auto-generated method stub
		return (Result)insert("ADMINCOMMO_INSERT_ALL",con,c_name,c_img,c_cartimg,c_show,c_price,c_stock,ct_id);
	}

	@Override
	public Result selectAllOrder(Connection con) {
		
		return (Result)select("ADMINORDER_SELECT_ALL",con);
	}

	@Override
	public Result selectOrderByStatus(Connection con, int o_status) {
		// TODO Auto-generated method stub
		return (Result)select("ADMINORDER_SELECT_BY_OSTATUS",con,o_status);
	}

	@Override
	public Result updateOrderStatus(Connection con, int o_status, int o_id) {
		// TODO Auto-generated method stub
		return (Result)update("ADMINORDER_UPDATE_OSTATUS_BY_OID",con,o_status,o_id);
	}

	@Override
	public Result insertType(Connection con, String t_typename, String t_img, String t_typeshow) {
		
		return (Result)insert("ADMINTYPE_INSERT_ALL",con,t_typename,t_img,t_typeshow);
	}

	@Override
	public Result updateTypeBytid(Connection con, String t_typename, String t_img, String t_typeshow, int t_id) {
		return (Result)update("ADMINTYPE_UPDAET_BY_TID",con,t_typename,t_img,t_typeshow,t_id);
	}

	@Override
	public Result deleteTypeBytid(Connection con, int t_id) {
		return(Result)update("ADMINTYPE_DELETE_BY_TID",con,t_id);
	}

	public Result selectTypeBytid(Connection con, int t_id) {
		
		 return(Result)update("ADMINTYPE_SELECT_BY_TID",con,t_id);
	}
	
}
