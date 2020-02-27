package learn.woniuxy.web.studentms.po;

public class View_AllStudentsPO {
	
	/**
	 * 失血模型：查询学生信息
	 */
	private int s_id;
	private int s_no;
	private int s_age;
	private String s_name;
	private String s_sex;
	private String s_class;
	
	
	public View_AllStudentsPO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public View_AllStudentsPO(int s_id, int s_no, int s_age, String s_name, String s_sex, String s_class,
			String s_phone) {
		super();
		this.s_id = s_id;
		this.s_no = s_no;
		this.s_age = s_age;
		this.s_name = s_name;
		this.s_sex = s_sex;
		this.s_class = s_class;
		this.s_phone = s_phone;
	}
	
	

	public int getS_id() {
		return s_id;
	}
	public void setS_id(int s_id) {
		this.s_id = s_id;
	}
	public int getS_no() {
		return s_no;
	}
	public void setS_no(int s_no) {
		this.s_no = s_no;
	}
	public int getS_age() {
		return s_age;
	}
	public void setS_age(int s_age) {
		this.s_age = s_age;
	}
	public String getS_name() {
		return s_name;
	}
	public void setS_name(String s_name) {
		this.s_name = s_name;
	}
	public String getS_sex() {
		return s_sex;
	}
	public void setS_sex(String s_sex) {
		this.s_sex = s_sex;
	}
	public String getS_class() {
		return s_class;
	}
	public void setS_class(String s_class) {
		this.s_class = s_class;
	}
	public String getS_phone() {
		return s_phone;
	}
	public void setS_phone(String s_phone) {
		this.s_phone = s_phone;
	}
	private String s_phone;
	
	

}
