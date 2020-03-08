package com.springmvc.newpackage.service.abs;



import com.springmvc.newpackage.result.Result;
import com.springmvc.newpackage.role.daorole.CommoDAORole;
import com.springmvc.newpackage.service.intface.ServiceSelectInterface;
import com.springmvc.newpackage.service.intface.ServiceUpdateInterface;
import com.springmvc.newpackage.strategy.DAOMethod;

public abstract class CommoServiceAbs implements ServiceSelectInterface,ServiceUpdateInterface{

	@Override
	public Object getSelect(String className, Object... args) {	
		return new DAOMethod().toDo(CommoDAORole.valueOf(className), args);
	}
	
	
	
	@Override
	public Object getUpdate(String roleName, Object... args) {
		return new DAOMethod().toDo(CommoDAORole.valueOf(roleName), args);
	}



	//通过商品类型的id，获取所有的该类型下的商品
	public abstract	Result getSearchCommodititesBytid(int t_id,int page);
		
	//通过商品id，获取到所有该类型下商品总数
	public	Result getSearchCountCommodititesBytid(int ct_id) { return null; };
	
	//库存更改
	public abstract Result getUpdateStockByid(int number,int sc_id);



	
}
