package learn.woniuxy.web.studentms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import learn.woniuxy.web.studentms.po.ClassPO;
import learn.woniuxy.web.studentms.po.View_AllStudentsPO;
import learn.woniuxy.web.studentms.service.ClassService;
import learn.woniuxy.web.studentms.service.StudentService;

/**
 * Servlet implementation class StudentServlet
 */
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//设置编码
				resp.setCharacterEncoding("utf-8");
				req.setCharacterEncoding("utf-8");
				//获取页面参数
				String oper = req.getParameter("oper");
				
				String res = "操作失败";
				//判断非空
				if(oper==null) {
					res="失败";
					return;
				}
				//更新前班级信息获取
				if(oper.equals("update")) {
					System.out.println("update");
					res = update(req,resp);
					
				}else if(oper.equals("insert")) {
					res = insert(req,resp);
				}else if(oper.equals("search")) {
//					List<View_AllStudentsPO> stus = new StudentService().showAllStudents();
//					//将信息写入requset作用域名
//					req.setAttribute("stus", stus);
//					//请求转发
//					req.getRequestDispatcher("jsp/NewFile.jsp").forward(req, resp);;
				}else if(oper.equals("delete")) {
					res = delete(req,resp);
				}
				//返回提醒（控制台）
				List<View_AllStudentsPO> stus = new StudentService().showAllStudents();
				//将信息写入requset作用域名
				req.setAttribute("stus", stus);
				//请求转发
				req.getRequestDispatcher("jsp/NewFile.jsp").forward(req, resp);
				
				//返回提醒res
//				resp.setContentType("Text/html;charset=UTF-8");
//				PrintWriter pw = resp.getWriter();			
//				pw.print(res);
	}


	private String delete(HttpServletRequest req, HttpServletResponse resp) {
		String res = "删除失败";
		// 接受客户端传参
		String s_id = req.getParameter("s_id");
		// 检查
		int ss_id= 0;
		try {
			ss_id= Integer.parseInt(s_id);
		} catch (Exception e) {
			return res;
		}

		res = new StudentService().delete(ss_id);
		
		return res;
	}


	private String insert(HttpServletRequest req, HttpServletResponse resp) {
		String res = "插入失败！";
		//接受客户端传参
		String s_name= req.getParameter("s_name");
		String s_age= req.getParameter("s_age");
		String s_sex= req.getParameter("s_sex");
		String s_phone= req.getParameter("s_phone");
		String s_no= req.getParameter("s_no");
		System.out.println(s_name+s_age+s_sex+s_phone+s_no);
		//检查
		int ss_age=0;
		int ss_no=0;
		try {
			ss_age = Integer.parseInt(s_age);
			ss_no = Integer.parseInt(s_no);
			} catch (Exception e) {
				res="不合法";
			}
				
		res = new StudentService().insert(s_name,s_sex,ss_age,s_phone,ss_no);
		return res;
	}

	private String update(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		String res = "更新失败";
		//

		//获取更新的学生信息
		String s_id= req.getParameter("s_id");
		String s_name= req.getParameter("s_name");
		String s_age= req.getParameter("s_age");
		String s_sex= req.getParameter("s_sex");
		System.out.println(s_sex);
		String s_phone= req.getParameter("s_phone");
		String s_no= req.getParameter("s_no");
		String s_class= req.getParameter("s_class");
		System.out.println(s_id+s_name+s_age+s_sex+s_phone+s_no+s_class);
		//检查
		int ss_id=0;
		int ss_age=0;
		int ss_no=0;
		try {
			ss_id = Integer.parseInt(s_id);
			ss_age = Integer.parseInt(s_age);
			ss_no = Integer.parseInt(s_no);
	
		} catch (Exception e) {
			res="不合法";
		}
		
		res = new StudentService().update(ss_id,s_name,s_sex,ss_age,s_phone,ss_no,s_class);
		return res;
	}
       
   

}
