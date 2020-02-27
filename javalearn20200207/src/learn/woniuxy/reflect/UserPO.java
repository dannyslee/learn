package learn.woniuxy.reflect;

import java.io.Serializable;

public class UserPO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String pass;
	public UserPO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserPO(int id, String name, String pass) {
		super();
		this.id = id;
		this.name = name;
		this.pass = pass;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	@Override
	public String toString() {
		return "UserPO [id=" + id + ", name=" + name + ", pass=" + pass + "]";
	}
	
	
	
	
}
