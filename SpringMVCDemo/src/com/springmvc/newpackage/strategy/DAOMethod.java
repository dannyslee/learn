package com.springmvc.newpackage.strategy;



public class DAOMethod {
	public Object toDo(DAOTodo daoTodo,Object...args) {
		DAOContext daoContext = new DAOContext(daoTodo);
		return daoContext.execute(args);
	}
}
