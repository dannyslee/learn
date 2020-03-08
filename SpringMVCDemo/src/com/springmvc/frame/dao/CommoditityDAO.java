package com.springmvc.frame.dao;

import java.sql.Connection;
import java.util.List;

import com.springmvc.frame.po.CommoditityPO;

public interface CommoditityDAO {
	//通过商品类型id，获得商品
	List<CommoditityPO> SearchCommodititesBytid(Connection con,int ct_id,int page);
	
	//List<CommoditityPO> SearchCommodititesBytid(Connection con,int ct_id,int page);
	CommoditityPO SearchCommodititesBycid(Connection con,int c_id);
	//获取商品总数
	long SearchCountCommodititesBytid(Connection con,int ct_id);
	
	
}
