package learn.woniuxy.web.studentms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import learn.woniuxy.web.studentms.po.ClassPO;

public class ClassDAO {

	public List<ClassPO> findAll(Connection con) {
		List<ClassPO> classes = new ArrayList<>();
		String sql = "SELECT c_no,c_class from classes";
		PreparedStatement state = null;
		ResultSet set = null;
		try {
			state = con.prepareStatement(sql);
			set = state.executeQuery();
			while(set.next()) {
				int s_no = set.getInt("c_no");
				String s_class = set.getString("c_class");
				classes.add(new ClassPO(s_no,s_class));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return classes;
	}

}
