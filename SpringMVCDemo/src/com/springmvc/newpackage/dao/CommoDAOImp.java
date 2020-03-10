package com.springmvc.newpackage.dao;

import java.sql.Connection;

import com.springmvc.newpackage.dao.abs.CommoDAOAbs;
import com.springmvc.newpackage.dao.intface.DAO;
import com.springmvc.newpackage.result.Result;

public class CommoDAOImp extends CommoDAOAbs implements DAO {

	@Override
	public Result SearchCommodititesBytid(Connection con, int ct_id, int page) {
		return (Result)select("COMMO_SELECT_TYPEID_PAGEID",con,ct_id,page);
	}

	@Override
	public Result SearchCommodititesBycid(Connection con, int c_id) {
		return (Result)select("COMMO_SELECT_COMMOID",con,c_id);
	}

	@Override
	public Result SearchCountCommodititesBytid(Connection con, int ct_id) {
		return (Result)select("COMMO_COUNT_SELECT_TYPEID",con,ct_id);
	}

	@Override
	public Result updateStockByid(Connection con, int number,int sc_id) {
		
		return (Result)update("COMMO_UPDATE_STOCKID_COMMOID",con,number,sc_id);
	}
	
	
	// 通过商品类型id倒叙查询
	public Result SearchCommodititesBytidDesc(Connection con, int ct_id,int page) {
		return (Result) select("COMMO_SELECT_TYPEID_PAGEID_DESC", con, ct_id,page);
	}

}
