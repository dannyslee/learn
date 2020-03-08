package com.springmvc.frame.controller;



import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.springmvc.frame.po.UserPO;
import com.springmvc.frame.service.UserService;
import com.springmvc.frame.service.imp.UserServiceImp;
import com.springmvc.frame.util.MD5Encoding;
import com.springmvc.frame.util.RegexUtil;
import com.springmvc.frame.util.SendMail;
import com.woniuxy.springmvc.annotation.framework.Controller;
import com.woniuxy.springmvc.annotation.handlermapping.RequestMapping;
import com.woniuxy.springmvc.annotation.handlermapping.ResponseBody;



@Controller
@RequestMapping("/user")
public class UserController {
	
	//private static final String PN = "KJJHda5565SDKAJKIJsadaEKKDdaNBKfa1445LAISJKFN44xaa4654AdsaHJadadKAAKesNJKdaddaXJJsfSJCssfD";
	
	/*
	 * 登录
	 */
	
	//登录方法
	//参数：req resp user password 验证码code
	//返回值：boolean 登录就成功与失败之分
	//默认只判空（保险），具体的正则判断，空值判断，交给过滤器
	@RequestMapping("/login")
	@ResponseBody //json
	public boolean login(HttpServletRequest req,HttpServletResponse resp,String user,String password,String loginCode) {
		boolean flag = false;
		System.out.println(user+password+loginCode);
		//判断空值
		if(user==null || password ==null || loginCode==null) {
			return false;
		}
		//获取浏览器session对象
		HttpSession session = req.getSession(false);
		
		//其余判断交给过滤器(过滤器最后实现,这里先将过滤写入Controller里)
		if(!checkLoginRegex(session,loginCode,user,password)) {
			return false;
		}
		
		//对password进行md加密
		String sqlPassword = MD5Encoding.upperMD5(password);
		//获取业务逻辑对象，实现业务逻辑判断
		UserService userLoginService  = new UserServiceImp();
		//通过账号+密码，获取数据库信息，判断是否为空
		UserPO searchUserPO = userLoginService.getSearchLoginUser(user,sqlPassword);
		//如果获取的数据不为空，说明找到了
		if(searchUserPO!=null) {
			//flag为真
			flag=true;
			//将信息存入session作用域
			session.setAttribute("user", searchUserPO);		
		}
		
		return flag ;	
	}
	
	
	/*
	 * 注册
	 */
	@ResponseBody
	@RequestMapping("/register")
	public String register(HttpServletRequest req,HttpServletResponse resp,String user,String password) {
		
		//注册反馈
		String res = null;
		
		//判断空值
	    if(user==null || password ==null) {
			return res;
		}
	    
		//获取浏览器session
		//HttpSession session = req.getSession();
		//过滤器筛选（暂时在Controller层实现）
		//如果返回空，说明满足基本正则
		if(checkRegisterRegex(req,resp,user,password)==null) {
			//可优化的地方：使用文档流的方式，读取邮件的不关键信息
			
			//通过账号进行查询，如果不为空，不允许注册
			UserService userRegisterService =  new UserServiceImp();
			if(!(userRegisterService.getSearchRegiterUser(user).getU_user()==null)){
				return "该账号已存在";
			}
			//编辑邮件文本内容
			String mailContent = "请点击该链接完成验证：http://localhost:8080/SpringMVCDemo/controller/user/realRegister?u="+user+"&ADBCJJJHIKNBCDEFY="+MD5Encoding.upperMD5(password);
			//执行邮箱发送功能
			try {
				new SendMail().send(user, "LibrarySHO：请查收您的注册验证信息", mailContent);
			} catch (AddressException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//请求转发到邮件发送界面
			return "一封验证信息已发送至您的邮箱，请注意查收";
		}		
		return res;
	}
	
	
	//邮箱实际业务实现方法
	@RequestMapping("/realRegister")
	@ResponseBody
	public boolean realRegister(String u,String ADBCJJJHIKNBCDEFY) {
		boolean flag = false;
		//处理逻辑层的业务
		//通过账号进行查询，如果不为空，不允许注册
		UserService userRegisterService =  new UserServiceImp();
		if(!(userRegisterService.getSearchRegiterUser(u).getU_user()==null)){
			return false;
		}
		//如果没有，执行插入，并得到一个成功与否的反馈（是否为false）
		boolean insertUser = userRegisterService.getInsertUser(u,ADBCJJJHIKNBCDEFY);
		//若返回值不为false
		if(insertUser) {
			flag = true;
		}
		return flag;		
	}
	
	
	
	
	
	
	private String checkRegisterRegex(HttpServletRequest req, HttpServletResponse resp, String user, String password) {
		String res = null;

		// 判断数据合法性
		// 检测账号合法性(不用电话，使用邮箱)
		if (!user.matches(RegexUtil.REGEX_EMAIL)) {
			return "账号不合法";
		}

		// 检测密码合法型
		if (!password.matches(RegexUtil.REGEX_PASSWORD)) {
			return "密码不安全，请使用组合密码";
		}

		return res;
	}


	/*
	 * 过滤器方法
	 */
	
	//暂时的过滤器方法
	public boolean checkLoginRegex(HttpSession session,String code,String user,String password) {
		boolean flag = true;
		
		
		// 判断数据合法性
		//检测账号合法性(不用电话，使用邮箱)
		if(!user.matches(RegexUtil.REGEX_EMAIL)) {
			System.out.println("账号不合法");
			return false;
		}
		
		//检测密码合法型
		if(!password.matches(RegexUtil.REGEX_PASSWORD)) {
			System.out.println("密码不合法");
			return false;
		}
		
		
		// 获取验证码信息
		Object sessionLoginPic = session.getAttribute("loginCode");
		String sessionLoginPicStr = (String) sessionLoginPic;
		System.out.println(sessionLoginPicStr);
		// 若为空，返回false
		if (sessionLoginPic == null) {
			return false;
		}
		//若不为空,先删除存入的验证码
		session.removeAttribute("loginCode");
		//将sessionloginPic转化为String类型，为对比用户输入的验证码做准备
		//String sessionLoginPicStr = (String) sessionLoginPic;
		//System.out.println(sessionLoginPicStr);
		// 对比得到的验证码，是否为session存着的验证码	
		if(!sessionLoginPicStr.equalsIgnoreCase(code)) {//不区分大小写的比较：equalsIgnoreCase
			//若不等于
			return false;
		}
		
		
	
		//全部合法，返回true
		return flag;
	}

	
	

	
}
