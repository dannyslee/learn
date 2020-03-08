package com.springmvc.frame.po;

import java.math.BigDecimal;

public class ItemCommoPO {
	private int i_id;
	private int ic_id;
	
	private int io_id;
	
	private int ct_id;
	
	private String c_name;
	
	private BigDecimal c_price;
	
	private int i_num;
	
	private BigDecimal i_price;
	
	private String c_img;
	
	private String c_show;
	
	private int c_stock;
	
	private int i_soft;
	
	private int c_soft;
	
	private int ou_id;

	public ItemCommoPO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ItemCommoPO(int i_id, int ic_id, int io_id, int ct_id, String c_name, BigDecimal c_price, int i_num,
			BigDecimal i_price, String c_img, String c_show, int c_stock, int i_soft, int c_soft, int ou_id) {
		super();
		this.i_id = i_id;
		this.ic_id = ic_id;
		this.io_id = io_id;
		this.ct_id = ct_id;
		this.c_name = c_name;
		this.c_price = c_price;
		this.i_num = i_num;
		this.i_price = i_price;
		this.c_img = c_img;
		this.c_show = c_show;
		this.c_stock = c_stock;
		this.i_soft = i_soft;
		this.c_soft = c_soft;
		this.ou_id = ou_id;
	}

	public int getI_id() {
		return i_id;
	}

	public void setI_id(int i_id) {
		this.i_id = i_id;
	}

	public int getIc_id() {
		return ic_id;
	}

	public void setIc_id(int ic_id) {
		this.ic_id = ic_id;
	}

	public int getIo_id() {
		return io_id;
	}

	public void setIo_id(int io_id) {
		this.io_id = io_id;
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

	public BigDecimal getC_price() {
		return c_price;
	}

	public void setC_price(BigDecimal c_price) {
		this.c_price = c_price;
	}

	public int getI_num() {
		return i_num;
	}

	public void setI_num(int i_num) {
		this.i_num = i_num;
	}

	public BigDecimal getI_price() {
		return i_price;
	}

	public void setI_price(BigDecimal i_price) {
		this.i_price = i_price;
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

	public int getC_stock() {
		return c_stock;
	}

	public void setC_stock(int c_stock) {
		this.c_stock = c_stock;
	}

	public int getI_soft() {
		return i_soft;
	}

	public void setI_soft(int i_soft) {
		this.i_soft = i_soft;
	}

	public int getC_soft() {
		return c_soft;
	}

	public void setC_soft(int c_soft) {
		this.c_soft = c_soft;
	}

	public int getOu_id() {
		return ou_id;
	}

	public void setOu_id(int ou_id) {
		this.ou_id = ou_id;
	}

	@Override
	public String toString() {
		return "ItemCommoPO [i_id=" + i_id + ", ic_id=" + ic_id + ", io_id=" + io_id + ", ct_id=" + ct_id + ", c_name="
				+ c_name + ", c_price=" + c_price + ", i_num=" + i_num + ", i_price=" + i_price + ", c_img=" + c_img
				+ ", c_show=" + c_show + ", c_stock=" + c_stock + ", i_soft=" + i_soft + ", c_soft=" + c_soft
				+ ", ou_id=" + ou_id + "]";
	}
	
	
}
