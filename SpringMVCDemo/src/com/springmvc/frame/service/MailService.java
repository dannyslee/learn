package com.springmvc.frame.service;

import java.sql.Connection;

import com.springmvc.frame.po.MailPO;

public interface MailService {
	boolean getInsertMail(MailPO mail);
}
