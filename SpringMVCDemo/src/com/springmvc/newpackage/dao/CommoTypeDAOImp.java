package com.springmvc.newpackage.dao;

import java.sql.Connection;

import com.springmvc.newpackage.dao.abs.CommoTypeDAOAbs;
import com.springmvc.newpackage.dao.intface.DAO;
import com.springmvc.newpackage.result.Result;


public class CommoTypeDAOImp extends CommoTypeDAOAbs implements DAO {
	
	
	//获取全部商品类型
	@Override
	public Result searchAllTypeOfCommo(Connection con) {	
		return (Result)select("COMMOTYPE_SELECT_ALL", con);
	}



	
	
}
