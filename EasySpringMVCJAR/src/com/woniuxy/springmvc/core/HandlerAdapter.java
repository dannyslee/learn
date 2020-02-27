package com.woniuxy.springmvc.core;

import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.math.BigDecimal;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



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
		//System.out.println("doDispatch中controllersMapping是否无内容（false代表有内容）：" + HandlerMapper.getControllerMappings().isEmpty());
		if (handlerMapper.getControllerMappings().isEmpty()) {
			return null;
		}
		//如果有值，获取映射路径
		String uri = req.getPathInfo();
		//System.out.println("doDispatch中获取的已处理的uri:" + uri);

		//根据映射获取Controller对象
		Object controller = handlerMapper.getControllerMappings().get(uri);
		//和Method
		Method method = (Method) handlerMapper.getMethodMappings().get(uri);
		//判断是否含有uri键 + 判断是否存在目标对象 +判断是否存在对象的方法
		if(uri==null || controller ==null || method==null) {
			//如果没有
			//sendErr 404
			try {
				resp.sendError(405,"未找到相关内容");
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
		//System.out.println("methodParameterCount方法参数个数："+methodParamsCount);

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
			//System.out.println("methodParamName:"+methodParamName);

			//以形参名为键，获取客户端req来的实参值 ：requestParamMap.get(methodParamName)
			String[] reqParamVal = reqParamsMap.get( methodParamName);
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
					//System.out.println("methodParamFieldName:"+methodParamFieldName);

					//属性类型
					Class<?> methodParamFieldTypeorClass = methodParamField.getType();
					//生成键
					String key = methodParamName+"."+methodParamFieldName;
					//System.out.println("key:"+key);

					//以键 取 req的Map中的值
					String[] realReqVal = reqParamsMap.get(key);
					//System.out.println("realRequestValue"+Arrays.toString(realReqVal));
					if(realReqVal==null) {
						continue;
					}
					//req的值（String） --> 转化方法 --> 真实需要的值（属性类型的值）
					Object convert = parse(realReqVal, methodParamFieldTypeorClass);
					//System.out.println("convert:"+convert);
					//Object convert = ConverterUtil.getInstance().convert(realReqVal, methodParamFieldTypeorClass);			
					//设置set方法名
					String setMethod = "set"+methodParamFieldName.substring(0,1).toUpperCase()+methodParamFieldName.substring(1);
					//System.out.println("setMethod:"+setMethod);

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
			//判断是否为基本数据类型 isPrimitive()
			if (methodParamTypeorClass.isPrimitive()) {		
				//如果是基本数类型,parse方法可以判别当下形参的类型，根据实际类型，将map获得的值进行类型转化
				realMethodParams[i] = parse(reqParamVal, methodParamTypeorClass);
				continue;
			}
			//判断是否为数组
			if(methodParamTypeorClass.isArray()) {
				//使用Array内部的方法实现数组类型转化
				realMethodParams[i] = parseArray(reqParamVal, methodParamTypeorClass);
				continue;
			}
			
			//判断是否为BigDecimal类型
			if (methodParamTypeorClass.isAssignableFrom(BigDecimal.class)) {
				realMethodParams[i] = parse(reqParamVal, methodParamTypeorClass);
				continue;
			}
			
			//String类型
			if(methodParamTypeorClass.isAssignableFrom(String.class)) {
				realMethodParams[i] = parse(reqParamVal, methodParamTypeorClass);
				continue;
			}
			
			//其他判断类型，此地备留
			
		}
		//利用反射机制，调用方法
		try {
			invoke = method.invoke(controller, realMethodParams);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		System.out.println(invoke);
		return invoke;
		
	}
	
	//对基本类型数组处理
	private Object parseArray(String[] reqParamVal, Class<?> methodParamTypeorClass) {
		
		//使用Array.newInstance反射方法创建形参类型的数组
		Object methodParamArray = Array.newInstance(methodParamTypeorClass, reqParamVal.length);
		//遍历数组并转化类型
		for (int i = 0; i < reqParamVal.length; i++) {
			//创建一个字符串数组
			String[] param = new String[1];
			//将需要转化类型的放入改数组
			param[0] = reqParamVal[0];
			//使用Array.set进行逐一类型转化，并生成数组
			Array.set(methodParamArray, i, parse(reqParamVal,methodParamTypeorClass));
			
		}
		return methodParamArray;
	}
	
	//对基本类型值处理
	private Object parse(String[] reqParamVal, Class<?> methodParamTypeorClass) {
		Object val =null;
		//byte类型处理
		if(methodParamTypeorClass.isAssignableFrom(byte.class)) {
			val=Byte.parseByte(reqParamVal[0]);
		}
		//char类型处理
		if(methodParamTypeorClass.isAssignableFrom(char.class)) {
			val=reqParamVal[0].charAt(0);
		}
		//int类型处理
		if(methodParamTypeorClass.isAssignableFrom(int.class)) {
			val = Integer.parseInt(reqParamVal[0]);
		}
		//short类型处理
		if(methodParamTypeorClass.isAssignableFrom(short.class)) {
			val = Short.parseShort(reqParamVal[0]);
		}
		//long类型处理
		if(methodParamTypeorClass.isAssignableFrom(long.class)) {
			val = Long.parseLong(reqParamVal[0]);
		}
		//float类型处理
		if(methodParamTypeorClass.isAssignableFrom(float.class)) {
			val = Float.parseFloat(reqParamVal[0]);
		}
		//double类型处理
		if(methodParamTypeorClass.isAssignableFrom(double.class)) {
			val = Double.parseDouble(reqParamVal[0]);
		}
		//boolean类型处理
		if(methodParamTypeorClass.isAssignableFrom(boolean.class)) {
			val = Boolean.parseBoolean(reqParamVal[0]);
		}
		boolean isArray =false;
		if(methodParamTypeorClass.isAssignableFrom(BigDecimal.class)) {
			if(isArray) {
				BigDecimal[] re = new BigDecimal[reqParamVal.length];
				for (int i = 0; i < re.length; i++) {
					re[i] = new BigDecimal(reqParamVal[i]);
				}
				val=re;
			}else {
				val = new BigDecimal(reqParamVal[0]);

			}
		}
		
		if(methodParamTypeorClass.isAssignableFrom(String.class)) {
			if(isArray) {		
				val=reqParamVal;
			}else {
				val = reqParamVal[0];
			}
		}
		
		return val;
	}
	
}
