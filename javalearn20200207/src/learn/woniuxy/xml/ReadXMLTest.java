package learn.woniuxy.xml;

import java.io.File;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class ReadXMLTest {
	private static String driverClass;
	private static String jdbcUrl;
	private static String user;
	private static String password;
	
	
	
	public static String getDriverClass() {
		return driverClass;
	}

	public static void setDriverClass(String driverClass) {
		ReadXMLTest.driverClass = driverClass;
	}

	public static String getJdbcUrl() {
		return jdbcUrl;
	}

	public static void setJdbcUrl(String jdbcUrl) {
		ReadXMLTest.jdbcUrl = jdbcUrl;
	}

	public static String getUser() {
		return user;
	}


	public static void setUser(String user) {
		ReadXMLTest.user = user;
	}


	public static String getPassword() {
		return password;
	}

	public static void setPassword(String password) {
		ReadXMLTest.password = password;
	}
	


	public static void setAssign(String attrName,String attrValue) {
		switch(attrName){
		case "driverClass":
			setDriverClass(attrValue);
			break;
		case "jdbcUrl":
			setJdbcUrl(attrValue);
			break;
		case "user":
			setUser(attrValue);
			break;
		case "password":
			setPassword(attrValue);
			break;
	    default:
	    	System.out.println("错误");
		}
	}
	


	@Override
	public String toString() {
		return "ReadXMLTest ["+" DriverClass："+getDriverClass()+" JdbcUrl："+getJdbcUrl()+" User："+getUser()+" Password："+getPassword()+"]";
	}
	
	/*
	 * 有必要封装为低耦合的方法，只需要放入xml文件，自动获取所有
	 * 
	 */
	public static void main(String[] args) throws DocumentException{
		//创建SaxReader对象
	    SAXReader reader = new SAXReader();
	    //将XML加载到程序中，以Document形式存在
	    Document doc = null;
	    
	    doc = reader.read(new File("jdbc.xml"));
	    
	    // 单斜杠：根节点开始找
	    driverClass = doc.selectSingleNode("/jdbc_config/named-config[@name='myjdbc']/property[@name='driverClass']").getText();
	    //双斜杠：指定节点开始找
	    jdbcUrl = doc.selectSingleNode("//named-config[@name='myjdbc']/property[@name='jdbcUrl']").getText();
	    
	    System.out.println(driverClass+jdbcUrl);

//		try {
//			doc = reader.read(new File("jdbc.xml"));
//			//获取根标签
//			Element jdbc_configEle = doc.getRootElement();
//			//获取子标签
//			List<Element> named_configEles = jdbc_configEle.elements("named-config");
//			//遍历该子标签
//			for(Element named_configEle: named_configEles) {
//				List<Element> propertyEles = named_configEle.elements("property");
//				for(Element propertyEle:propertyEles) {
//					//System.out.println(propertyEle.attributeValue("name")+":"+propertyEle.getText());
//					setAssign(propertyEle.attributeValue("name"),propertyEle.getText());
//				}			
//			}
//		} catch (DocumentException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
	//	System.out.println(new ReadXMLTest().toString());
		
	}
}
