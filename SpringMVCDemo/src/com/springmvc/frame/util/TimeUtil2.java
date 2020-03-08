package com.springmvc.frame.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtil2 {
	// 数据库时间类型转换、
	// 时间处理
	public static Timestamp dateToSqlDate(Date date) {
		String strDate = dateToStr(date);
		return strToSqlDate(strDate);
	}

	public static Timestamp strToSqlDate(String strDate) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = null;
		try {
			date = df.parse(strDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new Timestamp(date.getTime());
	}

	public static String dateToStr(Date date) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return df.format(date);
	}
}
