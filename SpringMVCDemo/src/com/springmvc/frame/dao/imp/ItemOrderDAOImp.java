package com.springmvc.frame.dao.imp;

import java.sql.Connection;

import com.springmvc.frame.dao.ItemOrderDAO;
import com.springmvc.frame.po.ItemOrderPO;
import com.springmvc.frame.util.ExecJDBC;

public class ItemOrderDAOImp implements ItemOrderDAO {

	@Override
	public boolean saveOrderItem(Connection con, ItemOrderPO itemOrderPO) {
		String sql = "insert into itemorder(ic_id,i_num,i_price,io_id) values(?,?,?,?)";		
		return ExecJDBC.sql(sql, con, itemOrderPO.getIc_id(),itemOrderPO.getI_num(),itemOrderPO.getI_price(),itemOrderPO.getIo_id());
	}

}
