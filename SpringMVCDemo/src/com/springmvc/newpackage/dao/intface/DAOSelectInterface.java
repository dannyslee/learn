package com.springmvc.newpackage.dao.intface;

import java.sql.Connection;

import com.springmvc.newpackage.result.Result;

public interface DAOSelectInterface {
	//select
	Object select(String roleName,Object...args);
	
//	//insert
//	Object insert(String roleName,Object...args);
//	
//	//delete
//	Object delete(String roleName,Object...args);
//	
//	//update
//	Object update(String roleName,Object...args);


	
}
