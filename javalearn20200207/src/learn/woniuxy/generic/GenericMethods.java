package learn.woniuxy.generic;

public class GenericMethods {
	// 泛型方法(在修饰符与返回值之间，声明泛型)
	public  <E> void demo1() {
		E a = null;
	}
	
	public static <E> E demo2() {
		E a = null;
		return a;
	}
	
	
	public static <E> E demo3(E a) {//此方法，可以确定泛型e的真实类型
		a = null;
		return a;
	}
	
	
	public static void main(String[] args) {
		//确定e的真实类型,方法的参数类型可设置为泛型
    	demo3(2);
    	demo3("cheng");
	}
}
