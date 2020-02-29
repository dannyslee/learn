package com.springmvc.frame.service;

import com.springmvc.frame.po.UserPO;

public interface UserService {
	
	//获取dao的SearchUser的结果，处理后，交给Controller层
	UserPO getSearchLoginUser(String user, String password);
	
	//获取注册用户判断的结果，处理后交给Controller层
	UserPO getSearchRegiterUser(String user);
	
	
	boolean getInsertUser(String user, String password);

}
