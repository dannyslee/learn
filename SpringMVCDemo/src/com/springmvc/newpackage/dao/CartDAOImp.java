package com.springmvc.newpackage.dao;

import java.sql.Connection;

import com.springmvc.newpackage.dao.abs.CartDAOAbs;
import com.springmvc.newpackage.dao.intface.DAO;
import com.springmvc.newpackage.result.Result;

public class CartDAOImp extends CartDAOAbs implements DAO {

	@Override
	public Result insertCart(Connection con, int sc_id, int su_id, int s_num) {
		
		return (Result)insert("CART_ISNERT_COMMOID_UID_NUMBERID",con,sc_id,su_id,s_num);
	}

	@Override
	public Result deleteCart(Connection con, int s_id) {
		
		return (Result)delete("CART_DELETE_CARTID",con,s_id);
	}

	@Override
	public Result clearCart(Connection con, int su_id) {
		
		return (Result)delete("CART_DELETEALL_UID",con,su_id);
	}

	@Override
	public Result updateCart(Connection con, int s_id, int su_id, int s_num) {
		return (Result)update("CART_UPDATE_CARTID_UID_NUMBERID",con,s_id,su_id,s_num);
	}

	@Override
	public Result searchCartByid(Connection con, int sc_id, int su_id) {
		return (Result)select("CART_SELECT_COMMOID_UID",con,sc_id,su_id);
	}

	@Override
	public Result searchCartAllbyuid(Connection con, int su_id) {
		return (Result)select("CART_SELECT_UID",con,su_id);
	}

	@Override
	public Result searchCartAllbysid(Connection con, int s_id) {
		return (Result)select("CART_SELECT_CARTID",con,s_id);
	}



}
