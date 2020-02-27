package learn.woniuxy.web.studentms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import learn.woniuxy.web.studentms.po.View_AllStudentsPO;
import learn.woniuxy.web.studentms.service.LoginService;
import learn.woniuxy.web.studentms.service.StudentService;
import learn.woniuxy.web.studentms.util.CheckUtil;
import learn.woniuxy.web.studentms.util.RegexUtil;

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
		
		//将业务逻辑处理结果返回给客户端，生成响应内容
		if(res.contains("成功")) {
			//如果登录成功，获取所有学生信息
			List<View_AllStudentsPO> stus = new StudentService().showAllStudents();
			//检查是否获取到所有学生信息
			System.out.println(stus);
			//向客户端写出所有学生信息
			//设置request作用域
			HttpSession session = req.getSession();
			session.setAttribute("account", acc);
			System.out.println(session.getId());
			req.setAttribute("stus",stus);
			//请求转发
			req.getRequestDispatcher("jsp/index.jsp").forward(req, resp);
//			StringBuilder sb = new StringBuilder();
//			sb.append("");
//			for(View_AllStudentsPO v_allStu:stus) {
//				sb.append(v_allStu.getS_id());
//				sb.append(v_allStu.getS_name());
//			    pw.write(sb.toString());
//			    pw.flush();
//				pw.close();
//			}
		}
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
