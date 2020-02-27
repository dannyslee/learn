package learn.woniuxy.xml;

import java.io.File;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class ReadXMLDemo {
	public static void main(String[] args) throws DocumentException {
		//创建SaxReader对象
		SAXReader reader = new SAXReader();
		//将XML加载到程序中，以Document形式存在
		Document doc = reader.read(new File("student.xml"));
		//获取根标签
		Element schoolEle = doc.getRootElement();
		//获取根标签名称
		System.out.println(schoolEle.getName());
		//获取属性标签内容
		System.out.println(schoolEle.attributeValue("name"));
		//获取标签下的子标签 
		//法1：
//		List<Element> classEles = schoolEle.elements("class");
//		for(Element cla:classEles) {
//			System.out.println(cla);
//		}
		//法2
		Element claEle = schoolEle.element("class");
		//获取属性
		System.out.println(claEle.attributeValue("name"));
		
		//获取子标签
		List<Element> stuEles = claEle.elements("student");
		for (Element stuEle : stuEles) {
			List<Element> eles = stuEle.elements();
			for(Element ele:eles) {
				System.out.println(ele.getName()+":"+ele.getText());
			}
		}
		
}
	
}
