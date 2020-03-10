package com.springmvc.newpackage.service;

import java.sql.Connection;

import com.springmvc.frame.util.C3P0Util;
import com.springmvc.newpackage.result.Result;
import com.springmvc.newpackage.service.abs.CommoServiceAbs;
import com.springmvc.newpackage.service.intface.Service;

public class CommoServiceImp extends CommoServiceAbs implements Service {

	@Override
	public Result getSearchCommodititesBytid(int t_id, int page) {
		Connection con = C3P0Util.getConnection();
		//当前页面
		int pageNow = page;
		page= (page-1)*10;
		//单类商品总数
		long pageCount = ((Result)getSelect("COMMODAO_COUNT_SELECT_TYPEID",con,t_id)).getCount();
		//分页设置
		int splitPage; 
		if(pageCount%10==0) {
			if(pageCount/10==0) {
				splitPage=1;
			}else {
				splitPage = (int)pageCount/10;
			}
		}else {
			splitPage = ((int)pageCount)/10+1;////t
		}
		//获取当前页下的所有商品信息
		Result selectPO = (Result)getSelect("COMMODAO_SELECT_TYPEID_PAGEID",con,t_id,page);
		//将所有结果存入返回值对象		
		Result select = new Result(pageNow,splitPage,pageCount,selectPO);
		C3P0Util.close(con);
		return select;
	}
	
	
	public Result getSearchCommodititesBytidDesc(int t_id, int page) {
		Connection con = C3P0Util.getConnection();
		//当前页面
		int pageNow = page;
		page= (page-1)*10;
		//单类商品总数
		long pageCount = ((Result)getSelect("COMMODAO_COUNT_SELECT_TYPEID",con,t_id)).getCount();
		//分页设置
		int splitPage; 
		if(pageCount%10==0) {
			if(pageCount/10==0) {
				splitPage=1;
			}else {
				splitPage = (int)pageCount/10;
			}
		}else {
			splitPage = ((int)pageCount)/10+1;////t
		}
		//获取当前页下的所有商品信息
		Result selectPO = (Result)getSelect("COMMODAO_SELECT_TYPEID_PAGEID_DESC",con,t_id,page);
		//将所有结果存入返回值对象		
		Result select = new Result(pageNow,splitPage,pageCount,selectPO);
		C3P0Util.close(con);
		return select;
	}

	
	public Result getSearchCommoditityBycid(int c_id) {
		Connection con = C3P0Util.getConnection();
		Result selectPO =(Result)getSelect("COMMODAO_SELECT_CID",con,c_id);
		C3P0Util.close(con);
		return selectPO;
	}

	@Override
	public Result getUpdateStockByid(int number,int sc_id) {
		Connection con = C3P0Util.getConnection();
		Result update = (Result)getUpdate("COMMODAO_UPDATE_STOCKID_COMMOID",con,number,sc_id);
		C3P0Util.close(con);
		return update;
	}

	
	
}
