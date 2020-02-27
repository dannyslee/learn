package learn.woniuxy.enumdemo;

public enum WeekEnum {//枚举不能被继承
	// 每一个都是WeekEnum的实例，例如：SUM，就是 public static final WeekEnum SUM = new WeekEnum();
	//SUM(), MON, TUE, WED, THU, FRI, SAT;
	SUM("周一",1),MON("周二",2),TUE("周三",3), WED("周四",4), THU("周五",5), FRI("周六",6), SAT("周天",7);//该行必须放置在第一行
	//SUM("",1);
	//定义全局变量
	private String value;
	private int num;
	
	//构造器必须私有
	//枚举在无参构造的情况下，可默认省略括号，但也可以写为例如NUM()的形式
	//枚举在有参构造的情况下，可以为类似SUM("123",1)的形式
	private WeekEnum(String value, int num) {
		this.value = value;
		this.num = num;
	}
	
	WeekEnum(){
		
	}
	

	
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	
	public static void main(String[] args) {
		// 获取枚举类实例
		// 方式一：
		WeekEnum sum = WeekEnum.SUM;
		// 方式二：反射
		WeekEnum sum1 = WeekEnum.valueOf(WeekEnum.class, "SUM");
		// 获取指定枚举类的所有实例
		WeekEnum[] weeks = WeekEnum.values();
		System.out.println(weeks.length);
		for(WeekEnum week:weeks) {
			System.out.println(week.getValue());
		}
		//枚举名称
		System.out.println(SUM.name());
		//返回当前枚举序数
		System.out.println(SUM.ordinal());
		//返回此枚举常量的哈希码
		System.out.println(SUM.hashCode());
		//获取当前枚举常量的枚举类型对象的class对象
		System.out.println(SUM.getDeclaringClass());
		//获取此枚举与指定对象的顺序
		System.out.println(SUM.compareTo(WED));
		
	}
	
}
