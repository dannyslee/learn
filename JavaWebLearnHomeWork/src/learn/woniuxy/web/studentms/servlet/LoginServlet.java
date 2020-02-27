package learn.woniuxy.web.studentms.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import learn.woniuxy.web.studentms.service.LoginService;
import learn.woniuxy.web.studentms.util.CheckUtil;

public class LoginServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.service(req, resp);
		System.out.println("service");
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("Text/html;charset=utf8");

		String acc = req.getParameter("account");
		String pass = req.getParameter("password");
		PrintWriter pw = resp.getWriter();
		
		String res=null;
		//账号密码正则检查
		if(CheckUtil.checkAccountAndPassword(acc, pass)==false){
			res = "密码或账号不符合规则";
			pw.write(res);
			pw.flush();
			pw.close();
			return;	
		}
		
		//登录检测
		LoginService ls = new LoginService();
		res = ls.loginCheck(acc, pass);
		
		//响应提示
		pw.write(res);
		pw.flush();
		pw.close();
	}
	

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		//super.init();
		System.out.println("init");

	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		//super.destroy();
		System.out.println("destroy");
	}

	
}
