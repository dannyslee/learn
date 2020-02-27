package learn.woniuxy.anno;


@A("admin")
public class AnnotationDemo {
	@A("xxxx")
	@Deprecated //过时
	public static void demo() {
		
	}
	
    public void demo(@A("xxxx") String str) {
		demo();
	}
    
    public static void main(String[] args) {
//    	@SuppressWarnings("unused") //禁止警告
//		@A("xxxx")
//		AnnotationDemo annotationDemo = new AnnotationDemo();
    	
    	//获取反射操作
    	//获取目标类Class实例
    	Class<AnnotationDemo> cl = AnnotationDemo.class;
    	//判断当前元素上是否存在注解
    	boolean re = cl.isAnnotationPresent(A.class);
    	System.out.println(re);
    	
    	if(re) {
    		//获取目标注解
    		A a= cl.getDeclaredAnnotation(A.class);
    		//获取注解成员变量值
    		System.out.println(a.value());
    		System.out.println(a.num());
    	}
	}
}
