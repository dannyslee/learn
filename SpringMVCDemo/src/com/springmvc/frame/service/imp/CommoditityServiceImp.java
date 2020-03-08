package com.springmvc.frame.service.imp;

import java.sql.Connection;
import java.util.List;

import com.springmvc.frame.dao.CommoditityDAO;
import com.springmvc.frame.dao.imp.CommoditityDAOImp;
import com.springmvc.frame.po.CommoditityPO;
import com.springmvc.frame.service.CommoditityService;
import com.springmvc.frame.util.C3P0Util;

public class CommoditityServiceImp implements CommoditityService {
	
	private long pageCount;
	private int pageNow;
	private int pageN;
	
	private List<CommoditityPO> listCommoditityPO;
	


	@Override
	public List<CommoditityPO> getSearchCommodititesBytid(int t_id,int page) {
		
		//当前页面
		pageNow = page;
		//数据简单处理:得到数据需要的分页
		page = (page-1)*10;
		//pageCount = getSearchCountCommodititesBytid(t_id);
	
		//List<CommoditityPO> listCommoditityPO = null;
		listCommoditityPO = null;
		//创建DAO对象
		CommoditityDAO commoditityDAO = new CommoditityDAOImp();		
		//获取连接
		Connection con = C3P0Util.getConnection();
		//执行注入
		pageCount = commoditityDAO.SearchCountCommodititesBytid(con, t_id);
		listCommoditityPO = commoditityDAO.SearchCommodititesBytid(con, t_id,page);
		
		//计算pageN
		if(pageCount%10==0) {
			pageN = (int)pageCount/10;
		}else {
			pageN = ((int)pageCount)/10+1;////t
		}
		
		//关闭连接
		C3P0Util.close(con);
		return listCommoditityPO;
	}

	@Override
	public long getSearchCountCommodititesBytid(int ct_id) {
		long pageC = -1;
//		// 创建DAO对象
//		CommoditityDAO commoditityDAO = new CommoditityDAOImp();
//		// 获取连接
//		Connection con = C3P0Util.getConnection();
//		// 执行注入
//		pageC = commoditityDAO.SearchCountCommodititesBytid(con, ct_id);
		return pageC;
	}

	public long getPageCount() {
		return pageCount;
	}

	public void setPageCount(long pageCount) {
		this.pageCount = pageCount;
	}

	public int getPageN() {
		return pageN;
	}

	public void setPageN(int pageN) {
		this.pageN = pageN;
	}

	public List<CommoditityPO> getListCommoditityPO() {
		return listCommoditityPO;
	}

	public void setListCommoditityPO(List<CommoditityPO> listCommoditityPO) {
		this.listCommoditityPO = listCommoditityPO;
	}
	
	public int getPageNow() {
		return pageNow;
	}

	public void setPageNow(int pageNow) {
		this.pageNow = pageNow;
	}
}
