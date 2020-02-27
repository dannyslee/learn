package learn.woniuxy.xml;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;


public class CreateXMLDemo {

	public static void main(String[] args) {
		//创建XML文件
		//获取文档对象
		Document doc = DocumentHelper.createDocument();
		//创建根节点
		Element schoolEle = doc.addElement("school");
		//为元素添加属性
		schoolEle.addAttribute("name", "蜗牛学院");
		//添加子节点（子标签）
		Element classEle = schoolEle.addElement("class");
		//为元素添加属性
		classEle.addAttribute("name", "65期Java开发班");
		//添加子标签
		Element stuEle1 = classEle.addElement("student");
		Element nameEle1 = stuEle1.addElement("name");
		nameEle1.setText("小小");
		Element ageEle1 = classEle.addElement("age");
		ageEle1.setText("22");
		Element sexEle1 = classEle.addElement("sex");
		sexEle1.setText("男");

		
		Element stuEle2 = classEle.addElement("student");
		Element nameEle2 = stuEle1.addElement("name");
		nameEle2.setText("小然");
		Element ageEle2 = classEle.addElement("age");
		ageEle2.setText("21");
		Element sexEle2 = classEle.addElement("sex");
		nameEle2.setText("女");
		
		//创建xml文件对象
		File xmlFile = new File("student.xml");
		//定义XML输出格式
		OutputFormat format = OutputFormat.createPrettyPrint();
		//设置XML编码
		format.setEncoding("utf-8");
		//创建XML输出流
		XMLWriter writer = null;
		try {
			writer = new XMLWriter(new FileWriter(xmlFile),format);
			//将XML写到本地
			writer.write(doc);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
				try {
					if(writer!=null)
					     writer.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
		
		
		
	}
}
