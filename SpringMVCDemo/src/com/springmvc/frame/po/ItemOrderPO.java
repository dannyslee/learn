package com.springmvc.frame.po;

import java.math.BigDecimal;

public class ItemOrderPO {
	//订单项id
	private int i_id;
	//商品id
	private int ic_id;
	//数量
	private int i_num;
	//总额(原类型未double)
	private BigDecimal i_price;
	//订单id
	private int io_id;
	//软删除
	private int i_soft;
	public ItemOrderPO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ItemOrderPO(int i_id, int ic_id, int i_num, BigDecimal i_price, int io_id, int i_soft) {
		super();
		this.i_id = i_id;
		this.ic_id = ic_id;
		this.i_num = i_num;
		this.i_price = i_price;
		this.io_id = io_id;
		this.i_soft = i_soft;
	}
	
	public ItemOrderPO(int ic_id, int i_num, BigDecimal i_price, int io_id) {
		super();

		this.ic_id = ic_id;
		this.i_num = i_num;
		this.i_price = i_price;
		this.io_id = io_id;
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
	public int getIo_id() {
		return io_id;
	}
	public void setIo_id(int io_id) {
		this.io_id = io_id;
	}
	public int getI_soft() {
		return i_soft;
	}
	public void setI_soft(int i_soft) {
		this.i_soft = i_soft;
	}
	@Override
	public String toString() {
		return "ItemOrderPO [i_id=" + i_id + ", ic_id=" + ic_id + ", i_num=" + i_num + ", i_price=" + i_price
				+ ", io_id=" + io_id + ", i_soft=" + i_soft + "]";
	}
	
	
}
