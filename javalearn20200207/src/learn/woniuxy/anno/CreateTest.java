package learn.woniuxy.anno;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.event.ListSelectionEvent;

public class CreateTest {
	//获取所有类名
	static <T> List<T> findClass(String file){
		List<T> classNames = null;
		String str =null;
		//获取所有class，使用递归
		//String str = "learn.woniuxy.anno";
		str = "src\\"+file.replace(".", "\\") ;
		System.out.println(str);
		File f2 =new File(str);
		//List<String> finds = find(f2);
//		for (String string : finds) {
//			System.out.println(string);
//			//classNames.add((T) ((file+string).replace(".java", "")));
//		}
		//Class.forName("learn.woniuxy.reflect.ClassPO")
		return classNames;	
	}
	
	//根据注解判断是否创建该对象
	static <T> void createClass(List<T> ts) throws Exception {
		Map<String,Object> map =  new HashMap<>();
		for(T t:ts ) {
			//判断该类是否存在注解
			boolean annotationPresent = Class.forName(t.toString()).isAnnotationPresent(Create.class);
			//如果存在以类名+类对象为键值对形式存入
			if(annotationPresent) {
				map.put(t.toString(), Class.forName(t.toString()).newInstance());
				//System.out.println(map.get(t.toString()));
			}
			
		}
		
	}
	

	//遍历
	static void find(File f2,List<String> lists) {
		String replaceAll = null;
		File[] f = f2.listFiles();
		if(f!=null && f.length!=0) {
			for(File f1:f) {
				find(f1,lists);				
			}
		}
		//System.out.println(f2.length());
		if(f2.getName().endsWith(".java")) {
			replaceAll = (f2.getName());
			lists.add(replaceAll);		
		}
		//System.out.println("find方法："+replaceAll);
	}
	
	//删除指定位置
//	static List<String> replaceStr(List<String> finds,String str){
//		List<String> lists = new ArrayList<String>();
//		for (String find : finds) {
//			//String replace = find.replace("\\", "\\.");
//			lists.add(find);
//		}
//		
//		return lists;		
//	}
	
	public static void main(String[] args) throws Exception {
		String str = "learn.woniuxy.anno";
		List<String> lists = new ArrayList<String>();
		str = "src\\"+str.replace(".", "\\") ;
		System.out.println(str);
		File f2 =new File(str);
		find(f2,lists);
		for (String string : lists) {
			System.out.println(string);
		}
		//findClass(str);
		//findClass(str);
		//createClass();
		
	}
	
}
