package http.woniuxy.tomcat.util;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class XMLUtil {
	/*
	 * 定义解析器和文档对象
	 */
	public SAXReader saxReader;
	public Document document;
	
	//构造器获取文档对象
	public XMLUtil(String xpath){
		saxReader = new SAXReader();
		try {
			document = saxReader.read(xpath);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//获取节点
	 public List<Element> getNodes(String name) {
	        Element root = document.getRootElement();
	        return root.elements(name);
	 }
	 
	 
	
	
}
