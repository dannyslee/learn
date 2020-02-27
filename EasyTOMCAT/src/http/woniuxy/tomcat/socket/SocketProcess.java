package http.woniuxy.tomcat.socket;

import java.io.IOException;
import java.net.Socket;
import java.util.HashMap;
import java.util.Hashtable;

import http.woniuxy.tomcat.Tomcat;
import http.woniuxy.tomcat.requestandresponse.MyRequest;
import http.woniuxy.tomcat.requestandresponse.MyResponse;
import http.woniuxy.tomcat.servlet.MyHttpServlet;

public class SocketProcess extends Thread{
	protected Socket socket;
	
	public static Hashtable<String,MyHttpServlet> servletObject = new Hashtable<String, MyHttpServlet>(); 

	public SocketProcess(Socket socket) {
		super();
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			//设置超时时间 
			socket.setSoTimeout(3000);
			
			MyRequest request = new MyRequest(socket.getInputStream());
			
			//MyResponse response = new MyResponse();
			
			//取uri键 - 得到 servlet名 - 以servlet名作为键 - 得到相关类的实例化对象 - 该实例化对象可以执行get或者post
			
			String servletName = Tomcat.servletMappings.get(request.getUri());
			System.out.println("从 Tomcat.servletMappings获取的servletName："+servletName);
			MyHttpServlet servlet = null;
			//判断相应uri是否取得相关的servlet名
			if (servletName != null && !servletName.isEmpty()) {
				try {
					//判断map中是否存在该实例，如果存在直接使用
					if(servletObject.get(request.getUri())==null) {
						//如果不存在，实例化对象
						servlet = (MyHttpServlet) Tomcat.servlets.get(servletName);	
						//并进行初始化
						servlet.init();
						//然后存入map中
						servletObject.put(request.getUri(), servlet);
					}
					MyHttpServlet myHttpServlet = servletObject.get(request.getUri());
					if (myHttpServlet != null) {
						myHttpServlet.service(request, null);
						myHttpServlet.destroy();
					} else {
						System.out.println("找不到servlet");
					}

				} catch (Exception e) {
					System.out.println("该实例未继承MyHttpService");
				}

			} else {
				System.out.println("找不到servletMapping");
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (socket != null)
					socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	}
	
	
}
