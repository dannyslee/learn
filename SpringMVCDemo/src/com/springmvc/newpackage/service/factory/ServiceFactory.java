package com.springmvc.newpackage.service.factory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.springmvc.newpackage.service.CartServiceImp;
import com.springmvc.newpackage.service.CommoServiceImp;
import com.springmvc.newpackage.service.CommoTypeServiceImp;
import com.springmvc.newpackage.service.ItemOrderServiceImp;
import com.springmvc.newpackage.service.MailServiceImp;
import com.springmvc.newpackage.service.OrderServiceImp;
import com.springmvc.newpackage.service.UserServiceImp;
import com.springmvc.newpackage.service.intface.Service;

public class ServiceFactory {
	
	private Service service;
	
//	private UserServiceImp user;
//	private CartServiceImp cart;
//	private CommoServiceImp commo;
//	private ItemOrderServiceImp itenOrder;
//	private MailServiceImp mail;
//	private OrderServiceImp order;
//	
	
	private ServiceFactory(String className) {
		try {
			InputStream resourceAsStreams = ServiceFactory.class.getClassLoader().getResourceAsStream("service.properties");
			Properties prop = new Properties();
			System.out.println(resourceAsStreams);
			prop.load(resourceAsStreams);
			
			String serviceClassName = prop.getProperty(className);
			System.out.println("daoClassName:"+serviceClassName);
			service = (Service)Class.forName(serviceClassName).newInstance();
		} catch (IOException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
	
	private static ServiceFactory instance;
	
	public static ServiceFactory getInstance(String className) {
		return new ServiceFactory(className);
	}

	public UserServiceImp getUser() {
		return (UserServiceImp)service;
	}

	public CartServiceImp getCart() {
		return (CartServiceImp)service;
	}

	public CommoServiceImp getCommo() {
		return (CommoServiceImp)service;
	}

	public ItemOrderServiceImp getItenOrder() {
		return (ItemOrderServiceImp)service;
	}

	public MailServiceImp getMail() {
		return (MailServiceImp)service;
	}

	public OrderServiceImp getOrder() {
		return (OrderServiceImp)service;
	}
	
	public CommoTypeServiceImp getCommoType() {
		return (CommoTypeServiceImp)service;
	}

	public static ServiceFactory getInstance() {
		return instance;
	}
	
	
	
	
}
