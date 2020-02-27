package learn.woniuxy.web.studentms.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import learn.woniuxy.web.studentms.po.ClassPO;
import learn.woniuxy.web.studentms.po.View_AllStudentsPO;
import learn.woniuxy.web.studentms.service.ClassService;
import learn.woniuxy.web.studentms.service.StudentService;

public class ClassServlet extends HttpServlet{

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
		List<ClassPO> classes = null;
		//更新前班级信息获取
		if(oper.equals("updateStu")) {
			classes = new ClassService().showAll();
			req.setAttribute("classes", classes);
			String s_id= req.getParameter("s_id");
			String s_name= req.getParameter("s_name");
			String s_age= req.getParameter("s_age");
			String s_sex= req.getParameter("s_sex");
			String s_phone= req.getParameter("s_phone");
			String s_no= req.getParameter("s_no");
			String s_class= req.getParameter("s_class");

			req.getRequestDispatcher("jsp/updateStu.jsp?s_id="+s_id+"&s_name="+s_name+"&s_age="+s_age+"&s_sex="+s_sex+"&s_phone="+s_phone+"&s_no="+s_no+"&s_class="+s_class).forward(req, resp);
			
		}else if(oper.equals("insertStu")) {
			//res = insert(req,resp);
			classes = new ClassService().showAll();
			req.setAttribute("classes", classes);
			req.getRequestDispatcher("jsp/insertStudent.jsp").forward(req, resp);
			
		}else if(oper.equals("search")) {
			List<View_AllStudentsPO> stus = new StudentService().showAllStudents();
			//将信息写入requset作用域名
			req.setAttribute("stus", stus);
			//请求转发
			req.getRequestDispatcher("jsp/NewFile.jsp");
		}else if(oper.equals("deleteStu")) {
			//res = insert(req,resp);
//			classes = new ClassService().showAll();
//			req.setAttribute("classes", classes);
//			String s_id= req.getParameter("s_id");
//			req.getRequestDispatcher("jsp/NewFile.jsp?s_id="+s_id).forward(req, resp);
		}
	}


	
}
