package com.springmvc.newpackage.role.sql;

import java.sql.Connection;

import com.springmvc.frame.util.ExecJDBC;
import com.springmvc.newpackage.po.UserPO;
import com.springmvc.newpackage.result.Result;
import com.springmvc.newpackage.sql.SQLtodo;

//import com.springmvc.newpackage.sql.SQLtodo;

public enum UserRole implements SQLtodo{
	//通过用户名和密码查询
	USER_SELECT_USER_P{
		@Override
		public Result sql(Object... args) {
			String sql =  "select u_id,u_user,u_password,ur_id,u_soft from `user` where u_user= ? and u_password= ? and u_soft=0";		
			return new Result(ExecJDBC.sql(sql, (Connection)args[0], UserPO.class, args[1],args[2]));
		}
	},
	
	//通过用户名查询
	USER_SELECT_USER{
		@Override
		public Result sql(Object... args) {
			String sql = "select u_id,u_user,u_password,ur_id,u_soft from `user` where u_user=? and u_soft=0";
			return new Result(ExecJDBC.sql(sql, (Connection)args[0], UserPO.class, args[1]));
		}
	},
	
	//通过用户ID查询
	USER_SELECT_UID{
		@Override
		public Result sql(Object... args) {
			String sql = "select u_id,u_user,u_password,ur_id,u_soft from `user` where u_id=? and u_soft=0";
			return new Result(ExecJDBC.sql(sql, (Connection)args[0], UserPO.class,args[1]));
		}
	},
	
	//添加用户名与密码
	USER_INSERT_USER_P{
		@Override
		public Object sql(Object... args) {		
			String sql = "insert into `user`(u_user,u_password,ur_id) values(?,?,1)";
			return new Result(ExecJDBC.sql(sql, (Connection)args[0], UserPO.class, args[1]));
		}
	},

	
	
}
