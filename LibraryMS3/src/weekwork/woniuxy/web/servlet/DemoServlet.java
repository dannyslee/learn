package weekwork.woniuxy.web.servlet;

import weekwork.woniuxy.web.listener.MyRequest;

public class DemoServlet extends MyHttpServlet {

	@Override
	public void service(MyRequest request) {
		System.out.println("DemoServlet的Service方法被执行了");
	}
	
}
