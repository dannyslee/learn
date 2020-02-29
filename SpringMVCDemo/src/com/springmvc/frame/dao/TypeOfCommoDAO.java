package com.springmvc.frame.dao;

import java.sql.Connection;
import java.util.List;

import com.springmvc.frame.po.TypeofCommoPO;

public interface TypeOfCommoDAO {

	List<TypeofCommoPO> searchAllTypeOfCommo(Connection con);

}
