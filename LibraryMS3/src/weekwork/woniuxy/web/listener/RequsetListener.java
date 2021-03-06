package weekwork.woniuxy.web.listener;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class RequsetListener
 *
 */
public class RequsetListener implements ServletRequestListener, HttpSessionListener, ServletContextListener {
	
	//设置线程
	private static ThreadLocal<HttpServletRequest> httpServletRequestHolder = 
	         new ThreadLocal<HttpServletRequest>();
	
	public Map<String,String> requestHeader = new HashMap<String,String>();


    public RequsetListener() {
    }


    public void sessionCreated(HttpSessionEvent se)  { 
    }


    public void requestDestroyed(ServletRequestEvent sre)  { 
    	 httpServletRequestHolder.remove();//清楚资源引用
    }


    public void requestInitialized(ServletRequestEvent sre)  { 
    	//当request对象被创建
    	HttpServletRequest req = (HttpServletRequest) sre.getServletRequest(); 
    	//获取数据
    	//获取URI
    	String requestURI = req.getRequestURI();
    	//获取请求方法
    	String method = req.getMethod(); 
    	//String context = 
    	System.out.println("监听器："+requestURI+":"+method);
    	//存储到Map中
    	//requestHeader.put(requestURI, method);
    	
    	//绑定到当前线程
    	httpServletRequestHolder.set(req);
    	
    }


    public void sessionDestroyed(HttpSessionEvent se)  { 
    
    }


    public void contextDestroyed(ServletContextEvent sce)  { 
    }


    public void contextInitialized(ServletContextEvent sce)  { 
    }
	
}
