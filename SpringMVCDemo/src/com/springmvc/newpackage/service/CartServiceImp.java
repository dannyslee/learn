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
		DAOFactory.getInstance("cart").getCart().insertCart(con, sc_id, su_id, s_num);
		C3P0Util.close(con);
		return null;
	}

	@Override
	public Result getDeleteCart(int s_id) {
        Connection con = C3P0Util.getConnection();
        DAOFactory.getInstance("cart").getCart().deleteCart(con, s_id);
		C3P0Util.close(con);
		return null;
	}

	@Override
	public Result getClearCart(int su_id) {
        Connection con = C3P0Util.getConnection();
        Result clearCart = DAOFactory.getInstance("cart").getCart().clearCart(con, su_id);
		C3P0Util.close(con);
		return clearCart;
	}

	@Override
	public Result getUpdateCart(int s_id, int su_id, int s_num) {
        Connection con = C3P0Util.getConnection();
		Result updateCart = DAOFactory.getInstance("cart").getCart().updateCart(con, s_id, su_id, s_num);
		C3P0Util.close(con);
		return updateCart;
	}

	@Override
	public Result getSearchCartByid(int sc_id, int su_id) {
        Connection con = C3P0Util.getConnection();
		Result searchCartByid = DAOFactory.getInstance("cart").getCart().searchCartByid(con, sc_id, su_id);
		C3P0Util.close(con);
		return searchCartByid ;
	}

	@Override
	public Result searchCartAllbyuid(int su_id) {
        Connection con = C3P0Util.getConnection();
		Result searchCartAllbyuid = DAOFactory.getInstance("cart").getCart().searchCartAllbyuid(con, su_id);
		C3P0Util.close(con);
		return searchCartAllbyuid;
	}

	@Override
	public Result getSearchCartBysid(int s_id) {
        Connection con = C3P0Util.getConnection();
		Result searchCartAllbysid = DAOFactory.getInstance("cart").getCart().searchCartAllbysid(con, s_id);
		C3P0Util.close(con);
		return searchCartAllbysid;
	}
	
}
