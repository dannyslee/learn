package com.woniuxy.springmvc.core;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.tribes.util.Arrays;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.woniuxy.springmvc.annotation.framework.Controller;
import com.woniuxy.springmvc.annotation.handlermapping.RequestMapping;
import com.woniuxy.springmvc.annotation.handlermapping.ResponseBody;
import com.woniuxy.springmvc.annotation.handlermapping.ResponseForword;
import com.woniuxy.springmvc.annotation.handlermapping.ResponseRedirect;


public class DispatcherServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	//读取配置文件，得到控制器（Controller）包名
	private Properties properties = new Properties();
	//根据包名，遍历得到类名
	private List<String> classNames = new ArrayList<>();
	//创建处理器映射器对象
    private HandlerMapper handlerMapper;
	//创建处理器适配器对象
	private HandlerAdapter handlerAdapter;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		Object result = handlerAdapter.adapter(req, resp);
		//判断是否有返回值
		if(result==null) {
			return;
		}
	
		//获取请求映射(getPathInfo())
		String pathInfo = req.getPathInfo();
		//获取请求uri
		String requestURI = req.getRequestURI();
		//System.out.println("当前请求uri："+requestURI);
		//System.out.println("pathInfo:"+pathInfo);
		//根据请求映射获取目标方法
		Method method = (Method) handlerMapper.getMethodMappings().get(pathInfo);
		//根据方法上存在的注解
		boolean methodResponseRedirect = method.isAnnotationPresent(ResponseRedirect.class);
		boolean methodResponseForword = method.isAnnotationPresent(ResponseForword.class);
		//System.out.println("methodResponseRedirect:"+methodResponseRedirect);
		if(methodResponseForword) {
			//转为string类型
			String path = (String)result;	
			//将类型转化为String
			path = (String)result;		
			//请求转发
			req.getRequestDispatcher("../../"+path).forward(req, resp);
			
		}else if(methodResponseRedirect) {
			ResponseRedirect respRedAnno = method.getDeclaredAnnotation(ResponseRedirect.class);
			//转为string类型
			String path = (String)result;	
			path = (String)result;		
			if(respRedAnno.value()) {
				//绝对路径
				resp.sendRedirect(path);
			}else {
				resp.sendRedirect("../../"+path);
			}
		}
		
		//获取返回值
		//判断是否存在注解
		boolean methodResponseBody = method.isAnnotationPresent(ResponseBody.class);
		if(methodResponseBody) {
			//进行java转json
			String jsonTestValue= new ObjectMapper().writeValueAsString(result);
			//调用resp，写入
			resp.setContentType("application/json; charset=utf-8");
			resp.getWriter().write(jsonTestValue);
		}
		
	}

	@Override
	public void init() throws ServletException {
		//1.加载配置文件,填充propreties字段,得到相关的包名
		String packageName = doLoadConfig("application.properties","package");
		//2.根据propreties，初始化所有相关联的类，遍历用户设定的包下面所有类
		doScanner(packageName);
		//3.创建处理器映射器对象
		handlerMapper = new HandlerMapper(classNames);
		//4.创建处理器适配器对象
		handlerAdapter = new HandlerAdapter(handlerMapper);
		
	}
	
	
	private void doScanner(String packageName) {
		//处理包名，以路径形式存在
		String  packageNewName = packageName.replaceAll("\\.", "/");
		//System.out.println("doScanner中获取的新包名"+packageNewName);
		//获取文件的真实绝对路径，为file传参做准备
		String path = this.getClass().getClassLoader().getResource(packageNewName).getPath();
		//System.out.println("doScanner中获取的真实绝对路径"+path);
		//创建File对象
		File file = new File(path);
		//获取子文件
		File[] listFiles = file.listFiles();
		//判空
		if (listFiles == null) {
			return;
		}
		//获取文件名称
		for (File f : listFiles) {
			//获取文件名
			String fileName = f.getName();
			//判断是否还有子目录
			if(f.isDirectory()) {
				//如果有，递归
				doScanner(packageName+"."+fileName);
			}else {
				//判断是否为class文件
				if(!fileName.endsWith(".class")) {
					continue;
				}
				
				//获取类名
				String classSimpleName = fileName.replace(".class", "");
				//获取类全名
				String className = packageName+"."+classSimpleName;
				//System.out.println("doScanner中获取的类全名"+className);
				//存储类全名
				classNames.add(className);
				
			}
		}
	}

	private String doLoadConfig(String propertiesName,String key) {
		String property = null;
		//获取当前ServletConfig对象
		ServletConfig config = getServletConfig();
		//获取初始化参数
		String initParameter = config.getInitParameter("config");
		//System.out.println("doLoadConfig中获取的初始化参数"+initParameter);
		//若没有获取到用户配置的配置文件名，则使用默认配置文件名
		if (initParameter == null) {
			initParameter = propertiesName;
		}
		//类加载器的方式，获取传入的文件流
		InputStream resourceAsStream = this.getClass().getClassLoader().getResourceAsStream(initParameter);
		//加载配置文件
		try {
			properties.load(resourceAsStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//获取包名
		property = properties.getProperty(key);
		//System.out.println("doLoadConfig中获取的包名"+property);
		return property;
	}
	
	

}
