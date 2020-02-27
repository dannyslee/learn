package learn.woniuxy.web.libraryms.po;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BookPO {
	//编号
	private int id;
	//书名
	private String name;
	//出版社
	private String output;
	//价格
	private double price;
	//作者
	private String writer;
	//作者编号
	private int wid;
	
	public int getWid() {
		return wid;
	}

	public void setW_id(int wid) {
		this.wid = wid;
	}

	//入库时间(数据库类型)
	private Timestamp createdate;//Timestamp 是数据库日期类型
	//入库时间(String类型)
	private String createdateStr;
	
	public BookPO() {
		super();
		// TODO Auto-generated constructor stub
	}



	public BookPO(int id, String name, String output, double price, String writer, int wid, String createdateStr) {
		super();
		this.id = id;
		this.name = name;
		this.output = output;
		this.price = price;
		this.writer = writer;
		this.wid = wid;
		this.createdateStr = createdateStr;
	}

	public BookPO(int id, String name, String output, double price, String writer, int wid, Timestamp createdate) {
		super();
		this.id = id;
		this.name = name;
		this.output = output;
		this.price = price;
		this.writer = writer;
		this.wid = wid;
		this.createdate = createdate;
	}
	
	

	public BookPO(int id, String name, String output, double price, String writer, Timestamp createdate) {
		super();
		this.id = id;
		this.name = name;
		this.output = output;
		this.price = price;
		this.writer = writer;
		this.createdate = createdate;
	}
	
	

	public BookPO(int id, String name, String output, double price, String writer, String createdateStr) {
		super();
		this.id = id;
		this.name = name;
		this.output = output;
		this.price = price;
		this.writer = writer;
		this.createdateStr = createdateStr;
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

	public String getCreatedate() {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		this.createdateStr = df.format(createdate);
		return createdateStr;
	}

	public void setCreatedate(Timestamp createdate) {
		this.createdate = createdate;
	}
	
	//字符串类型 转 数据库时间型
	public void setCreatedate(String createdateStr) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = null;
		
		try {
			date = df.parse(createdateStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.createdate = new Timestamp(date.getTime());
	}
	

	public String getCreatedateStr() {
		return createdateStr;
	}
	
	//数据库类型 转 字符串类型
	public void setCreatedateStr(Timestamp createdate) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		this.createdateStr = df.format(createdate);
	}
	
	//原类型
	public void setCreatedateStr(String createdateStr) {
		this.createdateStr =createdateStr;
	}

	
	
	
	
	
}
