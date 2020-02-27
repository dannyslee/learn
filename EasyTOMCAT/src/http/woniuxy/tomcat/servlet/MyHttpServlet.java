package http.woniuxy.tomcat.servlet;

import java.util.Hashtable;

import http.woniuxy.tomcat.Tomcat;
import http.woniuxy.tomcat.requestandresponse.MyRequest;
import http.woniuxy.tomcat.requestandresponse.MyResponse;

public abstract class MyHttpServlet {
	
	private Hashtable<String,MyHttpServlet> servletObject = new Hashtable<String,MyHttpServlet>();
	
	public void service(MyRequest request,MyResponse response) {
		System.out.println("MyHttpServlet的service的方法被执行");
		if(request.getMethod().equalsIgnoreCase("get")) {
			doGet(request,response);
		}else if(request.getMethod().equalsIgnoreCase("post")) {
			doPost(request,response);
		}
	}

	public void doPost(MyRequest request,MyResponse response) {
		System.out.println("MyHttpServlet的doPost的方法被执行");
	}

	public void doGet(MyRequest request,MyResponse response) {
		System.out.println("MyHttpServlet的doGet的方法被执行");

	};
	
	public void init() {
	   if(Tomcat.INIT) {
			System.out.println("MyHttpServlet的init的方法被执行");
	   }

	}
	
	public void destroy() {
		if(Tomcat.DESTROY) {
			System.out.println("MyHttpServlet的destroy的方法被执行");
			Tomcat.DESTROY=false;
		}
	}


}
