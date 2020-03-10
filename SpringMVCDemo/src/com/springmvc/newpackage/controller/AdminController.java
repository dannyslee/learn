package com.springmvc.newpackage.controller;

import java.math.BigDecimal;

import com.springmvc.newpackage.result.Result;
import com.springmvc.newpackage.service.AdminService;
import com.woniuxy.springmvc.annotation.framework.Controller;
import com.woniuxy.springmvc.annotation.handlermapping.RequestMapping;
import com.woniuxy.springmvc.annotation.handlermapping.ResponseBody;

@Controller
@RequestMapping("/adm")
public class AdminController {
	
	@RequestMapping("/showallcommo")
	@ResponseBody
	public Result selectAllCommo() {
			
		return new AdminService().getSelectAllCommo();
		
	}
	
	@RequestMapping("/showcommobyname")
	@ResponseBody
	public Result selectCommoBycname() {
		return null;
		
	}
	
	@RequestMapping("/updatecommo")
	@ResponseBody
	public Result updateCommoStockBycid(String c_name,String c_img, String c_show,String c_price,int c_stock,int c_id) {
		
		return new AdminService().getUpdateCommoStockBycid(c_name,c_img,c_show,new BigDecimal(c_price),c_stock, c_id);
		
	}
	
	@RequestMapping("/delcommo")
	@ResponseBody
	public Result deleteCommoBycid(int c_id) {
		return new AdminService().getDeleteCommoBycid(c_id);
		
	}
	
	@RequestMapping("/insertcommo")
	@ResponseBody
	public Result insertCommoAll(String c_name, String c_img, String c_show,String c_price, int c_stock, int ct_id) {
		return new AdminService().getInsertCommoAll(c_name, c_img, "暂时无", c_show, new BigDecimal(c_price), c_stock, ct_id);
		
	}
	
	@RequestMapping("/showallorder")
	@ResponseBody
	public Result selectAllOrder() {
		return null;
		
		
	}
	
	@RequestMapping("/showorderbystatus")
	@ResponseBody
	public Result selectOrderByStatus() {
		return null;
		
	}
	
	@RequestMapping("/updatestatus")
	@ResponseBody
	public Result updateOrderStatus() {
		return null;
		
	}
	
	
	//商品类型相关
	
	//删除
	@ResponseBody
	@RequestMapping("/deltype")
	public Result deleteType(int t_id) {
		return new AdminService().getDeleteTypeBytid(t_id);
	}
	
	
	//添加
	@ResponseBody
	@RequestMapping("/inserttype")
	public Result insertType(String t_typename, String t_img,String t_typeshow) {
		
		return new AdminService().getInsertType(t_typename, t_img, t_typeshow);
		
	}
	
	//修改
	@RequestMapping("/updatetype")
	@ResponseBody
	public Result updateType(String t_typename, String t_img,String t_typeshow,int t_id) {
		return new AdminService().getUpdateTypeBytid(t_typename, t_img, t_typeshow, t_id);		
	}
	
	//通过单个tid获取内容
	@RequestMapping("/selecttypebytid")
	@ResponseBody
	public Result selectTypeBytid(int t_id) {
		
		return new AdminService().getSelectTypeBytid(t_id);
	}
}
