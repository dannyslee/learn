package weekwork.woniuxy.web.test;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class GetNodes {
	
	private  Map<String,String> servlets = new HashMap<String,String>();
	private   Map<String,String> servletMappings = new HashMap<String,String>();
	
	public void getXMLInfo(Map<String,String> servlets,Map<String,String> servletMappings) throws DocumentException {
		// 创建SaxReader对象
		SAXReader reader = new SAXReader();
		//
		File file = new File("WebContent/WEB-INF/web.xml");
		System.out.println(file.exists());
		// 将XML加载到程序中
		Document read = reader.read(file);
		System.out.println(read);
		//获取根节点
		Element web_app = read.getRootElement();
		//获取servlet内容
		List<Element> servletEs =web_app.elements("servlet");
		for (Element element : servletEs) {
			Element servlet_name =element.element("servlet-name");
			Element Servlet_class = element.element("servlet-class");
			System.out.println(servlet_name.getText()+Servlet_class.getText());
			servlets.put(servlet_name.getText(), Servlet_class.getText());
		}
		
		//获取servlet-map内容
		List<Element> servlet_mapping =web_app.elements("servlet-mapping");
		for (Element element : servlet_mapping) {
			Element url_pattern =element.element("url-pattern");
			Element servlet_name = element.element("servlet-name");
			System.out.println(url_pattern.getText()+ servlet_name.getText());
			servletMappings.put(url_pattern.getText(), servlet_name.getText());
		}

		
	}
//	public static void main(String[] args) throws DocumentException {
//		getXMLInfo(servlets,servletMappings);
//	}
}
