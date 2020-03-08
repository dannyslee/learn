package com.springmvc.frame.po;

import java.math.BigDecimal;

public class ShoppingCartPO {

	//用户id
	private int su_id;
	//商品id
	private int sc_id;
	//数量
	private int s_num;
	//软删除
	private int s_soft;
	
	//新增价格（数据里没有，用于session）
	private BigDecimal sesssin_price;
	

	
	public ShoppingCartPO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ShoppingCartPO(int su_id, int sc_id, int s_num,BigDecimal sesssin_price){
		super();
		this.su_id = su_id;
		this.sc_id = sc_id;
		this.s_num = s_num;
		this.sesssin_price = sesssin_price;
	}

	public int getSu_id() {
		return su_id;
	}
	public void setSu_id(int su_id) {
		this.su_id = su_id;
	}
	public int getSc_id() {
		return sc_id;
	}
	public void setSc_id(int sc_id) {
		this.sc_id = sc_id;
	}
	public int getS_num() {
		return s_num;
	}
	public void setS_num(int s_num) {
		this.s_num = s_num;
	}
	public int getS_soft() {
		return s_soft;
	}
	public void setS_soft(int s_soft) {
		this.s_soft = s_soft;
	}
	
	public BigDecimal getSesssin_price() {
		return sesssin_price;
	}
	public void setSesssin_price(BigDecimal sesssin_price) {
		this.sesssin_price = sesssin_price;
	}
	
	@Override
	public String toString() {
		return "ShoppingCartPO [su_id=" + su_id + ", sc_id=" + sc_id + ", s_num=" + s_num
				+ ", s_soft=" + s_soft + "]";
	}
	

}
