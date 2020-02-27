package learn.woniuxy.web.servlethomework;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 获取账号密码，并插入数据
 * @author Administrator
 *
 */
public class RegisterServlet extends HttpServlet {

	
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		//super.init();
		System.out.println("init");
		//由服务器自动调用，用于对Servlet进行初始化工作，作用类似于构造方法（出生）
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.service(req, resp);
		System.out.println("service");
		//获取账号
		String account = req.getParameter("account");
		//获取密码
		String password = req.getParameter("password");
		//传建sql执行实例
		ExecJDBC jdbc = new ExecJDBC();
		//sql语句
		String sql = "INSERT INTO logins(l_user,l_password) VALUES (?,?)";
		//执行sql
		jdbc.sql(sql, account,password);
	
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		//super.destroy();
		System.out.println("destroy");
		// 由服务器自动调用，用于对Servlet占用资源进行释放（死亡）
		
	}
	
	
}
