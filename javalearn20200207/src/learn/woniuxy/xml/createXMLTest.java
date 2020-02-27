package learn.woniuxy.xml;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

public class createXMLTest {
	
	public static void main(String[] args) {
		//创建xml文件
		//获取文档对象
		Document doc = DocumentHelper.createDocument();
		//创建根节点
		Element jdbc_configEle = doc.addElement("jdbc_config");
		//添加子节点（子标签）
		Element named_configEle = jdbc_configEle.addElement("named-config");
		//为元素添加属性
		named_configEle.addAttribute("name", "myjdbc");
		//添加上一层的同级子节点（子标签）
		Element propertyEle1 = named_configEle.addElement("property");
		propertyEle1.addAttribute("name", "driverClass");
		//为元素添加文本
		propertyEle1.setText("com.mysql.jdbc.Driver");
		
		Element propertyEle2 = named_configEle.addElement("property");
		propertyEle2.addAttribute("name", "jdbcUrl");
		propertyEle2.setText("jdbc:mysql://localhost:3306/studentms");
		
		Element propertyEle3 = named_configEle.addElement("property");
		propertyEle3.addAttribute("name", "user");
		propertyEle3.setText("root");
		
		Element propertyEle4 = named_configEle.addElement("property");
		propertyEle4.addAttribute("name", "password");
		propertyEle4.setText("12356");

		//创建xml文件对象
		File xmlFile = new File("jdbc.xml");
		//创建xml文件
		createXMLWrite(doc,xmlFile);
		
		
	}
	

	public static void createXMLWrite(Document doc, File xmlFile) {
		// 定义XML输出格式
		OutputFormat format = OutputFormat.createPrettyPrint();
		// 设置XML编码
		format.setEncoding("utf-8");
		// 创建XML输出流
		XMLWriter writer = null;
		try {
			writer = new XMLWriter(new FileWriter(xmlFile), format);
			// 将XML写到本地
			writer.write(doc);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (writer != null)
					writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
