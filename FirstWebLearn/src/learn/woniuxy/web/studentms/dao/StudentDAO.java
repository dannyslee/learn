package learn.woniuxy.web.studentms.dao;

import java.sql.Connection;

import learn.woniuxy.web.studentms.util.ExecJDBC;

public class StudentDAO {

	public boolean updateById(int s_id, String s_name, String s_sex, int s_age, String s_phone,
			int s_no) {
		String sql = "update students set s_name=?,s_sex=?,s_age=?,s_phone=?,sc_no=? where s_id=?";
		int sc_no = s_no;
		boolean flag = new ExecJDBC().sql(sql, s_name,s_sex,s_age,s_phone,sc_no,s_id);
		if(flag) {
			return true;
		}
		return false;
	}

	public boolean insert(String s_name, String s_sex, int s_age, String s_phone, int s_no) {
		String sql = "insert into students(s_name,s_age,s_sex,s_phone,sc_no) values(?,?,?,?,?)";
		int sc_no = s_no;
		boolean flag = new ExecJDBC().sql(sql, s_name,s_age,s_sex,s_phone,sc_no);
		if(flag) {
			return true;
		}
		return false;
	}

	public boolean delete(int ss_id) {
		String sql = "delete from students where s_id=?";
		boolean flag = new ExecJDBC().sql(sql, ss_id);
		if(flag) {
			return true;
		}
		return false;
	}
	
	

}
