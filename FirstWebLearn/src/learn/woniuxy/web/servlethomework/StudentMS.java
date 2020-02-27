package learn.woniuxy.web.servlethomework;


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 写入html
 * @author Administrator
 *
 */

public class StudentMS extends HttpServlet {

	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		//super.init();
		System.out.println("init");
		//由服务器自动调用，用于对Servlet进行初始化工作，作用类似于构造方法（出生）
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		resp.setContentType("Text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		out.print("<html>");
		out.print("<head><title>Servlet</title></head>");
		out.print("<body>");
		out.print("<center>");
		out.print("<form action=\"/FirstWebLearn/login\" method=\"post\">");
		out.print("<input type=\"text\" id=\"account\" name=\"account\"/> </br>");
		out.print("<input type=\"password\" id=\"pass\" name=\"password\"/> </br>");
		out.print("<input type=\"submit\" value=\"submint\"/>");
		out.print("</form>");
		out.print("</center>");
		out.print("</body>");
		out.print("</html>");
		
		//System.out.println(req.getParameter("account"));//获取html数据 name
			
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		// super.destroy();
		System.out.println("destroy");
		// 由服务器自动调用，用于对Servlet占用资源进行释放（死亡）
		
	}

}
