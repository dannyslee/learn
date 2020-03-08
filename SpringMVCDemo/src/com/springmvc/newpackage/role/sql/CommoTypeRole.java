package com.springmvc.newpackage.role.sql;

import java.sql.Connection;

import com.springmvc.frame.po.TypeofCommoPO;
import com.springmvc.frame.util.ExecJDBC;
import com.springmvc.newpackage.result.Result;
import com.springmvc.newpackage.sql.SQLtodo;

public enum CommoTypeRole implements SQLtodo {
	//获取全部类型，无参
	COMMOTYPE_SELECT_ALL{

		@Override
		public Object sql(Object... args) {
			String sql = "select t_id,t_typename,t_img,t_typeshow,t_soft from typeofcommo where t_soft=0";
			return new Result(ExecJDBC.sql(sql, (Connection)args[0], TypeofCommoPO.class));
		}
		
	}
	
}
