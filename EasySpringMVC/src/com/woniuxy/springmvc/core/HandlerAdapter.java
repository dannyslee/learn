package com.woniuxy.springmvc.core;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.woniuxy.springmvc.util.ConverterUtil;

public class HandlerAdapter {
	
	//依赖
	private HandlerMapper handlerMapper;
	
	//构造器
	public HandlerAdapter(HandlerMapper handlerMapper) {
		super();
		this.handlerMapper = handlerMapper;
	}
	
	//service执行方法
	public Object adapter(HttpServletRequest req,HttpServletResponse resp) {
		//返回值
		Object invoke = null;
		//判断
		//判断handlerMapping是否有值
		if (handlerMapper.getControllerMappings().isEmpty()) {
			return null;
		}
		//如果有值，获取映射路径
		String uri = req.getPathInfo();
		//根据映射获取Controller对象
		Object controller = handlerMapper.getControllerMappings().get(uri);
		//和Method
		Method method = (Method) handlerMapper.getMethodMappings().get(uri);
		//判断是否含有uri键 + 判断是否存在目标对象 +判断是否存在对象的方法
		if(uri==null || controller ==null || method==null) {
			//如果没有
			//sendErr 404
			try {
				resp.sendError(404,"未找到相关内容");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		
		
		/*
		 * 方法：方法名 - 形参 ：形参个数 形参类型 形参名 <—— 实参类型 实参名 <—— req的参数 req的参数类型 req的参数名
		 */
		
		//获取方法的形参：method.getParamters();
		Parameter[] methodParams = method.getParameters();
		//获取方法的形参数量： method.getParamterCount();
		int methodParamsCount = method.getParameterCount();
		//储存实参 new Object[method.getParamterCount()]
		Object[] realMethodParams = new Object[methodParamsCount];
		//获取req的参数:req.getParamterMap -- 参数类型为String，参数内容为 String[]
		Map<String, String[]> reqParamsMap = req.getParameterMap();
		
		/*
		 * 得到目标方法的单一形参
		 * 
		 */
		
		for (int i = 0; i < realMethodParams.length; i++) {
			//从形参数组中逐一获取
			Parameter methodParam = methodParams[i];
			//形参类型 -- 也可以理解为某个类
			Class<?> methodParamTypeorClass = methodParam.getType();
			//形参名称
			String methodParamName = methodParam.getName();
			//以形参名为键，获取客户端req来的实参值 ：requestParamMap.get(methodParamName)
			String[] reqParamVal = reqParamsMap.get(methodParamName);
			//判断参数类型
			//判断当前class（参数类型）是否为指定类型的class或者父类的class
			//判断是否为请求类型
			if(methodParamTypeorClass.isAssignableFrom(HttpServletRequest.class)) {
				realMethodParams[i] = req;
				continue;
			}
			//判断是否为响应类型
			if(methodParamTypeorClass.isAssignableFrom(HttpServletResponse.class)) {
				realMethodParams[i] = resp;
				continue;
			}
			//如果是自定义类型（自定义类）作为参数，其类加载器为空：methodParamTypeorClass.getClassLoader()!=null
			if(methodParamTypeorClass.getClassLoader()!=null) {
				//得到自定义类，就实例化目标类对象：methodParamTypeorClass.newInstance();
				Object obj = null;
				try {
					obj = methodParamTypeorClass.newInstance();
				} catch (InstantiationException | IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//获取目标类的所有属性（成员变量：field）:methodParamTypeorClass.getDeclaredFields();
				Field[] methodParamFields = methodParamTypeorClass.getDeclaredFields();
				//对属性逐一操作
				for (Field methodParamField : methodParamFields) {
					//属性名称
					String methodParamFieldName = methodParamField.getName();
					//属性类型
					Class methodParamFieldTypeorClass = methodParamField.getType();
					//生成键
					String key = methodParamName+"."+methodParamFieldName;
					//以键 取 req的Map中的值
					String[] realReqVal = reqParamsMap.get(key);
					//非空判断
					if (realReqVal==null) {
						return null;
					}
					//req的值（String） --> 转化方法 --> 真实需要的值（属性类型的值）
					Object convert = ConverterUtil.getInstance().convert(realReqVal, methodParamFieldTypeorClass);			
					//设置set方法名
					String setMethod = "set"+methodParamFieldName.substring(0,1).toUpperCase()+methodParamFieldName.substring(1);
	                //获取set方法
					try {
						//通过类得到相应的set方法
						Method setFieldMethod = methodParamTypeorClass.getDeclaredMethod(setMethod,methodParamFieldTypeorClass);
						//反射执行set方法,并获取返回值
					   setFieldMethod.invoke(obj, convert);
					} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
					
					//自定义类由于也是方法参数，需要传入参数数组
					realMethodParams[i] = obj;
					continue;
				}
				
			}
			//判断是否为基本数据类型
			
			//判断是否为数组
			
			//利用反射机制，调用方法
			try {
				invoke = method.invoke(controller, realMethodParams);
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

		
		
		return invoke;
		
	}
	
}
