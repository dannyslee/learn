package com.springmvc.newpackage.service;


import java.sql.Connection;

import com.springmvc.frame.util.C3P0Util;
import com.springmvc.newpackage.result.Result;
import com.springmvc.newpackage.service.abs.ItemOrderServiceAbs;
import com.springmvc.newpackage.service.intface.Service;

public class ItemOrderServiceImp extends ItemOrderServiceAbs implements Service {

	@Override
	public Result getSearchOrderItemCommo(int ou_id, int o_id) {
		Connection con = C3P0Util.getConnection();
		Result select = (Result)getSelect("ORDERITEMDAO_AND_COMMODAO_SELECT_UID_OID",ou_id,o_id);
		C3P0Util.close(con);
		return select;
	}

	
}
