package weekwork.woniuxy.web.test;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

public class homework {
	private Map<String,String> servlets = new HashMap<String,String>();
	private Map<String,String> servletMappings = new HashMap<String,String>();

	//获取xml的配置信息
	static void getXMLInfo() throws DocumentException {
		//准备
		//创建SaxReader对象
		SAXReader reader = new SAXReader();
		//
		File file = new File("WebContent/WEB-INF/web.xml");
		System.out.println(file.exists());
		//将XML加载到程序中
		Document read = reader.read(file);
		System.out.println(read);
		//获取servlet-name
		List<Node> selectNodes = read.selectNodes("//servlet");
		System.out.println(selectNodes);
		for (Node node : selectNodes) {
			Element selectObject = (Element)node.selectObject("servlet-name");
			String a = selectObject.getText();
		}
		//获取servlet-class
		//List selectNodes2 = read.selectNodes("//servlet-class");
		//获取servlet-mapping
		//List selectNodes3 = read.selectNodes("//servlet-mapping");
		//获取url-pattern
		//List selectNodes4 = read.selectNodes("//url-pattern");
	}
	
	public static void main(String[] args) {
		 try {
			getXMLInfo();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
