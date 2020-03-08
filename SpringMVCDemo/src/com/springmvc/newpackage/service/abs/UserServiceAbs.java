package com.springmvc.newpackage.service.abs;



import com.springmvc.newpackage.result.Result;
import com.springmvc.newpackage.role.daorole.UserDAORole;
import com.springmvc.newpackage.service.intface.ServiceInsertInterface;
import com.springmvc.newpackage.service.intface.ServiceSelectInterface;
import com.springmvc.newpackage.strategy.DAOMethod;

public abstract class UserServiceAbs implements ServiceSelectInterface,ServiceInsertInterface {

	@Override
	public Object getSelect(String className, Object...args) {
		Object DAOtodo = new DAOMethod().toDo(UserDAORole.valueOf(className), args);
		return  DAOtodo ;
	}
	
	
	@Override
	public Object getInsert(String roleName, Object... args) {
		Object DAOtodo = new DAOMethod().toDo(UserDAORole.valueOf(roleName), args);
		return DAOtodo;
	}


	// 获取dao的SearchUser的结果，处理后，交给Controller层
	public abstract Result getSearchLoginUser(String user, String password) ;

	
	// 获取注册用户判断的结果，处理后交给Controller层
	public abstract Result getSearchRegiterUser(String user);

	public abstract Result getInsertUser(String user, String password);
}
