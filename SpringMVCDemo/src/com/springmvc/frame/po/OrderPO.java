package com.springmvc.frame.po;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class OrderPO {
	//订单id
	private int o_id;
	//订单号
	private String o_no;
	//订单支付交易号
	private String o_payid;
	//获取时间时，需要对时间进行转化
	//订单创建时间 
	private Timestamp o_creattime;
	//订单更新/修改时间
	//使用自写的工具类进行时间转化：Timestamp createdate = TimeUtil.dateToSqlDate(new Date());
	private Timestamp o_updatetime;
	//订单状态（int）
	private int o_status;
	//用户id
	private int ou_id;
	//软删除
	private int o_soft;
	
	
	public OrderPO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderPO(int o_id, String o_no, String o_payid, Timestamp o_creattime, Timestamp o_updatetime, int o_status,
			int ou_id, int o_soft) {
		super();
		this.o_id = o_id;
		this.o_no = o_no;
		this.o_payid = o_payid;
		this.o_creattime = o_creattime;
		this.o_updatetime = o_updatetime;
		this.o_status = o_status;
		this.ou_id = ou_id;
		this.o_soft = o_soft;
	}
	
	public OrderPO(String o_no, String o_payid, Timestamp o_creattime, Timestamp o_updatetime, int o_status,
			int ou_id) {
		super();
		this.o_no = o_no;
		this.o_payid = o_payid;
		this.o_creattime = o_creattime;
		this.o_updatetime = o_updatetime;
		this.o_status = o_status;
		this.ou_id = ou_id;
	}
	
	
	public OrderPO(String o_no,Timestamp o_creattime,int o_status, int ou_id) {
		this.o_no = o_no;
		this.o_creattime = o_creattime;
		this.o_status = o_status;
		this.ou_id = ou_id;
	}

	public int getO_id() {
		return o_id;
	}
	public void setO_id(int o_id) {
		this.o_id = o_id;
	}
	public String getO_no() {
		return o_no;
	}
	public void setO_no(String o_no) {
		this.o_no = o_no;
	}
	public String getO_payid() {
		return o_payid;
	}
	public void setO_payid(String o_payid) {
		this.o_payid = o_payid;
	}

//	public Timestamp getO_creattime() {
//		
//		return o_creattime;
//	}
	public void setO_creattime(Timestamp o_creattime) {
		this.o_creattime = o_creattime;
	}
	
//	public Timestamp getO_updatetime() {
//		return o_updatetime;
//	}
	public void setO_updatetime(Timestamp o_updatetime) {
		this.o_updatetime = o_updatetime;
	}
	public int getO_status() {
		return o_status;
	}
	public void setO_status(int o_status) {
		this.o_status = o_status;
	}
	public int getOu_id() {
		return ou_id;
	}
	public void setOu_id(int ou_id) {
		this.ou_id = ou_id;
	}
	public int getO_soft() {
		return o_soft;
	}
	public void setO_soft(int o_soft) {
		this.o_soft = o_soft;
	}
	
	@Override
	public String toString() {
		return "OrderPO [o_id=" + o_id + ", o_no=" + o_no + ", o_payid=" + o_payid + ", o_creattime=" + o_creattime
				+ ", o_updatetime=" + o_updatetime + ", o_status=" + o_status + ", ou_id=" + ou_id + ", o_soft="
				+ o_soft + "]";
	}
	
	//重写getTime，让其变为字符串型
	public String getO_creattime() {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String  o_creattimeStr = df.format(o_creattime);
		return o_creattimeStr;
	}
	
	public String getO_updatetime() {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String  o_updatetimeStr = df.format(o_updatetime);
		return o_updatetimeStr;
	}
	
	
}
