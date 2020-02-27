package learn.woniuxy.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class MapReflect {
	//定义对象池
	private Map<String,Object> objPool = new HashMap<>();
	
	//定义对象创建方法
	private Object createObjcet(String className) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Class<?> classObj = Class.forName(className);
		return classObj.newInstance();		
	}
	
	public static <T> T encapsulation(Map<String,Object> objPool,Class<T> cl) throws Exception {
		T po =null;
		//创建目标类对象
		po=cl.newInstance();
		//获取目标类对象的所有属性
		Field[] fields = cl.getDeclaredFields();
		//获取对象的名称
		for (Field field : fields) {
			//获取属性名，为map的键做准备
			String fieldName = field.getName();
			//以属性名作为键，取出值，这里的Object是实际要上传的值
			Object obj = objPool.get(fieldName);
			
			//判断赋的值是否与属性类型一致(判断要赋值的对象，是否为属性类型的实例)
			Class fieldType = field.getType();
			if(!fieldType.isInstance(obj)) {
				continue;
			}
			//使用set方法为属性赋值
			//获取set方法名称
			String setMethodName = "set"+fieldName.substring(0,1).toUpperCase()+fieldName.substring(1);
			//获取目标类的方法
			Method setMethod = cl.getDeclaredMethod(setMethodName, fieldType);
			//执行set方法,invoke,为目标类对象的set赋值
			setMethod.invoke(po, obj);
		}
		return po;
		
	}
	public static void main(String[] args) {
		Map<String,Object> values = new HashMap<>();
		values.put("id", 1);
		values.put("name", "adminnn");
		try {
			UserPO po = encapsulation(values,UserPO.class);
			System.out.println(po);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
