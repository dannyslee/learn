package com.springmvc.newpackage.sql;

/**
 * 策略模式
 * @author Administrator
 *
 */
public class SQLContext {
	//设置对象
	private SQLtodo sqlTodo;
	//传入对象
	public SQLContext(SQLtodo sqlTodo) {
		this.sqlTodo = sqlTodo;
	}
	//执行对象方法
	public Object execute(Object...args) {
		return sqlTodo.sql(args);
	}
}
