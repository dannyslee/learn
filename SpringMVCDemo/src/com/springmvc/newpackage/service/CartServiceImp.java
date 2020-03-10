package com.springmvc.newpackage.service;

import java.sql.Connection;

import com.springmvc.frame.util.C3P0Util;
import com.springmvc.newpackage.dao.factory.DAOFactory;
import com.springmvc.newpackage.result.Result;
import com.springmvc.newpackage.service.abs.CartServiceAbs;
import com.springmvc.newpackage.service.intface.Service;

public class CartServiceImp extends CartServiceAbs implements Service {

	@Override
	public Result getInsertCart(int sc_id, int su_id, int s_num) {
		Connection con = C3P0Util.getConnection();
		Result insert = (Result)getInsert("CARTDAO_ISNERT_COMMOID_UID_NUMBERID", con,sc_id, su_id, s_num);
		C3P0Util.close(con);
		return insert;
	}

	@Override
	public Result getDeleteCart(int s_id) {
        Connection con = C3P0Util.getConnection();
        Result delete = (Result)getDelete("CARTDAO_DELETE_CARTID",con, s_id);
		C3P0Util.close(con);
		return delete;
	}

	@Override
	public Result getClearCart(int su_id) {
        Connection con = C3P0Util.getConnection();
        Result deleteAll = (Result)getDelete("CARTDAO_DELETEALL_UID",con, su_id);
		C3P0Util.close(con);
		return deleteAll;
	}

	@Override
	public Result getUpdateCart(int s_id, int su_id, int s_num) {
        Connection con = C3P0Util.getConnection();
        Result update = (Result)getUpdate("CARTDAO_UPDATE_CARTID_UID_NUMBERID", con, s_id, su_id, s_num);
		C3P0Util.close(con);
		return update;
	}

	@Override
	public Result getSearchCartByid(int sc_id, int su_id) {
        Connection con = C3P0Util.getConnection();
        Result search = (Result)getSelect("CARTDAO_SELECT_COMMOID_UID", con, sc_id, su_id);
		C3P0Util.close(con);
		return search ;
	}

	@Override
	public Result searchCartAllbyuid(int su_id) {
        Connection con = C3P0Util.getConnection();
        Result search = (Result)getSelect("CARTDAO_SELECT_UID", con,su_id);
		C3P0Util.close(con);
		return search;
	}

	@Override
	public Result getSearchCartBysid(int s_id) {
        Connection con = C3P0Util.getConnection();
        Result search = (Result)getSelect("CARTDAO_SELECT_CARTID", con,s_id);
		C3P0Util.close(con);
		return search;
	}
	
}
