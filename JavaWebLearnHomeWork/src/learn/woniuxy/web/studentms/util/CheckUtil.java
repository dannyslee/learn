package learn.woniuxy.web.studentms.util;

public class CheckUtil {
	
	public static boolean checkAccountAndPassword(String account,String password) {
		
		if(account==null && password ==null){
			return false;
		}
		
		if(account.matches(RegexUtil.REGEX_USERNAME)) {
			return true;
		}
		
		if(password.matches(RegexUtil.REGEX_PASSWORD)) {
			return true;
		}
		return false;
	}
}
