package com.springmvc.frame.listener;

import java.util.Hashtable;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.springmvc.newpackage.result.Result;

/**
 * Application Lifecycle Listener implementation class UserListener
 *
 */
public class UserListener implements HttpSessionAttributeListener,HttpSessionListener{
	
	//存储用户账号与session
   Hashtable<Result, HttpSession> sessions = new Hashtable<Result, HttpSession>();
	
    public UserListener() {
    	
    }

	
    public void attributeAdded(HttpSessionBindingEvent se)  { 
    	checkUser(se);
    }
    	

    
    public synchronized void checkUser(HttpSessionBindingEvent se) {
    	//键
    	String key= se.getName();
    	System.out.println("===========监听器获取的键："+key);
    	//值
    	Object value = se.getValue();
    	System.out.println("============监听器获取的值（Object）："+value);
    	if(key.equals("user")) {
    		Result user = (Result)value;
        	System.out.println("============监听器获取的值（Result）："+user);
    		HttpSession session = se.getSession();
    		System.out.println("============session.id: "+session.getId());
    		HttpSession oldSession = sessions.get(user);
    		if(oldSession==null) {
    			System.out.println("======= oldSession==null 执行了该方法=====");
    		}else {
    			System.out.println("======= oldSession!=null 执行了该方法 OldSession.id: ====="+oldSession.getId());
    		}
    		
    		if(oldSession!=null && !oldSession.getId().equals(session.getId())){
    			System.out.println("=======执行了该方法=====");
    			oldSession.removeAttribute("user");
    		}
    		
    		sessions.put(user, session);

    	}
    }
    
    
    public void attributeRemoved(HttpSessionBindingEvent se)  { 
    	
    }
       

	
    public void attributeReplaced(HttpSessionBindingEvent se)  { 
    	checkUser(se);

    }


	@Override
	public void sessionCreated(HttpSessionEvent se) {
		
		
	}


	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		removeUser(se);
		
	}
	
	public synchronized void removeUser(HttpSessionEvent se) {
		HttpSession session = se.getSession();
		Object attr = session.getAttribute("user");
		if(attr!=null) {
			sessions.remove((Result)attr);
		}
	}
	
}
