package com.woniuxy.homework;

public class GenericMethodDemo {
	public static <E extends Number,F extends Number> double add(E num1,F num2){
		return num1.doubleValue()+num2.doubleValue();
	}
	public static void main(String[] args) {
		System.out.println(add(2.6,5.6));
	}
}
