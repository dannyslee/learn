package weekwork.woniuxy.web.listener;

import java.util.HashMap;
import java.util.Map;

public class MyRequest {
	//储存请求的Url
	private String uri;
	//存储请求方式
	private String method;
	//存储除请求首行外所有请求头信息
	Map<String,String> requestHeader = new HashMap<String,String>();
	
	public MyRequest(String uri, String method, Map<String, String> requestHeader) {
		super();
		this.uri = uri;
		this.method = method;
		this.requestHeader = requestHeader;
	}

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
