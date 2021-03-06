package http.woniuxy.tomcat;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Timer;
import java.util.TimerTask;

import org.dom4j.Element;

import http.woniuxy.tomcat.requestandresponse.MyRequest;
import http.woniuxy.tomcat.servlet.MyHttpServlet;
import http.woniuxy.tomcat.socket.SocketProcess;
import http.woniuxy.tomcat.util.XMLUtil;

public class Tomcat {
	//端口号
	private static final int PORT = 8888;
	
	public static  Map<String,Object> servlets = new HashMap<>();
	public static   Map<String,String> servletMappings = new HashMap<>();
	
	//初始化成功
	public static boolean INIT = false;
	//销毁成功
	public static boolean DESTROY = false;
	
	//控制服务器启动关闭
	public static boolean tomcatStrat = true;
	
	//初始化
	private void init() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		// InputStream io = null;
		// 读取配置文件
		System.out.println("服务器初始化开始~");
		System.out.println("读取配置文件");
		XMLUtil xml = new XMLUtil("web.xml");
		
		//servlet内容
		List<Element> servletEs = xml.getNodes("servlet");
		for (Element element : servletEs) {
			Element servlet_name = element.element("servlet-name");
			Object Servlet_class;

			Servlet_class = Class.forName(element.element("servlet-class").getText()).newInstance();
			System.out.println("servlets的文件配置："+servlet_name.getText() +"::"+ Servlet_class);
			servlets.put(servlet_name.getText(), Servlet_class);

		}
		// 获取servlet-map内容
		List<Element> servlet_mapping = xml.getNodes("servlet-mapping");
		for (Element element : servlet_mapping) {
			Element url_pattern = element.element("url-pattern");
			Element servlet_name = element.element("servlet-name");
			System.out.println("servletMappings的文件配置："+url_pattern.getText() +":::"+ servlet_name.getText());
			servletMappings.put(url_pattern.getText(), servlet_name.getText());
		}
		
		INIT = true;
		System.out.println("加载配置文件结束");
		System.out.println("服务器初始化结束~");

	}
	
	//销毁
	private void destroy() {
			     Timer timer = new Timer();
			      timer.schedule(new TimerTask() {
			        public void run() {
			        	Hashtable<String, MyHttpServlet> servletObject = SocketProcess.servletObject;
			        	for(Entry<String, MyHttpServlet> entry: servletObject.entrySet()){
			        		System.out.println("servletObject-key:"+entry.getKey());
			        		System.out.println("servletObject-value:"+entry.getValue());
				        	servletObject.remove(entry.getKey());
			        	}
			        	DESTROY = true;
			        	System.out.println("服务器自动销毁之前实例");
			        }
			      }, 50000, 50000);
	}
	
	//启动方法
	private void start() {
		ServerSocket serverSocket =null;
		try {
			serverSocket = new ServerSocket(PORT);
			System.out.println("TOMCAT已启动，地址locathost："+PORT);
			//持续监听
			do {
				//接收
				Socket socket = serverSocket.accept();//accept()方法用于接收客户端请求
				//设置超时时间,放入线程中执行
				//socket.setSoTimeout(3000);
				//执行线程
				Thread thread = new SocketProcess(socket);
				thread.start();
			}while(tomcatStrat);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		Tomcat tomcat = new Tomcat();
		tomcat.init();
		tomcat.destroy();
		tomcat.start();
		
	}
}
