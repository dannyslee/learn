package com.springmvc.frame.po;

import java.math.BigDecimal;

public class CartCommoPO {
	private int s_id;
	private int sc_id;
	private int su_id;
	private int s_num;
	private int ct_id;
	private String c_name;
	private String c_show;
	private String c_img;
	private String c_cartimg;
	private BigDecimal c_price;
	private int c_stock;
	private int s_soft;
	private int c_soft;
	public CartCommoPO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public CartCommoPO(int s_id, int sc_id, int su_id, int s_num, int ct_id, String c_name, String c_show, String c_img,
			String c_cartimg, BigDecimal c_price, int c_stock, int s_soft, int c_soft) {
		super();
		this.s_id = s_id;
		this.sc_id = sc_id;
		this.su_id = su_id;
		this.s_num = s_num;
		this.ct_id = ct_id;
		this.c_name = c_name;
		this.c_show = c_show;
		this.c_img = c_img;
		this.c_cartimg = c_cartimg;
		this.c_price = c_price;
		this.c_stock = c_stock;
		this.s_soft = s_soft;
		this.c_soft = c_soft;
	}



	public String getC_cartimg() {
		return c_cartimg;
	}



	public void setC_cartimg(String c_cartimg) {
		this.c_cartimg = c_cartimg;
	}



	public CartCommoPO(int s_id, int sc_id, int su_id, int s_num, int ct_id, String c_name, String c_show, String c_img,
			BigDecimal c_price, int c_stock, int s_soft, int c_soft) {
		super();
		this.s_id = s_id;
		this.sc_id = sc_id;
		this.su_id = su_id;
		this.s_num = s_num;
		this.ct_id = ct_id;
		this.c_name = c_name;
		this.c_show = c_show;
		this.c_img = c_img;
		this.c_price = c_price;
		this.c_stock = c_stock;
		this.s_soft = s_soft;
		this.c_soft = c_soft;
	}
	public int getS_id() {
		return s_id;
	}
	public void setS_id(int s_id) {
		this.s_id = s_id;
	}
	public int getSc_id() {
		return sc_id;
	}
	public void setSc_id(int sc_id) {
		this.sc_id = sc_id;
	}
	public int getSu_id() {
		return su_id;
	}
	public void setSu_id(int su_id) {
		this.su_id = su_id;
	}
	public int getS_num() {
		return s_num;
	}
	public void setS_num(int s_num) {
		this.s_num = s_num;
	}
	public int getCt_id() {
		return ct_id;
	}
	public void setCt_id(int ct_id) {
		this.ct_id = ct_id;
	}
	public String getC_name() {
		return c_name;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	public String getC_show() {
		return c_show;
	}
	public void setC_show(String c_show) {
		this.c_show = c_show;
	}
	public String getC_img() {
		return c_img;
	}
	public void setC_img(String c_img) {
		this.c_img = c_img;
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
	public void setC_stock(int s_stock) {
		this.c_stock = s_stock;
	}
	public int getS_soft() {
		return s_soft;
	}
	public void setS_soft(int s_soft) {
		this.s_soft = s_soft;
	}
	public int getC_soft() {
		return c_soft;
	}
	public void setC_soft(int c_soft) {
		this.c_soft = c_soft;
	}
	@Override
	public String toString() {
		return "CartCommoPO [s_id=" + s_id + ", sc_id=" + sc_id + ", su_id=" + su_id + ", s_num=" + s_num + ", ct_id="
				+ ct_id + ", c_name=" + c_name + ", c_show=" + c_show + ", c_img=" + c_img + ", c_price=" + c_price
				+ ", c_stock=" + c_stock + ", s_soft=" + s_soft + ", c_soft=" + c_soft + "]";
	}
	
	
	
}
