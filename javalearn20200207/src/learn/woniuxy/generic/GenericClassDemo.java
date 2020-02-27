package learn.woniuxy.generic;

public class GenericClassDemo<E> {//1.泛型的E有占位的作用，实例对象时，获取实际类型 2.可声明多个例如<E,T>
	private E value;
	public E getValue() {
		return value;
	}
	public void setValue(E val) {
		this.value=val;
	}
	
	
	
	public static void main(String[] args) {
		//泛型：参数化类型
		//泛型类
		//泛型实参必须为引用类型
		GenericClassDemo<String>  gc1 = new GenericClassDemo<String>();
		GenericClassDemo<Integer> gc2 = new GenericClassDemo<Integer>();
		GenericClassDemo<Demo> gc3 = new GenericClassDemo<Demo>();
//		GenericDemo<int> gc4 = new GenericDemo<int>(); //不可以使用基本数据类型

	}
	
}
