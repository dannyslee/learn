package com.springmvc.newpackage.role.sql;

import java.sql.Connection;

import com.springmvc.frame.po.CartCommoPO;
import com.springmvc.frame.util.ExecJDBC;
import com.springmvc.newpackage.result.Result;
import com.springmvc.newpackage.sql.SQLtodo;

public enum CartRole implements SQLtodo {
	//插入到购物车(商品id+用户id+选取数量)
	CART_ISNERT_COMMOID_UID_NUMBERID{

		@Override
		public Object sql(Object... args) {
			String sql ="insert into shoppingcart(sc_id,su_id,s_num) values(?,?,?)";
			return new Result(ExecJDBC.sql((Connection)args[0], sql, (int)args[1],(int)args[2],(int)args[3]));
		}
		
	},
	//删除购物车
	CART_DELETE_CARTID{

		@Override
		public Object sql(Object... args) {
			String sql = "update shoppingcart set s_soft=1 where s_id=?";
			return new Result(ExecJDBC.sql((Connection)args[0], sql, (int)args[1]));
		}
		
	},
	//清空购物车
	CART_DELETEALL_UID{

		@Override
		public Object sql(Object... args) {
			String sql = "update shoppingcart set s_soft=1 where su_id=?";
			return new Result(ExecJDBC.sql((Connection)args[0], sql, (int)args[1]));
		}
		
	},
	//更新购物车(购物车id+用户id+数量)
	CART_UPDATE_CARTID_UID_NUMBERID{

		@Override
		public Object sql(Object... args) {
			String sql = "update shoppingcart set s_num=? where su_id=? and s_id=? and s_soft=0";
			return new Result(ExecJDBC.sql(sql, (Connection)args[0], (int)args[3],(int)args[2],(int)args[1]));
		}
		
	},
	//查询,使用视图
	//通过商品id+用户id获取
	CART_SELECT_COMMOID_UID{

		@Override
		public Object sql(Object... args) {
			String sql = "select s_id,sc_id,su_id,s_num,ct_id,c_name,c_show,c_img,c_cartimg,c_price,c_stock,s_soft,c_soft from cartcommo where sc_id=? and su_id=? and s_soft=0 and c_soft=0";
			return new Result(ExecJDBC.sql(sql, (Connection)args[0], CartCommoPO.class, (int)args[1],(int)args[2]));
		}
		
	},
	//通过用户id获取
	CART_SELECT_UID{

		@Override
		public Object sql(Object... args) {
			String sql = "select s_id,sc_id,su_id,s_num,ct_id,c_name,c_show,c_img,c_cartimg,c_price,c_stock,s_soft,c_soft from cartcommo where su_id=? and s_soft=0 and c_soft=0";
			return new Result(ExecJDBC.sqlByObj(sql, (Connection)args[0], CartCommoPO.class, (int)args[1]));
		}
		
	},
	//通过购物车id获取
	CART_SELECT_CARTID{

		@Override
		public Object sql(Object... args) {
			String sql = "select s_id,sc_id,su_id,s_num,ct_id,c_name,c_show,c_img,c_price,c_stock,s_soft,c_soft from cartcommo where s_id=? and s_soft=0 and c_soft=0";
			return new Result(ExecJDBC.sql(sql, (Connection)args[0], CartCommoPO.class, (int)args[1]));
		}
		
	},
}
