package http.woniuxy.tomcat.requestandresponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class MyRequest {
	//储存请求的Url
		private String uri;
		//存储请求方式
		private String method;
		//存储除请求首行外所有请求头信息
		Map<String,String> requestHeader = new HashMap<String,String>();
		
		public MyRequest(InputStream inputStream){
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
	        String[] methodAndUri;
			try {
				//System.out.println("获取的socket.getInputStream的所有内容:"+bufferedReader.readLine());
				methodAndUri = bufferedReader.readLine().split(" ");
				 for (String string : methodAndUri) {
		        	 System.out.println("遍历获取的所有头信息："+string);
				}
		       
		        this.method = methodAndUri[0];
		        this.uri = methodAndUri[1];
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					if(bufferedReader!=null)
					   bufferedReader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					if(inputStream!=null)
					    inputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	       
	        System.out.println("请求类型："+ method);
	        System.out.println("请求路径："+ uri);

		}

//		public MyRequset(String uri, String method, Map<String, String> requestHeader) {
//			super();
//			this.uri = uri;
//			this.method = method;
//			this.requestHeader = requestHeader;
//		}

		public String getUri() {
			return uri;
		}

		public void setUri(String uri) {
			this.uri = uri;
		}

		public String getMethod() {
			return method;
		}

		public void setMethod(String method) {
			this.method = method;
		}
}
