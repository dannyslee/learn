package com.woniuxy.web.listener;

import java.io.Serializable;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

/**
 * Application Lifecycle Listener implementation class BindingListener
 *
 */
public class BindingListener implements Serializable, HttpSessionBindingListener {

	private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    
    

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public BindingListener() {
    }

	
    public void valueBound(HttpSessionBindingEvent event)  { 
    	System.out.println("储存在session 触发");
    }

    public void valueUnbound(HttpSessionBindingEvent event)  { 
    	System.out.println("从session中移除  触发");
    }
	
}
