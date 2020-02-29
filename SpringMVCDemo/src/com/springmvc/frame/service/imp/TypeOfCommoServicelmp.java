package com.springmvc.frame.service.imp;

import java.sql.Connection;
import java.util.List;

import com.springmvc.frame.dao.TypeOfCommoDAO;
import com.springmvc.frame.dao.imp.TypeOfCommoDAOImp;
import com.springmvc.frame.po.TypeofCommoPO;
import com.springmvc.frame.service.TypeOfCommoService;
import com.springmvc.frame.util.C3P0Util;

public class TypeOfCommoServicelmp implements TypeOfCommoService {

	@Override
	public List<TypeofCommoPO> getSearchAllTypeOfCommo() {
		List<TypeofCommoPO> listTypeofCommoPO = null;
		// 得到一个TypeOfCommoDAOImp执行searchAllTypeOfCommo方法后的结果
		TypeOfCommoDAO typeOfCommoDAO = new TypeOfCommoDAOImp();
		Connection con = C3P0Util.getConnection();
		listTypeofCommoPO = typeOfCommoDAO.searchAllTypeOfCommo(con);
		C3P0Util.close(con);
		return listTypeofCommoPO;
	}


}
