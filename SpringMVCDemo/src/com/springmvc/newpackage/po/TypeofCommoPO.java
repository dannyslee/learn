package com.springmvc.newpackage.po;

public class TypeofCommoPO {
	//商品类型id
	private int t_id;
	//商品类型名称
	private String t_typename;
	//商品类型图片
	private String t_img;
	//商品类型描述
	private String t_typeshow;
	//商品类型软删除
	private int t_soft;
	public TypeofCommoPO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TypeofCommoPO(int t_id, String t_typename, String t_img, String t_typeshow, int t_soft) {
		super();
		this.t_id = t_id;
		this.t_typename = t_typename;
		this.t_img = t_img;
		this.t_typeshow = t_typeshow;
		this.t_soft = t_soft;
	}
	public int getT_id() {
		return t_id;
	}
	public void setT_id(int t_id) {
		this.t_id = t_id;
	}
	public String getT_typename() {
		return t_typename;
	}
	public void setT_typename(String t_typename) {
		this.t_typename = t_typename;
	}
	public String getT_img() {
		return t_img;
	}
	public void setT_img(String t_img) {
		this.t_img = t_img;
	}
	public String getT_typeshow() {
		return t_typeshow;
	}
	public void setT_typeshow(String t_typeshow) {
		this.t_typeshow = t_typeshow;
	}
	public int getT_soft() {
		return t_soft;
	}
	public void setT_soft(int t_soft) {
		this.t_soft = t_soft;
	}
	@Override
	public String toString() {
		return "TypeofCommo [t_id=" + t_id + ", t_typename=" + t_typename + ", t_img=" + t_img + ", t_typeshow=" + t_typeshow
				+ ", t_soft=" + t_soft + "]";
	}
	
	
}
