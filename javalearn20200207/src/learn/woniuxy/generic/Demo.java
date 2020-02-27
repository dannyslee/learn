package learn.woniuxy.generic;

public class Demo {
	//<?>表示泛型的任意类型
	//<? extends Number> 当期类及其子类类型 （上限）
	//<? super Number> 当期类及其父类类型 （下限）
	public static void todo1(GenericClassDemo<?> e){};
	public static void todo2(GenericClassDemo<? extends Number> e){};
	public static void todo3(GenericClassDemo<? super Integer> e){};

		
	public static void main(String[] args) {
		todo1(new GenericClassDemo<Long>());
		todo2(new GenericClassDemo<Long>());
		//todo2(new GenericClassDemo<String>());
		//todo3(new GenericClassDemo<Long>()); 
		todo3(new GenericClassDemo<Number>()); 
		todo3(new GenericClassDemo<Number>()); 

		
	}
}
