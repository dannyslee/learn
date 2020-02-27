package learn.woniuxy.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;

public class ReflectUserTest {
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		//获取目标类实例
		Class<UserPO> user = UserPO.class;	
		
		//获取目标类的所有构造器
		//Constructor<UserPO>[] cons = user.getDeclaredConstructors();
		//获取有参构造
		Constructor<UserPO> con = user.getDeclaredConstructor(int.class,String.class,String.class);
		//获取无参构造
		Constructor<UserPO> conN = user.getDeclaredConstructor();
		
		// 调用有参构造器创建目标类对象
		UserPO po = con.newInstance(1, "admin", "123");
		//System.out.println(po);
		// 调用无参构造器创建目标类对象
		UserPO poN = conN.newInstance();
		//System.out.println(poN);
		
		//法二:直接创建对象
		//UserPO pox1 = user.newInstance();
		//UserPO pox2 = user.newInstance(1, "admin", "123");
		
		//输出
		//System.out.println(po);
		
		StringBuilder sb = new StringBuilder();
		//获取类修饰符
		sb.append(Modifier.toString(user.getModifiers())+" class ");
		//获取类名
		sb.append(user.getSimpleName()+" implements ");
		//获取父接口名称
		sb.append(user.getInterfaces()[0].getSimpleName()+"{\n");
		//获取构造器信息
		Constructor<UserPO>[] cons = (Constructor<UserPO>[]) user.getDeclaredConstructors();
		
		//获取本类所有属性
		Field[] fields = user.getDeclaredFields();
		for(Field field:fields) {
			//获取是属性修饰符
			sb.append(Modifier.toString(field.getModifiers())+" ");
			//获取属性类型的类名
			sb.append(field.getType().getSimpleName()+" ");
			//获取属性名称
			sb.append(field.getName()+"; \n");
		}
		
		//获取本类所有方法
		Method[] methods = user.getDeclaredMethods();
		for(Method me:methods) {
			//获取方法修饰符
			sb.append(Modifier.toString(me.getModifiers())+" ");
			//获取方法返回值类型名称
			sb.append(me.getReturnType().getSimpleName()+" ");
			//获取方法名称
			sb.append(me.getName()+" (");
			//获取方法参数列表
			Parameter[] paramsM = me.getParameters();
			for (Parameter paramM : paramsM) {
				//获取参数类型名称
				sb.append(paramM.getType().getSimpleName()+" ");
				//获取参数名字
				sb.append(paramM.getName());
			}
			sb.append(");\n");
		}
		
		
		for(Constructor<UserPO> conU:cons) {
			sb.append(Modifier.toString(conU.getModifiers())+" ");
			sb.append(user.getSimpleName());
			sb.append("(");
			Parameter[] params = conU.getParameters();
			for(int i=0;i<params.length;i++) {
				sb.append(params[i].getType().getSimpleName()+" ");
				sb.append(params[i].getName());
				if(i<params.length-1) {
					sb.append(",");
				}
			}
			sb.append("){ }\n");
		}
		sb.append("\n}");
		System.out.println(sb);

	}
	
	
	
}
