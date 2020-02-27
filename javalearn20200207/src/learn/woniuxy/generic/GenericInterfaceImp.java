package learn.woniuxy.generic;

public class GenericInterfaceImp<E> implements GenericInterface<E> {
//实现时，也可以直接确定其真实类型，但不推荐
// public class GenericInterfaceImp implements GenericInterface<String>
	@Override
	public E test(E e) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static void main(String[] args) {
		new GenericClassDemo<Integer>();
	}

}
