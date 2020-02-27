package learn.woniuxy.web.studentms.po;

public class ClassPO {
	private int c_no;
	private String c_class;
	public ClassPO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ClassPO(int c_no, String c_class) {
		super();
		this.c_no = c_no;
		this.c_class = c_class;
	}
	public int getC_no() {
		return c_no;
	}
	
	public void setC_no(int c_no) {
		this.c_no = c_no;
	}
	public String getC_class() {
		return c_class;
	}
	public void setC_class(String c_class) {
		this.c_class = c_class;
	}
	
	@Override
	public String toString() {
		return "ClassPO [c_no=" + c_no + ", c_class=" + c_class + "]";
	}
	
}
