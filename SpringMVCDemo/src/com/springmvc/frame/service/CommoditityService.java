package com.springmvc.frame.service;

import java.sql.Connection;
import java.util.List;

import com.springmvc.frame.po.CommoditityPO;

public interface CommoditityService {
	//通过商品类型的id，获取所有的该类型下的商品
	List<CommoditityPO> getSearchCommodititesBytid(int t_id,int page);
	
	//通过商品id，获取到所有该类型下商品总数
	long getSearchCountCommodititesBytid(int ct_id);

}
