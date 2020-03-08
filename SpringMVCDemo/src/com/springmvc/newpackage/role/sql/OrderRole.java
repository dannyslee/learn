package com.springmvc.newpackage.role.sql;

import java.sql.Connection;
import java.sql.Timestamp;

import com.springmvc.frame.po.ItemCommoPO;
import com.springmvc.frame.util.ExecJDBC;
import com.springmvc.frame.util.TimeUtil2;
import com.springmvc.newpackage.po.OrderPO;
import com.springmvc.newpackage.result.Result;
import com.springmvc.newpackage.sql.SQLtodo;

public enum OrderRole implements SQLtodo {
   //保存订单
	ORDER_INSERT_ORDERPO{

		@Override
		public Object sql(Object... args) {
			String sql = "insert into `order`(o_no,o_creattime,o_status,ou_id) values(?,?,?,?)";
			//对args[1]作处理
			 Timestamp strToSqlDate = TimeUtil2.strToSqlDate(((OrderPO)args[1]).getO_creattime());
			return new Result(ExecJDBC.sql((Connection)args[0], sql, ((OrderPO)args[1]).getO_no(),strToSqlDate,0,((OrderPO)args[1]).getOu_id()));
		}
		
	},
	
	//查询全部订单
	ORDER_SELECT_ALL{

		@Override
		public Object sql(Object... args) {
			
			return null;
		}
		
	},
	
	//修改订单
	ORDER_UPDATE_OID_OSTATUS{

		@Override
		public Object sql(Object... args) {
			// TODO Auto-generated method stub
			return null;
		}
		
	},
	
	//根据用户编号查询订单信息
	ORDER_SELECT_UID{

		@Override
		public Object sql(Object... args) {
			String sql="select o_id,o_no,o_payid,o_creattime,o_updatetime,o_status,ou_id,o_soft from `order` where ou_id=? and o_soft=0";
			return new Result(ExecJDBC.sqlByObj(sql,(Connection)args[0], OrderPO.class, (int)args[1]));
		}
		
	}
	
	
}
