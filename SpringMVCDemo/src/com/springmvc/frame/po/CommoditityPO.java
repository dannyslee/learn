package com.springmvc.frame.po;

import java.math.BigDecimal;

public class CommoditityPO {
	//商品id
	private int c_id;
	//商品名称
	private String c_name;
	//商品图片
	private String c_img;
	//商品描述
	private String c_show;
	//商品价格
	private BigDecimal c_price;
	//商品库存
	private int c_stock;
	//商品类型
	private int ct_id;
	//软删除
	private int c_soft;
	public CommoditityPO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CommoditityPO(int c_id, String c_name, String c_img, String c_show, BigDecimal c_price, int c_stock,
			int ct_id, int c_soft) {
		super();
		this.c_id = c_id;
		this.c_name = c_name;
		this.c_img = c_img;
		this.c_show = c_show;
		this.c_price = c_price;
		this.c_stock = c_stock;
		this.ct_id = ct_id;
		this.c_soft = c_soft;
	}
	public int getC_id() {
		return c_id;
	}
	public void setC_id(int c_id) {
		this.c_id = c_id;
	}
	public String getC_name() {
		return c_name;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	public String getC_img() {
		return c_img;
	}
	public void setC_img(String c_img) {
		this.c_img = c_img;
	}
	public String getC_show() {
		return c_show;
	}
	public void setC_show(String c_show) {
		this.c_show = c_show;
	}
	public BigDecimal getC_price() {
		return c_price;
	}
	public void setC_price(BigDecimal c_price) {
		this.c_price = c_price;
	}
	public int getC_stock() {
		return c_stock;
	}
	public void setC_stock(int c_stock) {
		this.c_stock = c_stock;
	}
	public int getCt_id() {
		return ct_id;
	}
	public void setCt_id(int ct_id) {
		this.ct_id = ct_id;
	}
	public int getC_soft() {
		return c_soft;
	}
	public void setC_soft(int c_soft) {
		this.c_soft = c_soft;
	}
	@Override
	public String toString() {
		return "CommoditityPO [c_id=" + c_id + ", c_name=" + c_name + ", c_img=" + c_img + ", c_show=" + c_show
				+ ", c_price=" + c_price + ", c_stock=" + c_stock + ", ct_id=" + ct_id + ", c_soft=" + c_soft + "]";
	}
	
	
	
	
}
