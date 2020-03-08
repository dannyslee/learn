package com.springmvc.frame.dao;

import java.sql.Connection;

import com.springmvc.frame.po.MailPO;

public interface MailDAO {
	
	//生成订单时，添加
	boolean insertMail(Connection con, MailPO mail);
}
