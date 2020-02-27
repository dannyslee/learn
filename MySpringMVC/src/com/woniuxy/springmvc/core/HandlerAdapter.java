package com.woniuxy.springmvc.core;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.math.BigDecimal;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.tribes.util.Arrays;

import com.woniuxy.springmvc.annotation.ResponseRedirect;
import com.woniuxy.springmvc.controller.Demo;

public class HandlerAdapter {
	private HandlerMapper handlerMapper;

	public HandlerAdapter(HandlerMapper handlerMapper) {
	
		this.handlerMapper = handlerMapper;
	}
	
	
//	private Object fixparse(String paramType) {
//		Object type = null;
//		switch(paramType) {
//		case "Integer":
//			return type = 
//	        break;
//		}
//		return null;
//	}
	
	public Object adapter(HttpServletRequest req, HttpServletResponse resp) {
		Object invoke = null;
		// 判断handlerMapping的map中是否有值
		System.out.println("doDispatch中controllersMapping是否无内容（false代表有内容）：" + HandlerMapper.getControllerMappings().isEmpty());
		if (HandlerMapper.getControllerMappings().isEmpty()) {
			return invoke;
		}
		// 获取uri
		String uri = req.getPathInfo();
		System.out.println("doDispatch中获取的已处理的uri:" + uri);
		// 根据映射获取Controller对象和Method
		Object controller = HandlerMapper.getControllerMappings().get(uri);
		// 如果有，通过url获取所有的方法
		Method method = (Method) HandlerMapper.getMethodMappings().get(uri);
		// 判断handlerMapping是否含有url + 判断是否存在目标对象
		if (!HandlerMapper.getControllerMappings().containsKey(uri) || controller == null || method == null) {
			// 设置响应编码
			resp.setCharacterEncoding("utf-8");
			try {
				// 如果没有，报404错误
				resp.sendError(404, "未找到相关内容");
				// resp.getWriter().write("404 WARING");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return invoke;
		}
		//获取方法形参个数
		int methodParameterCount = method.getParameterCount();
		System.out.println("methodParameterCount方法参数个数："+methodParameterCount);
		//存储方法实参的数组
		Object[] realMethodParams = new Object[methodParameterCount];
		//判断目标方法是否存在Request或Response参数
		//获取目标方法参数
		Parameter[] methodParameters = method.getParameters();
		//获取客户端传参值
		Map<String, String[]> requestParameterMap = req.getParameterMap();
		//循环遍历所有参数
		for (int i = 0; i < methodParameters.length; i++) {
			//循环取出每一个方法参数
			Parameter methodParam = methodParameters[i];
			//获取参数类型(自定义类做为参数)
			Class<?> methodParamType = methodParam.getType();
			//获取方法参数名称
			String methodParamName = methodParam.getName();
			System.out.println("methodParamName:"+methodParamName);
			//尝试从请求中获取客户端传参
			String[] requestSingleParamArray = requestParameterMap.get(methodParamName);
			//.replaceAll("\\{|\\}", "")
			String reqSingleParamArrayToString = Arrays.toString(requestSingleParamArray).replaceAll("\\[|\\]", "").replaceAll(",\\s", ",");
			System.out.println("reqSingleParamArrayToString:"+reqSingleParamArrayToString);

			//判断参数类型
			//判断当前class是否为指定类型的class或父类的class
			if(methodParamType.isAssignableFrom(HttpServletRequest.class)) {
				realMethodParams[i] = req;
			}else if(methodParamType.isAssignableFrom(HttpServletResponse.class)){
				realMethodParams[i] = resp;
			}else if(methodParamType.getClassLoader()!=null) {
				System.out.println("xxxx");
				//获取方法参数名称（上面已经获取）
				//获取目标对象参数类型的所有属性值（field）
				Field[] methodParamFields = methodParamType.getDeclaredFields();
				//创建目标类对象（newInstance）
				Object obj = null;
				try {
					obj = methodParamType.newInstance();
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//遍历属性值
				for (Field methodParamField : methodParamFields) {
					//获取属性名称
					String methodParamFieldName = methodParamField.getName();
					System.out.println("methodParamFieldName:"+methodParamFieldName);
					//获取键demo.name
					String key = methodParamName+"."+methodParamFieldName;
					System.out.println("key:"+key);
					//根据键，尝试去获取实参
					String[] realRequestValue = requestParameterMap.get(key);
					System.out.println("realRequestValue"+Arrays.toString(realRequestValue));
					//空值判断
					if (realRequestValue == null) {
						continue;
					}
					//获取属性类型
					Class<?> methodParamFieldType = methodParamField.getType();
					//将String转为真实值类型
					Object parse = parse(realRequestValue, methodParamFieldType);
					//获取set方法名称
					String setMethod = "set"+methodParamFieldName.substring(0,1).toUpperCase()+methodParamFieldName.substring(1);
					System.out.println("setMethod:"+setMethod);
					//获取set方法对象
					try {
						Method setFieldMethod = methodParamType.getDeclaredMethod(setMethod, methodParamFieldType);
						//执行set方法为属性赋值
						setFieldMethod.invoke(obj, parse);
					} catch (NoSuchMethodException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SecurityException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalArgumentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					//执行赋值
					realMethodParams[i]=obj;
				}
				
			}
//			}else if(methodParamType.isPrimitive()) {//判断是否为基本数据类型
//				//处理基本数据类型
//				
//				
//				if(requestSingleParamArray==null) {
//					try {
//						resp.sendError(407,"请求异常");
//					} catch (IOException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//					return null;
//				}
//				
//				//将String数组转换为参数对应真实类型
//				realMethodParams[i] = parse(requestSingleParamArray,methodParamType);
//	
//			}
				else {
				
				realMethodParams[i] = parse(requestSingleParamArray,methodParamType);
				
				
//				switch(methodParamType.getSimpleName()) {
//				    case "String":
//				    	realMethodParams[i] = requestSingleParamArray[0];
//				        break;
//				    case "BigDecimal":
//				    	realMethodParams[i] = requestSingleParamArray[0].toString();
//				        break;
//				    case "String[]":
//				    	realMethodParams[i] = Arrays.toString(requestSingleParamArray);
//				    	break;
//				}
			}
		}
		

		
		// 获取参数类型
//		Class<?>[] methodParameterTypes = method.getParameterTypes();
//		if (methodParameterTypes == null) {
//			// 如果发现参数类型为空，实则为无参方法
//			try {
//				invoke = method.invoke(controller);
//			} catch (IllegalAccessException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (IllegalArgumentException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (InvocationTargetException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//
//		}
		// 获取请求的参数
//		Map<String, String[]> requestParameterMap = req.getParameterMap();
//		// 将参数值存入数组,通过参数类型的长度可以确定参数值的长度
//		Object[] methodParameterValues = new Object[methodParameterTypes.length];
//		// 对req，resp参数名进行处理
//		for (int i = 0; i < methodParameterValues.length; i++) {
//			// 获取参数类型的名称
//			String requestParam = methodParameterTypes[i].getSimpleName();
//			// 如果类型名称与HttpServletRequest一致，将其参数名设为req
//			if (requestParam.equals("HttpServletRequest")) {
//				methodParameterValues[i] = req;
//				continue;// 该参数一旦被判别，就不需要继续判断该值了
//			}
//			// 如果类型名称与HttpServletRespons一致，将其参数名设为resp
//			if (requestParam.equals("HttpServletRespons")) {
//				methodParameterValues[i] = resp;
//				continue;
//			}
//			// 储存其他类型参数
//			if (requestParam.equals("String")) {
//				for (Map.Entry<String, String[]> param : requestParameterMap.entrySet()) {
//					String value = Arrays.toString(param.getValue());
//					methodParameterValues[i] = value;
//				}
//			}
//		}
		// 利用反射机制，调用方法
		try {
			invoke = method.invoke(controller, realMethodParams);//methodParameterValues
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return invoke;
	}

	
	
	private Object parse(String[] requestSingleParamArray, Class<?> methodParamType) {
		Object val =null;
		boolean isArray =false;
		if(methodParamType.isArray()) {
			isArray = true;
			methodParamType = methodParamType.getComponentType();//获取数组类型
		}
		if(methodParamType.isAssignableFrom(byte.class)) {
			if(isArray) {
				byte[] re = new byte[requestSingleParamArray.length];
				for (int i = 0; i < re.length; i++) {
					re[i] = Byte.parseByte(requestSingleParamArray[i]);
				}
				val=re;
			}else {
				val = Byte.parseByte(requestSingleParamArray[0]);

			}
		
		}
		if(methodParamType.isAssignableFrom(short.class)) {
			if(isArray) {
				short[] re = new short[requestSingleParamArray.length];
				for (int i = 0; i < re.length; i++) {
					re[i] = Short.parseShort(requestSingleParamArray[i]);
				}
				val=re;
			}else {
				val = Short.parseShort(requestSingleParamArray[0]);

			}	
		}
		if(methodParamType.isAssignableFrom(long.class)) {
			if(isArray) {
				long[] re = new long[requestSingleParamArray.length];
				for (int i = 0; i < re.length; i++) {
					re[i] = Long.parseLong(requestSingleParamArray[i]);
				}
				val=re;
			}else {
				val = Long.parseLong(requestSingleParamArray[0]);

			}
		
		}
		if(methodParamType.isAssignableFrom(int.class)) {
			if(isArray) {
				int[] re = new int[requestSingleParamArray.length];
				for (int i = 0; i < re.length; i++) {
					re[i] = Integer.parseInt(requestSingleParamArray[i]);
				}
				val=re;
			}else {
				val = Integer.parseInt(requestSingleParamArray[0]);

			}
		}
		if(methodParamType.isAssignableFrom(double.class)) {
			if(isArray) {
				double[] re = new double[requestSingleParamArray.length];
				for (int i = 0; i < re.length; i++) {
					re[i] = Double.parseDouble(requestSingleParamArray[i]);
				}
				val=re;
			}else {
				val = Double.parseDouble(requestSingleParamArray[0]);

			}				
			
		}
		if(methodParamType.isAssignableFrom(float.class)) {
			if(isArray) {
				float[] re = new float[requestSingleParamArray.length];
				for (int i = 0; i < re.length; i++) {
					re[i] = Float.parseFloat(requestSingleParamArray[i]);
				}
				val=re;
			}else {
				val =Float.parseFloat(requestSingleParamArray[0]);

			}		
			
		}
		if(methodParamType.isAssignableFrom(char.class)) {
			if(isArray) {
				char[] re = new char[requestSingleParamArray.length];
				for (int i = 0; i < re.length; i++) {
					re[i] = requestSingleParamArray[i].charAt(0);
				}
				val=re;
			}else {
				val = requestSingleParamArray[0].charAt(0);

			}		
			
		}
		if(methodParamType.isAssignableFrom(boolean.class)) {
			if(isArray) {
				boolean[] re = new boolean[requestSingleParamArray.length];
				for (int i = 0; i < re.length; i++) {
					re[i] = Boolean.parseBoolean(requestSingleParamArray[i]);
				}
				val=re;
			}else {
				val = Boolean.parseBoolean(requestSingleParamArray[0]);

			}			
		}
		if(methodParamType.isAssignableFrom(BigDecimal.class)) {
			if(isArray) {
				BigDecimal[] re = new BigDecimal[requestSingleParamArray.length];
				for (int i = 0; i < re.length; i++) {
					re[i] = new BigDecimal(requestSingleParamArray[i]);
				}
				val=re;
			}else {
				val = new BigDecimal(requestSingleParamArray[0]);

			}
		}
		
		if(methodParamType.isAssignableFrom(String.class)) {
			if(isArray) {		
				val=requestSingleParamArray;
			}else {
				val = requestSingleParamArray[0];
			}
		
		}
				
		return val;
	}
	
	private Object parse(String requestSingleParamArray, Class<?> methodParamType) {
		Object val =null;
		if(methodParamType.isAssignableFrom(byte.class)) {
			val = Byte.parseByte(requestSingleParamArray.split(",")[0]);
			return val;
		}
		if(methodParamType.isAssignableFrom(short.class)) {
			val = Short.parseShort(requestSingleParamArray.split(",")[0]);
			return val;
		}
		if(methodParamType.isAssignableFrom(long.class)) {
			val = Long.parseLong(requestSingleParamArray.split(",")[0]);
			return val;
		}
		if(methodParamType.isAssignableFrom(int.class)) {
			val = Integer.parseInt(requestSingleParamArray.split(",")[0]);
			return val;
		}
		if(methodParamType.isAssignableFrom(double.class)) {
			val = Double.parseDouble(requestSingleParamArray.split(",")[0]);
			return val;
		}
		if(methodParamType.isAssignableFrom(float.class)) {
			val =Float.parseFloat(requestSingleParamArray.split(",")[0]);
			return val;
		}
		if(methodParamType.isAssignableFrom(char.class)) {
			val = requestSingleParamArray.split(",")[0].charAt(0);
			return val;
		}
		if(methodParamType.isAssignableFrom(boolean.class)) {
			val = Boolean.parseBoolean(requestSingleParamArray.split(",")[0]);
			return val;
		}
		if(methodParamType.isAssignableFrom(BigDecimal.class)) {
			val = Boolean.parseBoolean(requestSingleParamArray.split(",")[0]);
			return val;
		}
		
		return val;
	}

	
}
