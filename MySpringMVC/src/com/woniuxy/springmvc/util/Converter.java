package com.woniuxy.springmvc.util;

public interface Converter<K,T> {
	/**
	 * 实现数据转换
	 * @param t 数据类型，建议以数组形式传入
	 * @return 封装的po对象
	 */

	Object convert(K k,T t);
}
