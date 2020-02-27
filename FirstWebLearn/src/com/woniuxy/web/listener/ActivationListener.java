package com.woniuxy.web.listener;

import java.io.Serializable;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;

/**
 * Application Lifecycle Listener implementation class ActivationListener
 *
 */
public class ActivationListener implements Serializable, HttpSessionActivationListener {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	/**
     * Default constructor. 
     */
    public ActivationListener() {
        // TODO Auto-generated constructor stub
    }
    
    public void sessionWillPassivate(HttpSessionEvent se)  { 
        
    	System.out.println("序列化时执行（钝化）");

    }
	
    public void sessionDidActivate(HttpSessionEvent se)  { 
    	System.out.println("反序列化时执行(活化)");
    }


   
	
}
