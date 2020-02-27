package learn.woniuxy.web.studentms.dao;


import learn.woniuxy.web.studentms.util.ExecJDBC;



public class UserDAO {
	
	/**
	 * 检查登录的sql执行
	 * @param account 账号
	 * @param pass 密码
	 * @return 密码值 or null
	 */
	public String checkLoginAccount(String account,String pass) {
		
		String sql = "select l_id from logins where l_password = ? and l_user = ?";
		ExecJDBC exec = new ExecJDBC();
		boolean flag = exec.sql(sql, pass,account);
		String rpass = null;
		if(flag) {
			rpass = pass;
			return rpass;
		}
		return rpass;
	}
	/**
	 * 更加普世的sql执行登录检查
	 * @param account
	 * @param pass
	 * @return
	 */
    public Boolean checkLoginAccount(Object account,Object pass) {
		
		String sql = "select l_id from logins where l_password = ? and l_user = ?";
		ExecJDBC exec = new ExecJDBC();
		boolean flag = exec.sql(sql, pass,account);
		return flag;
	}
	
	/**
	 * 检查注册的sql执行
	 * @param account 账号
	 * @param password 密码
	 * @return 成功 true，失败false
	 */
	public Boolean checkRegisterAccount(String account,String password) {
		String sql = "insert into logins(l_user,l_password) values(?,?)";
		boolean flag = new ExecJDBC().sql(sql, account,password);
		return flag;
	}
	
	/**
	 * 检查注册的sql执行（更加普世）
	 * @param account 账号
	 * @param password 密码
	 * @return 成功 true，失败false
	 */
	public Boolean checkRegisterAccount(Object account,Object password) {
		String sql = "insert into logins(l_user,l_password) values(?,?)";
		boolean flag = new ExecJDBC().sql(sql, account,password);
		return flag;
	}
}
