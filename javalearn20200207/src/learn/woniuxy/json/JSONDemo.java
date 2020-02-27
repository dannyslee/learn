package learn.woniuxy.json;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import learn.woniuxy.reflect.UserPO;

public class JSONDemo {
	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		UserPO po =new UserPO(1,"admin","123");
		UserPO po1 =new UserPO(2,"adminn","133");
		//创建ObjectMapper对象
		ObjectMapper om = new ObjectMapper();
		//调用方法将Java对象转为JSON
		String str =null;
		try {
			str = om.writeValueAsString(po);
			System.out.println(str);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//数组方式
		List<UserPO> l = new ArrayList<>();		
		l.add(po1);
		l.add(po);
		
		String str1 = null;
		try {
			str1 = om.writeValueAsString(l);
			System.out.println(str1);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//JSON转java
		UserPO poll = om.readValue(str.getBytes(), UserPO.class);
		System.out.println(poll);
		ArrayList list = om.readValue(str1.getBytes(), ArrayList.class);
		System.out.println(list);
		
	}
}
