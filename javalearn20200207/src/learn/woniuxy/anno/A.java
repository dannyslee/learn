package learn.woniuxy.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//直接指定Retebtion
@Retention(RetentionPolicy.RUNTIME)
//@Target({ElementType.TYPE,ElementType.METHOD}) //只能修饰类与方法
public @interface A {
	//String name() default "admin";
	int num() default 0;
	String value();
	/*
	 * 1.注解中成员变量只能是基本数据类型，String Class Annotation、枚举，以及对应数组类型
	 * 2.在使用注解时，如果要赋值的成员变量只有一个，且变量名称为Value时，可不指定属性名，直接赋值
	 */
}
