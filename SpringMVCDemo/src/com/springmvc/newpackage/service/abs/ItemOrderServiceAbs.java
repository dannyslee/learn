package com.springmvc.newpackage.service.abs;



import com.springmvc.newpackage.result.Result;
import com.springmvc.newpackage.role.daorole.ItemOrderDAORole;
import com.springmvc.newpackage.service.intface.ServiceSelectInterface;
import com.springmvc.newpackage.strategy.DAOMethod;

public abstract class ItemOrderServiceAbs implements ServiceSelectInterface{

	@Override
	public Object getSelect(String className, Object... args) {
		return new DAOMethod().toDo(ItemOrderDAORole.valueOf(className), args);
	}
	

		
	public abstract Result getSearchOrderItemCommo(int ou_id, int o_id);
	
}
