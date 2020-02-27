package learn.woniuxy.reflect;

public class Test {
	public static void main(String[] args) {
		String sql = "select id,name,output,price,writer,wid,createdate from vi_books where id=? ";
		
		String [] arr = sql.split("\\s+");
		String[] arr1 = arr[1].split(",");
		for (String str: arr1) {
			System.out.println(str);
		}
		
		//条件1：只有一个字段
		if(sql.split("\\s+")[1].split(",")==null) {
			String s = sql.split("\\s+")[1];
		}else {
			
		}
	}
}
