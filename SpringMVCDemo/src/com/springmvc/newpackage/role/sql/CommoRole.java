package com.springmvc.newpackage.role.sql;

import java.sql.Connection;

import com.springmvc.frame.util.ExecJDBC;
import com.springmvc.newpackage.po.CommoditityPO;
import com.springmvc.newpackage.result.Result;
import com.springmvc.newpackage.sql.SQLtodo;

public enum CommoRole implements SQLtodo{
	//以产品类型+页数查询
	COMMO_SELECT_TYPEID_PAGEID{

		@Override
		public Object sql(Object... args) {
			String sql = "select c_id,c_name,c_img,c_show,c_price,c_cartimg,c_stock,ct_id,c_soft from commodities where ct_id=? and c_soft=0 limit ?,10";
			return new Result(ExecJDBC.sqlByObj(sql, (Connection)args[0],CommoditityPO.class, (int)args[1], (int)args[2]));
		}
		
	},
	
	COMMO_SELECT_TYPEID_PAGEID_DESC{

		@Override
		public Object sql(Object... args) {
			String sql = "select c_id,c_name,c_img,c_show,c_price,c_cartimg,c_stock,ct_id,c_soft from commodities where ct_id=? and c_soft=0 order by c_id desc limit ?,10";
			return new Result(ExecJDBC.sqlByObj(sql, (Connection)args[0],CommoditityPO.class, (int)args[1], (int)args[2]));
		}
		
	},
	
	//以产品id进行查询
	COMMO_SELECT_COMMOID{

		@Override
		public Object sql(Object... args) {
			String sql = "select c_id,c_name,c_img,c_cartimg,c_show,c_price,c_stock,ct_id,c_soft from commodities where c_id=? and c_soft=0";
			// ExecJDBC.sql(sql, con, CommoditityPO.class, c_id);
			return new Result(ExecJDBC.sql(sql, (Connection)args[0],CommoditityPO.class, (int)args[1]));
		}
		
	},
	
	//以类型id进行查询
	COMMO_COUNT_SELECT_TYPEID{

		@Override
		public Object sql(Object... args) {
			String sql="select count(c_id) from commodities where ct_id=? and c_soft=0";
			return new Result((ExecJDBC.sql(sql, (Connection)args[0],Long.class, (int)args[1])).longValue());
		}
		
	},
	
	//以商品id与数量，更新库存
	COMMO_UPDATE_STOCKID_COMMOID{

		@Override
		public Object sql(Object... args) {
			String sql="update commodities set c_stock=? where c_id=? and c_soft=0";
			return new Result(ExecJDBC.sql((Connection)args[0], sql, (int)args[1],(int)args[2]));
		}
		
	}
}
