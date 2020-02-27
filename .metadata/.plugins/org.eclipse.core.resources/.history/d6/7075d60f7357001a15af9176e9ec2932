package com.woniuxy.springmvc.core;


import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.List;
import java.util.Map;



import com.woniuxy.springmvc.annotation.framework.Controller;
import com.woniuxy.springmvc.annotation.handlermapping.RequestMapping;





public class HandlerMapper{

	//以类名+类对象为键值存储
	private Map<String,Object>  ioc = new HashMap<>();
	//存储请求映射与Controller对应关系
	private Map<String,Object> controllerMappings = new HashMap<>();
	//存储请求映射与Menthod对应关系
	private Map<String,Object> methodMappings = new HashMap<>();
	
	
	

	public HandlerMapper(List<String> classNames) {
		//实例化Controller对象
		try {
			doInstance(classNames);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//映射关系建立
		initMapping();
		
	}

	public Map<String, Object> getControllerMappings() {
		return controllerMappings;
	}

	public void setControllerMappings(Map<String, Object> controllerMappings) {
		this.controllerMappings = controllerMappings;
	}

	public Map<String, Object> getMethodMappings() {
		return methodMappings;
	}

	public void setMethodMappings(Map<String, Object> methodMappings) {
		this.methodMappings = methodMappings;
	}


	private void initMapping() {
		//获取所有Controller对象
		for(Object controller:ioc.values()) {
			Class<? extends Object> c1 = controller.getClass();
			//判断当前类是否存在RequestMapping注解
			System.out.println(c1.getSimpleName()+"当前类是否存在RequestMapping注解："+c1.isAnnotationPresent(RequestMapping.class));
			if(!c1.isAnnotationPresent(RequestMapping.class)) {
				continue;
			}
			
			//获取当前Controller的RequsetMapping注解
			RequestMapping declaredAnnotation = c1.getDeclaredAnnotation(RequestMapping.class);
			//获取当前映射值
			String controllerMappingValue = declaredAnnotation.value();
			System.out.println("当前映射值"+controllerMappingValue);

			//获取当前Controller的所有方法
			Method[] declaredMethods = c1.getDeclaredMethods();
			for (Method method : declaredMethods) {
				//判断当前方法是否存在RequestsMapping注解
				System.out.println(method.getName()+"方法是否存在RequestsMapping注解"+method.isAnnotationPresent(RequestMapping.class));
				if(!method.isAnnotationPresent(RequestMapping.class)) {
					continue;
				}
				//获取当前方法上的RequestMapping注解
				RequestMapping methodRM = method.getDeclaredAnnotation(RequestMapping.class);
				//获取RM的注解值
				String methodRMValue = methodRM.value();
				System.out.println(method.getName()+"获取RM的注解值:"+methodRMValue);
				//判断值是否有效
				if (methodRMValue.length()<1 || controllerMappingValue.length()<1 ) {
					continue;
				}
				//键
				String key = controllerMappingValue+methodRMValue;
				System.out.println(method.getName()+"的键："+key);
				//建立请求映射与Controller映射
				controllerMappings.put(key,controller);
				//建立请求映射与Method映射
				methodMappings.put(key, method);
			}
		}
	}

	
	private void doInstance(List<String> classNames) throws Exception{
		/*
		 *遍历所有类全面，判断类上是否存在Controller注解（保留到运行时，只能修饰类），
		 *如果存在，则创建对象并按照类名小驼峰形式为键，对象作为值
		 */
		for(String classname:classNames) {
			System.out.println(classname);
			//判断是否存在注解
			boolean annotationPresent = Class.forName(classname).isAnnotationPresent(Controller.class);
			System.out.println(annotationPresent);	
			//如果存在注解，以类名+对象为键值对存入
			//处理
			String simpleName = Class.forName(classname).getSimpleName();
			simpleName = simpleName.substring(0,1).toLowerCase()+simpleName.substring(1);
			System.out.println(simpleName);
			if (annotationPresent) {
				ioc.put(simpleName, Class.forName(classname).newInstance());
			}
		}
		
	}
	

	
}