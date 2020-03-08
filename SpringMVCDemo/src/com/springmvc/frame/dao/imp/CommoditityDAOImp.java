package com.springmvc.frame.dao.imp;

import java.sql.Connection;
import java.util.List;

import com.springmvc.frame.dao.CommoditityDAO;
import com.springmvc.frame.po.CommoditityPO;
import com.springmvc.frame.util.ExecJDBC;

public class CommoditityDAOImp implements CommoditityDAO {

	@Override
	public List<CommoditityPO> SearchCommodititesBytid(Connection con, int ct_id,int page) {
		String sql = "select c_id,c_name,c_img,c_show,c_price,c_stock,ct_id,c_soft from commodities where ct_id=? and c_soft=0 limit ?,10";
		return ExecJDBC.sqlByObj(sql, con, CommoditityPO.class, ct_id, page);
	}
	@Override
	public CommoditityPO SearchCommodititesBycid(Connection con, int c_id) {
		String sql = "select c_id,c_name,c_img,c_show,c_price,c_stock,ct_id,c_soft from commodities where c_id=? and c_soft=0";
		return ExecJDBC.sql(sql, con, CommoditityPO.class, c_id);
	}

	@Override
	public long SearchCountCommodititesBytid(Connection con, int ct_id) {
		long l = -1;
		String sql="select count(c_id) from commodities  where ct_id=? and c_soft=0";
		l = (ExecJDBC.sql(sql, con,Long.class, ct_id)).longValue();
		return l;
	}
	public boolean updateStockByid(Connection con, int sc_id, int number) {
		String sql="update commodities set c_stock=? where c_id=? and c_soft=0";
		return ExecJDBC.sql(con, sql, number,sc_id);
	}


	
}
