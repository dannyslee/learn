package com.springmvc.frame.dao.imp;

import java.sql.Connection;
import java.util.List;

import com.springmvc.frame.dao.TypeOfCommoDAO;
import com.springmvc.frame.po.TypeofCommoPO;
import com.springmvc.frame.util.ExecJDBC;

public class TypeOfCommoDAOImp implements TypeOfCommoDAO {


	@Override
	public List<TypeofCommoPO> searchAllTypeOfCommo(Connection con) {
		String sql = "select t_id,t_typename,t_img,t_typeshow,t_soft from typeofcommo where t_soft=0";
		return ExecJDBC.sql(sql, con, TypeofCommoPO.class);
	}

}
