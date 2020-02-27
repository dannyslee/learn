package learn.woniuxy.web.studentms.service;

import learn.woniuxy.web.studentms.dao.UserDAO;

public class LoginService {
	
	//登录检查结果的返回
	public String loginCheck(String account, String password) {
		String res = null;
		UserDAO userDAO = new UserDAO();
		String rpass = null;
		rpass = userDAO.checkLoginAccount(account, password);
		
		if(rpass!=null) {
			res = "登录成功";
		}else{
			res = "登录失败";
		}	
		return res;		
	}
}
