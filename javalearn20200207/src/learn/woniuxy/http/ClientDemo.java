package learn.woniuxy.http;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 客户端
 * @author Administrator
 *
 */

public class ClientDemo {

	public static void main(String[] args) {
		//ip
		String aimHost ="127.0.0.1";
		//端口
		int aimPort = 554;
		//Socket对象,三次握手
		Socket client = null;
		OutputStream os = null;
		InputStream is = null;
		int len;
		try {
			client = new Socket(aimHost,aimPort);
			//获取目标主机输出流
			os = client.getOutputStream();
			//写出数据
			System.out.println("你好");
			os.write(("你好").getBytes());
			
			//切流
			client.shutdownOutput();
			
			//获取输入流
			is = client.getInputStream();
			//读取数据
			byte[] content = new byte[1024];
			len = -1;
			while((len = is.read(content))!=-1) {
				String str = new String(content,0,len);
				System.out.println(str);
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(is!=null) {
					is.close();
				}	
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if(os!=null) {
					os.close();
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
		}		
	}

}
