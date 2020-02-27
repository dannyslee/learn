package learn.woniuxy.web.libraryms.po;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Book {
	//id
	private int id;
	//name
	private String name;
	//output
	private String output;
	//price
	private double price;
	//writer
	private String writer;
	//wid
	private int wid;
	//createdate
	private Timestamp createdate;//对时间，重写的get方法
	
	public Book(int id, String name, String output, double price, String writer, int wid, Timestamp createdate) {
		super();
		this.id = id;
		this.name = name;
		this.output = output;
		this.price = price;
		this.writer = writer;
		this.wid = wid;
		this.createdate = createdate;
	}
	public Book() {
		super();
		// TODO Auto-generated constructor stub
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
	public String getOutput() {
		return output;
	}
	public void setOutput(String output) {
		this.output = output;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public int getWid() {
		return wid;
	}
	public void setWid(int wid) {
		this.wid = wid;
	}
	
	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", output=" + output + ", price=" + price + ", writer=" + writer
				+ ", wid=" + wid + ", createdate=" + createdate + "]";
	}
	//重写了get方法
	public String getCreatedate() {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String createdateStr = df.format(createdate);
		return createdateStr;
	}
	public void setCreatedate(Timestamp createdate) {
		this.createdate = createdate;
	}
	
	
	
}
