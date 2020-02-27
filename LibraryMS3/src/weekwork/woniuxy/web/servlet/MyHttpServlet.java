package weekwork.woniuxy.web.servlet;

import java.util.Hashtable;

import weekwork.woniuxy.web.listener.MyRequest;

public abstract class MyHttpServlet {
	
	private Hashtable<String,MyHttpServlet> servletObject = new Hashtable<String,MyHttpServlet>();
	
	public void service(MyRequest request) {
		System.out.println("MyHttpServlet的service的方法被执行");
		if(request.getMethod().equalsIgnoreCase("get")) {
			doGet(request);
		}else if(request.getMethod().equalsIgnoreCase("post")) {
			doPost(request);
		}
	}

	public void doPost(MyRequest request) {
		System.out.println("MyHttpServlet的doPost的方法被执行");
	}

	public void doGet(MyRequest request) {
		System.out.println("MyHttpServlet的doGet的方法被执行");

	};
	
	public void init() {
		System.out.println("MyHttpServlet的init的方法被执行");

	}
	
	public void destroy() {
		System.out.println("MyHttpServlet的destroy的方法被执行");

	}
	
	public void todo(Hashtable<String,MyHttpServlet> servletObject) {
		
	}
}
