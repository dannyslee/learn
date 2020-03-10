package com.springmvc.newpackage.service;

import java.math.BigDecimal;
import java.sql.Connection;

import com.springmvc.frame.util.C3P0Util;
import com.springmvc.newpackage.result.Result;
import com.springmvc.newpackage.service.abs.AdminServiceAbs;

public class AdminService extends AdminServiceAbs {

	@Override
	public Result getSelectAllCommo() {
		Connection con = C3P0Util.getConnection();
		Result select = (Result)getSelect("ADMINCOMMODAO_SELECT_ALL", con);
		C3P0Util.close(con);
		return select ;
	}

	@Override
	public Result getSelectCommoBycname(String c_name) {
        Connection con = C3P0Util.getConnection();
        Result select = (Result)getSelect("ADMINCOMMODAO_SELECT_BY_CNAME", con,c_name);
		C3P0Util.close(con);
		return select;
	}

	@Override
	public Result getUpdateCommoStockBycid(String c_name,String c_img,String c_show,BigDecimal c_pricce,int c_stock,int c_id) {
        Connection con = C3P0Util.getConnection();
        Result update = (Result)getUpdate("ADMINCOMMODAO_UPDATE_CSTOCK_BY_CID", con,c_name,c_img,c_show,c_pricce,c_stock,c_id);
		C3P0Util.close(con);
		return update;
	}

	@Override
	public Result getDeleteCommoBycid(int c_id) {
        Connection con = C3P0Util.getConnection();
        Result update = (Result)getUpdate("ADMINCOMMODAO_DELETE_BY_CID", con,c_id);
		C3P0Util.close(con);
		return update;
	}

	@Override
	public Result getInsertCommoAll(String c_name, String c_img, String c_cartimg, String c_show, BigDecimal c_pricce,
			int c_stock, int ct_id) {
        Connection con = C3P0Util.getConnection();
        Result insert = (Result)getInsert("ADMINCOMMODAO_INSERT_ALL", con,c_name,c_img,c_cartimg,c_show,c_pricce,c_stock,ct_id);
		C3P0Util.close(con);
		return insert;
	}

	@Override
	public Result getSelectAllOrder() {
        Connection con = C3P0Util.getConnection();
        Result select = (Result)getSelect("ADMINORDERDAO_SELECT_ALL", con);
		C3P0Util.close(con);
		return select;
	}

	@Override
	public Result getSelectOrderByStatus(int o_status) {
        Connection con = C3P0Util.getConnection();
        Result select = (Result)getSelect("ADMINORDERDAO_SELECT_BY_OSTATUS", con,o_status);
		C3P0Util.close(con);
		return select;
	}

	@Override
	public Result getUpdateOrderStatus(int o_status, int o_id) {
        Connection con = C3P0Util.getConnection();
        Result update = (Result)getUpdate("ADMINORDERDAO_UPDATE_OSTATUS_BY_OID", con,o_status,o_id);
		C3P0Util.close(con);
		return update;
	}

	@Override
	public Result getInsertType(String t_typename, String t_img, String t_typeshow) {
        Connection con = C3P0Util.getConnection();
        Result insert = (Result)getInsert("ADMINTYPEDAO_INSERT_ALL",con,t_typename,t_img,t_typeshow);
		C3P0Util.close(con);
		return insert;
	}

	@Override
	public Result getUpdateTypeBytid(String t_typename, String t_img, String t_typeshow, int t_id) {
        Connection con = C3P0Util.getConnection();
        Result insert = (Result)getUpdate("ADMINTYPEDAO_UPDAET_BY_TID",con, t_typename, t_img, t_typeshow, t_id);
		C3P0Util.close(con);
		return insert;
	}

	@Override
	public Result getDeleteTypeBytid(int t_id) {
        Connection con = C3P0Util.getConnection();
        Result delete = (Result)getUpdate("ADMINTYPEDAO_DELETE_BY_TID", con,t_id);
		C3P0Util.close(con);
		return delete;
	}

	public Result getSelectTypeBytid(int t_id) {
        Connection con = C3P0Util.getConnection();
        Result select = (Result)getSelect("ADMINTYPEDAO_SELECT_BY_TID",con, t_id);
		C3P0Util.close(con);
		return select;
	}

}
