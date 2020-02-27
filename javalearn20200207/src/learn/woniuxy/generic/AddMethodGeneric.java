package learn.woniuxy.generic;

import java.text.DecimalFormat;

public class AddMethodGeneric {
	
	//简单计算
	public static <E extends Number,T extends Number> Number add1(E e,T t) {
		return e.doubleValue()+t.doubleValue();
	}
	
	//精确计算
	public static <E extends Number,T extends Number> Number add2(E e,T t) {
		Number num = null;
		 if(e.getClass()==Integer.class&&t.getClass()==Integer.class){
	            System.out.print("Integer:");
	            num = e.intValue() +  t.intValue();
	        }else if(e.getClass()==Float.class&&t.getClass()==Float.class){
	            System.out.print("Float:");
	            num =e.floatValue() + t.floatValue();
	        }else if(e.getClass()==Double.class&&t.getClass()==Double.class){
	            System.out.print("Double:");
	            num =e.doubleValue() + t.doubleValue();
	        } else if(e.getClass()==Long.class&&t.getClass()==Long.class){
	            System.out.print("Long:");
	            num = e.longValue() + t.longValue();
	        }else if(e.getClass()==Short.class&&t.getClass()==Short.class){
	            System.out.print("Short:");
	            num = e.shortValue() + t.shortValue();
	        }else if(e.getClass()==Double.class||t.getClass()==Double.class){
	            System.out.print("强制转换Double:");
	            num =e.doubleValue() + t.doubleValue();
	        }else if(e.getClass()==Long.class||t.getClass()==Long.class){
	            System.out.print("强制转换Long:");
	            num =e.longValue() + t.longValue();
	        } else if(e.getClass()==Float.class||t.getClass()==Float.class){
	            System.out.print("强制转换Float:");
	            num = e.floatValue() + t.floatValue();
	        }else if(e.getClass()==Integer.class||t.getClass()==Integer.class){
	        	num = e.intValue() + t.intValue();
	        }
		return num;
	}
	
	public static void main(String[] args) {
		System.out.println(add1(2,2));
		System.out.println(add2(100,101.2));
	}
}
