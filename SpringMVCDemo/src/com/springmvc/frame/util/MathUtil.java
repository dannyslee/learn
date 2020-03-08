package com.springmvc.frame.util;

import java.math.BigDecimal;

public class MathUtil {
	public static BigDecimal mul(int s_num,BigDecimal price){   
		BigDecimal b1 = new BigDecimal(Integer.toString(s_num));   
		return b1.multiply(price);   
		
	}   
}
