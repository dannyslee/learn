package com.woniuxy.springmvc.servlet;

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

import com.woniuxy.springmvc.annotation.framework.Controller;
import com.woniuxy.springmvc.annotation.handlermapping.RequestMapping;


public class DispatcherServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	//读取配置文件，得到控制器（Controller）包名
	private Properties properties = new Properties();
	//根据包名，遍历得到类名
	private List<String> classNames = new ArrayList<>();
	//通过类名，得到其实例化对象：类名（首字母小写）键+实例化对象值
	private Map<String,Object> ioc = new HashMap<>();
	
	//HandlerMapping的类型可自定义Handler（层层筛选，可能一些Controller并没有相关注解，而注解的value可拼接为具体的url）
	//通过注解，拿到url作为键（对类+方法注解的value拼接），存在该实际映射值的Controller对象作为值
	private Map<String,Object> controllersMapping = new HashMap<>();
	//通过注解，拿到url作为键（对类+方法注解的value拼接），存在实际映射值的Controller对象的方法作为值
	private Map<String,Object> methodsMapping = new HashMap<>();
	

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doDispatch(req, resp);
	}

	@Override
	public void init() throws ServletException {
		//1.加载配置文件,填充propreties字段,得到相关的包名
		String packageName = doLoadConfig("param.properties","package");
		System.out.println("init初始化时获取的包名："+packageName);
		//2.根据propreties，初始化所有相关联的类，遍历用户设定的包下面所有类
		doScanner(packageName);
		//3.拿到遍历到的类，通过反射机制，实例化，并放入ioc容器
		doInstance();
		//4.自动依赖注入,在Spring中为了解耦合，利用构造器以实例对象为参的方式进行，形成类与类之间的依赖，在初始化时，如果出现变动，可使用自动注入动态变化
		//doAutowired();
		//5.初始化自定义的HandleMapping
		initHandlerMapping();
		
	}
	
	
	/**
	 * 值得注意的是：如果使用controller中封装的方法，绝大数要使用到参数，其中固定的为HttpServletRequest req, HttpServletResponse resp
	 * 不固定，应当存入数组，反射实现时，传入
	 * 因此在封装方法时，要考虑取出参数类型，并在参数类型确定的情况下，强制将参数名设置为req和resp
	 * @param req 请求
	 * @param resp 响应
	 */
	private void doDispatch(HttpServletRequest req, HttpServletResponse resp) {
		//判断handlerMapping的map中是否有值
		System.out.println("doDispatch中controllersMapping是否无内容："+controllersMapping.isEmpty());
		if (controllersMapping.isEmpty()) {
			return;
		}
//		//获取uri,uri会包含根目录
//		String requestURI = req.getRequestURI();
//		System.out.println("doDispatch中获取的原始uri:"+requestURI);
//		//获取内容根目录
//		String contextPath = req.getContextPath();
//		System.out.println("doDispatch中获取的根目录"+contextPath);
//
//		//对uri处理,将根目录去掉，如果是多个斜杠转换为一条
//		String uri = requestURI.replace(contextPath, "").replace("/+", "/");
//		
		//使用方法getPathinfo,获取uri
		String uri = req.getPathInfo();
		
		System.out.println("doDispatch中获取的已处理的uri:"+uri);
		//判断handlerMapping是否含有url
		if (!this.controllersMapping.containsKey(uri)) {
			//设置响应编码
			resp.setCharacterEncoding("utf-8");
			try {
				//如果没有，报404错误
				resp.sendError(404,"未找到相关内容");
				//resp.getWriter().write("404 WARING");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}
		//如果有，通过url获取所有的方法
		Method method = (Method)this.methodsMapping.get(uri);
		//获取参数类型
		Class<?>[] methodParameterTypes = method.getParameterTypes();
		if (methodParameterTypes == null) {
			//如果发现参数类型为空，实则为无参方法
			try {
				method.invoke(this.controllersMapping.get(uri));
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
			return;
		}
		//获取请求的参数
		Map<String, String[]> requestParameterMap = req.getParameterMap();
		//将参数值存入数组,通过参数类型的长度可以确定参数值的长度
		Object[]  methodParameterValues = new Object[methodParameterTypes.length];
		//对req，resp参数名进行处理
		for (int i = 0; i < methodParameterValues.length; i++) {
			//获取参数类型的名称
			String requestParam = methodParameterTypes[i].getSimpleName();
			//如果类型名称与HttpServletRequest一致，将其参数名设为req
			if(requestParam.equals("HttpServletRequest")) {
				methodParameterValues[i] = req;
				continue;//该参数一旦被判别，就不需要继续判断该值了
			}
			//如果类型名称与HttpServletRespons一致，将其参数名设为resp
			if (requestParam.equals("HttpServletRespons")) {
				methodParameterValues[i] = resp;
				continue;
			}		
			//储存其他类型参数
			if(requestParam.equals("String")) {
				for(Map.Entry<String, String[]> param:requestParameterMap.entrySet()) {
					String value = Arrays.toString(param.getValue());
					methodParameterValues[i] = value;
				}
			}
		}
		//利用反射机制，调用方法
		try {
			method.invoke(this.controllersMapping.get(uri), methodParameterValues);
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
	}

	private void initHandlerMapping() {
		//获取所有Controller对象
		for(Object controller:ioc.values()) {
			//获取当前类对象
			Class<? extends Object> cl = controller.getClass();
			//判断是否该对象的类是否有RequestMapping注解
			if (!cl.isAnnotationPresent(RequestMapping.class)) {
				continue;
			}
			//如果有，获取当前对象类上的注解
			RequestMapping declaredAnnotation = cl.getDeclaredAnnotation(RequestMapping.class);
			//获取类注解映射值
			String controllerClassMappingValue = declaredAnnotation.value();
			//获取所有Controller对象的方法
			Method[] declaredMethods = cl.getDeclaredMethods();
			for (Method method : declaredMethods) {
				//判断该对象的方法是否有RequestMapping注解
				if(!method.isAnnotationPresent(RequestMapping.class)) {
					continue;
				}
				//如果有，获取当前对象方法上的注解
				RequestMapping declaredAnnotation2 = method.getDeclaredAnnotation(RequestMapping.class);
				//获取方法注解的映射值
				String controllerMethodMappingValue = declaredAnnotation2.value();
				//判断映射值是否都有效
				if(controllerClassMappingValue.length()<1 || controllerMethodMappingValue.length()<1) {
					continue;
				}
				//拼接类与方法的注解映射值，称为url
				String key = controllerClassMappingValue+controllerMethodMappingValue;
				System.out.println("initHandlerMapping中得到的key："+key);
				//分别存入相关的map
				//以url为键，实例化对象为值
				controllersMapping.put(key, controller);
				//以url为键，实例化对象的方法为值
				methodsMapping.put(key, method);
			}
			
		}
		
	}

	private void doInstance() {
		for(String className:classNames) {
			//获取类对象
			Class<?> forName =null;
			try {
				forName = Class.forName(className);
				//对类名进行处理
				String simpleClassName = forName.getSimpleName();
				//首字母小写
				String simpleClassNewName = simpleClassName.substring(0, 1).toLowerCase()+simpleClassName.substring(1);
				System.out.println("doInstance中获取的处理过的类名"+simpleClassNewName);
				//判断是否有注解
				boolean annotationPresent = forName.isAnnotationPresent(Controller.class);
				System.out.println("doInstance中是否有注解的判断"+annotationPresent);
				//如果有，存入map中
				if (annotationPresent) {
					ioc.put(simpleClassNewName, forName.newInstance());
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		
	}

	private void doScanner(String packageName) {
		//处理包名，以路径形式存在
		String  packageNewName = packageName.replaceAll("\\.", "/");
		System.out.println("doScanner中获取的新包名"+packageNewName);
		//获取文件的真实绝对路径，为file传参做准备
		String path = this.getClass().getClassLoader().getResource(packageNewName).getPath();
		System.out.println("doScanner中获取的真实绝对路径"+path);
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
				System.out.println("doScanner中获取的类全名"+className);
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
		System.out.println("doLoadConfig中获取的初始化参数"+initParameter);
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
		System.out.println("doLoadConfig中获取的包名"+property);
		return property;
	}
	
	

}
