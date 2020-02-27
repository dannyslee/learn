package learn.woniuxy.web.studentms.service;

import java.sql.Connection;
import java.util.List;

import learn.woniuxy.web.studentms.dao.ClassDAO;
import learn.woniuxy.web.studentms.po.ClassPO;
import learn.woniuxy.web.studentms.util.JDBCUtil;

public class ClassService {
	public List<ClassPO> showAll(){
		JDBCUtil util = new JDBCUtil();
		Connection con = util.getConnection("student");
		List<ClassPO> classes = new ClassDAO().findAll(con);
		util.close(con);
		return classes;
	}
}
