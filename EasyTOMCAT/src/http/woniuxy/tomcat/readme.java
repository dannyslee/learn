package http.woniuxy.tomcat;

import java.io.InputStream;
import java.net.Socket;

public interface readme {
	
	/*
	 * 伪代码实现业务逻辑
	 */
	
	//1.需要一个请求对象，其构造器参数为Socket监听内容
	//实参为：Socket.getInputStream()
	void Request(InputStream inputStream);
	
	//2.需要一个Socket对象,实现服务器接收
	void SocketProcess(Socket socket);
	
	//3.取uri键 - 得到 servlet名 - 以servlet名作为键 - 得到相关类的实例化对象(forName映射) - 该实例化对象可以执行service（get或者post）}
}