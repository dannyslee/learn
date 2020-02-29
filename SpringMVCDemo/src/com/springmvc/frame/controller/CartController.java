package com.springmvc.frame.controller;

import com.springmvc.frame.po.CommoditityPO;
import com.springmvc.frame.po.ShoppingCartPO;
import com.woniuxy.springmvc.annotation.handlermapping.RequestMapping;
import com.woniuxy.springmvc.annotation.handlermapping.ResponseBody;

@RequestMapping("/cart")
public class CartController {
	
	//添加到购物车。实际上是从订单页添加的（主要难点，是能添加，但不跳转）
	@ResponseBody
	@RequestMapping("/addcart")
	ShoppingCartPO addCart(CommoditityPO commo) {
		return null;
		
	}
	
	//单项商品移除购物车
	//移除本质是软删除
	boolean removeCart(int uid,int cid){
		
		
		return false;
	}
	//清空购物车（删除所有）
	boolean clearCart() {
		return false;
		
	}
	//修改商品数量
	ShoppingCartPO updateCountCart(int id,int count) {
		return null;
		
	}
	
	
}
