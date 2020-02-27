package http.woniuxy.tomcat.requestandresponse;

import java.io.OutputStream;

public class MyResponse {
	private OutputStream putputStream;
	private String write;
	public MyResponse(OutputStream putputStream) {
		super();
		this.putputStream = putputStream;
	}
	public String getWrite() {
		return write;
	}
	public void setWrite(String write) {
		this.write = write;
	}
	
	
	
	
}
