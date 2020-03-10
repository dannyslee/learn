package com.springmvc.newpackage.role.sql;

import java.math.BigDecimal;
import java.sql.Connection;

import com.springmvc.frame.util.ExecJDBC;
import com.springmvc.newpackage.po.CommoditityPO;
import com.springmvc.newpackage.po.OrderPO;
import com.springmvc.newpackage.po.TypeofCommoPO;
import com.springmvc.newpackage.result.Result;
import com.springmvc.newpackage.sql.SQLtodo;

public enum AdminRole implements SQLtodo {
	
	
	
	/**
	 * 商品类型处理
	 */
	
	//单个查询
	ADMINTYPE_SELECT_BY_TID{

		@Override
		public Object sql(Object... args) {
			String sql="SELECT t_id,t_typename,t_img,t_typeshow from typeofcommo where t_id=?";
			return new Result(ExecJDBC.sql(sql, (Connection)args[0], TypeofCommoPO.class, (int)args[1]));
		}
		
	},
	
	// 新增单个
	ADMINTYPE_INSERT_ALL{

		@Override
		public Object sql(Object... args) {
			String sql="insert into typeofcommo(t_typename,t_img,t_typeshow) VALUES (?,?,?)";
			return new Result(ExecJDBC.sql(sql, (Connection)args[0], (String)args[1],(String)args[2],(String)args[3]));
		}
		
	},
	
	// 单例更改
	
	ADMINTYPE_UPDAET_BY_TID{

		@Override
		public Object sql(Object... args) {
			String sql="update typeofcommo set t_typename=?,t_img=?,t_typeshow=? where t_id=?";
			return new Result(ExecJDBC.sql(sql,(Connection)args[0], (String)args[1],(String)args[2],(String)args[3],(int)args[4]));
		}
		
	},
	
	// 单例删除
	
	ADMINTYPE_DELETE_BY_TID{

		@Override
		public Object sql(Object... args) {
			String sql="update typeofcommo set t_soft=1 where t_id=?";
			return new Result(ExecJDBC.sql(sql, (Connection)args[0], (int)args[1]));
		}
		
	},
	
	
	
	/**
	 * 商品添加
	 */
	
	//查询全部商品信息
	ADMINCOMMO_SELECT_ALL{

		@Override
		public Object sql(Object... args) {
			String sql="select c_id,c_name,c_img,c_cartimg,c_show,c_price,c_cartimg,c_stock,ct_id,c_soft from commodities order by c_id desc";
			return new Result(ExecJDBC.sql(sql, (Connection)args[0], CommoditityPO.class));
		}
		
	},
	
	//根据名字模糊查询
	ADMINCOMMO_SELECT_BY_CNAME{

		@Override
		public Object sql(Object... args) {
			String sql="select c_id,c_name,c_img,c_cartimg,c_show,c_price,c_cartimg,c_stock,ct_id,c_soft from commodities where c_name like '%?%' and c_soft=0";
			return new Result(ExecJDBC.sql(sql, (Connection)args[0], CommoditityPO.class, (String)args[1]));
		}
		
		
	},

	//单项更新
	ADMINCOMMO_UPDATE_CSTOCK_BY_CID{

		@Override
		public Object sql(Object... args) {
			String sql="UPDATE commodities set c_name=?,c_img=?,c_show=?,c_price=?,c_stock=? where c_id=?;";
			return new Result(ExecJDBC.sql(sql, (Connection)args[0], (String)args[1],(String)args[2],(String)args[3],(BigDecimal)args[4], (int)args[5],(int)args[6]));
		}
		
		
	},
	
	//单项删除
	ADMINCOMMO_DELETE_BY_CID{

		@Override
		public Object sql(Object... args) {
			String sql="UPDATE commodities set c_soft=1 where c_id=?";
			return new Result(ExecJDBC.sql(sql, (Connection)args[0], (int)args[1]));
		}
		
		
	},
	
	//新增数据
	ADMINCOMMO_INSERT_ALL{

		@Override
		public Object sql(Object... args) {
			String sql="insert into commodities(c_name,c_img,c_cartimg,c_show,c_price,c_stock,ct_id) values(?,?,?,?,?,?,?);";
			return new Result(ExecJDBC.sql(sql, (Connection)args[0], (String)args[1],(String)args[2],(String)args[3],(String)args[4],(BigDecimal)args[5],(int)args[6],(int)args[7]));
		}
		
		
	},
	
	/**
	 * 订单处理
	 */
	
	// 查询全部订单
	ADMINORDER_SELECT_ALL{

		@Override
		public Object sql(Object... args) {
			String sql="select o_id,o_no,o_payid,o_creattime,o_updatetime,o_status,ou_id,o_soft from `order` order by o_updatetime desc;";
			return new Result(ExecJDBC.sql(sql, (Connection)args[0], OrderPO.class));
		}
		
		
	},
	
	// 根据支付状态，查询订单
	ADMINORDER_SELECT_BY_OSTATUS{

		@Override
		public Object sql(Object... args) {
			String sql="select o_id,o_no,o_payid,o_creattime,o_updatetime,o_status,ou_id,o_soft from `order` where o_status=? order by o_updatetime desc;";
			return new Result(ExecJDBC.sqlByObj(sql, (Connection)args[0], OrderPO.class, (int)args[1]));
		}
		
		
	},
	
	// 更新订单状态 (单项处理)
	ADMINORDER_UPDATE_OSTATUS_BY_OID{

		@Override
		public Object sql(Object... args) {
			String sql="update `order` SET o_status=? where o_id=?;";
			return new Result(ExecJDBC.sql(sql, (Connection)args[0], (int)args[1], (int)args[2]));
		}
	}	
	
}
