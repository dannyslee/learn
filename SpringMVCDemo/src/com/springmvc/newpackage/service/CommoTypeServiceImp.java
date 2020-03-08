package com.springmvc.newpackage.service;

import java.sql.Connection;

import com.springmvc.frame.util.C3P0Util;
import com.springmvc.newpackage.result.Result;
import com.springmvc.newpackage.service.abs.CommoTypeServiceAbs;
import com.springmvc.newpackage.service.intface.Service;

public class CommoTypeServiceImp extends CommoTypeServiceAbs implements Service {

	//获取所有商品
	@Override
	public Result getSearchAllTypeOfCommo() {
		Connection con = C3P0Util.getConnection();
		Object select = getSelect("COMMOTYPEDAO_SELECT_ALL", con);
		C3P0Util.close(con);
		return (Result)select;
	}
	
}
