package com.woniuxy.web.listener;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * Application Lifecycle Listener implementation class AttributeListener
 *
 */
public class AttributeListener implements HttpSessionAttributeListener, ServletContextAttributeListener, ServletRequestAttributeListener {
   
	public AttributeListener() {
    	
    }
	Map<String,HttpSession> map = new HashMap<>();
	
    public void attributeAdded(HttpSessionBindingEvent se)  { 
    	System.out.println("session发送属性添加时触发"+se.getName()+":"+se.getValue());
    	System.out.println("session:"+"["+se.getSession().getServletContext().getAttribute("account")+"]");
    	
    	
    }


    public void attributeRemoved(HttpSessionBindingEvent se)  { 
    	System.out.println("session发送属性移除时触发"+se.getName()+":"+se.getValue());

    } 
    
    public void attributeReplaced(HttpSessionBindingEvent se)  { 
    	//键相同，值不同时，发生替换
    	//Q:getValue是替换前的值，还是替换后的值
    	System.out.println("session发送属性替换时触发："+se.getName()+"原来的值："+se.getValue()+",替换为："+se.getSession().getAttribute(se.getName()));

    }

	
    
    
    public void attributeAdded(ServletContextAttributeEvent scae)  { 
    	
    }


    public void attributeRemoved(ServletContextAttributeEvent scae)  { 
    }

    public void attributeReplaced(ServletContextAttributeEvent scae)  { 
        
    }
	
    public void attributeRemoved(ServletRequestAttributeEvent srae)  { 
    }


    public void attributeAdded(ServletRequestAttributeEvent srae)  { 
    }


    public void attributeReplaced(ServletRequestAttributeEvent srae)  { 
    }


 

  
}
