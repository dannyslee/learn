package com.springmvc.frame.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtil {
	//数据库时间类型转换、
	//时间处理
			public static Timestamp dateToSqlDate(Date date) {
				String strDate = dateToStr(date,"yyyy-MM-dd HH:mm:ss");
				return strToSqlDate(strDate,"yyyy-MM-dd HH:mm:ss");		
			}

			private static Timestamp strToSqlDate(String strDate, String string) {
				DateFormat df = new SimpleDateFormat(string);		
		        Date date = null;
		        try {
					date = df.parse(strDate);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return new Timestamp(date.getTime());
			}

			private static String dateToStr(Date date, String string) {
				DateFormat df = new SimpleDateFormat(string);		
				return df.format(date);
			}
}
