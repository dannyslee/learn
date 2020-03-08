package com.springmvc.newpackage.service.abs;

import com.springmvc.newpackage.po.MailPO;
import com.springmvc.newpackage.result.Result;
import com.springmvc.newpackage.role.daorole.MailDAORole;
import com.springmvc.newpackage.service.intface.ServiceInsertInterface;
import com.springmvc.newpackage.service.intface.ServiceSelectInterface;
import com.springmvc.newpackage.strategy.DAOMethod;

public abstract class MailServiceAbs implements ServiceSelectInterface,ServiceInsertInterface {

	@Override
	public Object getInsert(String roleName, Object... args) {
		
		return new DAOMethod().toDo(MailDAORole.valueOf(roleName), args);
	}

	@Override
	public Object getSelect(String className, Object... args) {
		
		return new DAOMethod().toDo(MailDAORole.valueOf(className), args);
	}
	
	//获取添加结果
	public abstract Result getInsertMail(MailPO mail);
	//获取产看结果
	public abstract Result getSearchMail(int mu_id);
}
