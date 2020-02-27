package learn.woniuxy.anno;

import java.lang.reflect.Method;

public class Execute {

	public static <T> void executeMethod(Class<T> class1) throws Exception{

			
	    	Method[] methods = class1.getDeclaredMethods();
			//boolean re = class1.isAnnotationPresent(Test.class);

	    	T t = class1.newInstance();
	    	for(Method method : methods) {
	    		if(method.isAnnotationPresent(Test.class)) {
		    		//执行当前方法
	    			Object obj = method.invoke(t);
	    			//获取Test
	    			Test test = method.getDeclaredAnnotation(Test.class);
	    			//获取注解value值
	    			boolean bool = test.value();
	    			if(bool) {
	    				System.out.println(obj);
	    			}
		    	}
	    	}
	

	}
}
