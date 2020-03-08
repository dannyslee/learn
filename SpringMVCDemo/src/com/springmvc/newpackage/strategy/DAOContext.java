package com.springmvc.newpackage.strategy;


public class DAOContext {
	//设置对象
		private DAOTodo daoTodo;
		//传入对象
		public DAOContext(DAOTodo daoTodo) {
			this.daoTodo = daoTodo;
		}
		//执行对象方法
		public Object execute(Object...args) {
			return daoTodo.todo(args);
		}
}
