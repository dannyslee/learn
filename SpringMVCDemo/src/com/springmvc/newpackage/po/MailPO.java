package com.springmvc.newpackage.po;

public class MailPO {
	//mailid
	private int m_id;
	//收件人姓名
	private String m_name;
	//收件人电话
	private String m_tel;
	//收件人地址
	private String m_address;
	//用户id
	private int mu_id;
	//软删除
	private int m_soft;
	public MailPO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public MailPO(String m_name, String m_tel, String m_address, int mu_id) {
		super();
	
		this.m_name = m_name;
		this.m_tel = m_tel;
		this.m_address = m_address;
		this.mu_id = mu_id;
	
	}
	
	public MailPO(int m_id, String m_name, String m_tel, String m_address, int mu_id, int m_soft) {
		super();
		this.m_id = m_id;
		this.m_name = m_name;
		this.m_tel = m_tel;
		this.m_address = m_address;
		this.mu_id = mu_id;
		this.m_soft = m_soft;
	}
	public int getM_id() {
		return m_id;
	}
	public void setM_id(int m_id) {
		this.m_id = m_id;
	}
	public String getM_name() {
		return m_name;
	}
	public void setM_name(String m_name) {
		this.m_name = m_name;
	}
	public String getM_tel() {
		return m_tel;
	}
	public void setM_tel(String m_tel) {
		this.m_tel = m_tel;
	}
	public String getM_address() {
		return m_address;
	}
	public void setM_address(String m_address) {
		this.m_address = m_address;
	}
	public int getMu_id() {
		return mu_id;
	}
	public void setMu_id(int mu_id) {
		this.mu_id = mu_id;
	}
	public int getM_soft() {
		return m_soft;
	}
	public void setM_soft(int m_soft) {
		this.m_soft = m_soft;
	}
	@Override
	public String toString() {
		return "MailPO [m_id=" + m_id + ", m_name=" + m_name + ", m_tel=" + m_tel + ", m_address=" + m_address
				+ ", mu_id=" + mu_id + ", m_soft=" + m_soft + "]";
	}
	
	
}
