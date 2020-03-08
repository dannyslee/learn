package com.springmvc.newpackage.sql;

public class SQLMethod {
	public Object SQL(SQLtodo sqlTodo,Object...args) {
		SQLContext sqlContext = new SQLContext(sqlTodo);
		return sqlContext.execute(args);
	}
}
