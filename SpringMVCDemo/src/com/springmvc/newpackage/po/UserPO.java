package com.springmvc.newpackage.po;

public class UserPO {
	private int u_id;
	private String u_user;
	private String u_password;
	private int ur_id;
	private int u_soft;
	
	public UserPO() {
		super();
	}
	

	public UserPO(int u_id, String u_user,int ur_id, int u_soft) {
		this.u_id = u_id;
		this.u_user = u_user;
		this.ur_id = ur_id;
		this.u_soft = u_soft;
	}
	
	
	
	public UserPO(String u_user, String u_password) {
		this.u_user = u_user;
		this.u_password = u_password;
	}


	public int getU_id() {
		return u_id;
	}
	public void setU_id(int u_id) {
		this.u_id = u_id;
	}
	public String getU_user() {
		return u_user;
	}
	public void setU_user(String u_user) {
		this.u_user = u_user;
	}
//	public String getU_password() {
//		return u_password;
//	}
	public void setU_password(String u_password) {
		this.u_password = u_password;
	}
	public int getUr_id() {
		return ur_id;
	}
	public void setUr_id(int ur_id) {
		this.ur_id = ur_id;
	}
	public int getU_soft() {
		return u_soft;
	}
	public void setU_soft(int u_soft) {
		this.u_soft = u_soft;
	}

	@Override
	public String toString() {
		return "UserPO [u_id=" + u_id + ", u_user=" + u_user + ", u_password=" + u_password + ", ur_id=" + ur_id
				+ ", u_soft=" + u_soft + "]";
	}
	
	
}
