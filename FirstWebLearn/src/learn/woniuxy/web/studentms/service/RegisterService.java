package learn.woniuxy.web.studentms.service;

import learn.woniuxy.web.studentms.dao.UserDAO;

public class RegisterService {
	//注册检查结果的返回
	public String registerCheck(String account, String password) {
		String res = null;
		UserDAO userDAO = new UserDAO();
		Boolean flag = userDAO.checkRegisterAccount(account, password);
		
		if(flag) {
			res = "注册成功";
		}else{
			res = "注册失败";
		}	
		return res;		
	}
}
