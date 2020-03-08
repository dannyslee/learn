package com.springmvc.newpackage.service.abs;


import com.springmvc.newpackage.result.Result;
import com.springmvc.newpackage.role.daorole.CommoTypeDAORole;
import com.springmvc.newpackage.service.intface.ServiceSelectInterface;
import com.springmvc.newpackage.strategy.DAOMethod;

public abstract class CommoTypeServiceAbs implements ServiceSelectInterface{

	@Override
	public Object getSelect(String className, Object... args) {
		Object todo = new DAOMethod().toDo(CommoTypeDAORole.valueOf(className), args);
		return todo;
	}
	
	//获取全部商品类型
	public abstract Result getSearchAllTypeOfCommo();

	
}
