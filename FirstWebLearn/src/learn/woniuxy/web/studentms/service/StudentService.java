package learn.woniuxy.web.studentms.service;

import java.sql.Connection;
import java.util.List;

import learn.woniuxy.web.studentms.dao.StudentDAO;
import learn.woniuxy.web.studentms.dao.View_AllStudentsDAO;
import learn.woniuxy.web.studentms.po.View_AllStudentsPO;
import learn.woniuxy.web.studentms.util.JDBCUtil;

public class StudentService {
	public List<View_AllStudentsPO> showAllStudents(){
		List<View_AllStudentsPO> stus = null;
		//获取数据连接对象
		JDBCUtil util = new JDBCUtil();
		Connection con = util.getConnection("student");
		stus= new View_AllStudentsDAO().findAllStudents(con);
		util.close(con);
		return stus;
	}

	public String update(int s_id, String s_name, String s_sex, int s_age, String s_phone, int s_no,
			String s_class) {
		String res = "更新失败";
		System.out.println(s_id+s_name+s_sex+s_age+s_phone);
		//Connection con = new JDBCUtil().getConnection("student");
		boolean state = new StudentDAO().updateById(s_id,s_name,s_sex,s_age,s_phone,s_no);
		if(state) {
			res="更新成功";
		}
		return res;
	}

	public String insert(String s_name, String s_sex, int s_age, String s_phone, int s_no) {
		String res = "插入失败！";
		boolean re = new StudentDAO().insert(s_name,s_sex,s_age,s_phone,s_no);
		if(re) {
			res="插入成功";
		}
		return res;
	}

	public String delete(int ss_id) {
		String res = "删除失败";
		boolean re = new StudentDAO().delete(ss_id);
		if(re) {
			res="删除成功";
		}
		return res;
	}
}
