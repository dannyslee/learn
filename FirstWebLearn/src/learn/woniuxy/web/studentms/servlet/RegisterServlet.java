package learn.woniuxy.web.studentms.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import learn.woniuxy.web.studentms.service.RegisterService;
import learn.woniuxy.web.studentms.util.CheckUtil;

public class RegisterServlet extends HttpServlet {
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("service");
		
		//设置编码
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("Text/html;charset=utf8");
		
		//获取账号密码
		String acc = req.getParameter("account");
		String pass = req.getParameter("password");
		String rpass = req.getParameter("rpass");
		PrintWriter pw = resp.getWriter();
		
		String res = null;
		//判断密码是否一致
		if(!(pass.equals(rpass))) {
			res = "密码不一致";
			pw.write(res);
			pw.flush();
			pw.close();
			return;		
		}
		//账号密码正则检查
		if(CheckUtil.checkAccountAndPassword(acc, pass)==false){
			res = "密码或账号不符合规则";
			pw.write(res);
			pw.flush();
			pw.close();
			return;		
		}
		
		//登录检测
		RegisterService rs = new RegisterService();
		res = rs.registerCheck(acc, pass);
		
		//响应提示
		pw.write(res);
		pw.flush();
		pw.close();
		
	}
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("init");
	}


	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("destory");
	}
	
	
}
