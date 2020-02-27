package learn.woniuxy.http;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务端
 * @author Administrator
 *
 */
public class ServerDemo {

	public static void main(String[] args) {
		//端口
		int port = 554;
		//Socket对象
		Socket client = null;
		//输入流
		InputStream is = null;
		//字节长度
		int len;
		//输出流		
		OutputStream os = null;
		//创建服务器套接字对象
		ServerSocket server = null;
		try {
			server = new ServerSocket(port);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			while(true) {
				//accept():接收处理客户端数据，阻塞方法,将客户端数据信息封装为Socket对象返回
				client = server.accept();
				//获取客户端ip
				System.out.println(client.getInetAddress());
				//获取指定的输入流
				is = client.getInputStream();
				//读取数据
				byte[] content = new byte[1024];
				len = -1;
				while((len = is.read(content))!=-1) {
					String str = new String(content,0,len);
					System.out.println(str);
				}
				
				//获取输出流
				os = client.getOutputStream();
				//写出数据
				System.out.println("你是谁？");
				os.write(("你是谁？").getBytes());
			}	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(os!=null) {
					os.close();
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if(is!=null) {
					is.close();
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if(client!=null) {
					client.close();
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if(server!=null) {
					server.close();
				}		
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
