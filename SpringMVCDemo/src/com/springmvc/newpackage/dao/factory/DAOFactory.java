package com.springmvc.newpackage.dao.factory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.springmvc.newpackage.dao.CartDAOImp;
import com.springmvc.newpackage.dao.CommoDAOImp;
import com.springmvc.newpackage.dao.CommoTypeDAOImp;
import com.springmvc.newpackage.dao.ItemOrderDAOImp;
import com.springmvc.newpackage.dao.MailDAOImp;
import com.springmvc.newpackage.dao.OrderDAOImp;
import com.springmvc.newpackage.dao.UserDAOImp;
import com.springmvc.newpackage.dao.intface.DAO;


public class DAOFactory {
	
	/*
	 * user=com.springmvc.newpackage.dao.UserDAOImp
       cart=com.springmvc.newpackage.dao.CartDAOImp
       commo=com.springmvc.newpackage.dao.CommoDAOImp
       item=com.springmvc.newpackage.dao.ItemOrderDAOImp
       mail=com.springmvc.newpackage.dao.MailDAOImp
       order=com.springmvc.newpackage.dao.OrderDAOImp
	 */
	
	//将所有对象放入
	private DAO dao;
//	private UserDAOImp user;
//	private CartDAOImp cart;
//	private CommoDAOImp commo;
//	private ItemOrderDAOImp itenOrder;
//	private MailDAOImp mail;
//	private OrderDAOImp order;
	
	
	
	private DAOFactory(String className) {
		try {
			InputStream resourceAsStreams = DAOFactory.class.getClassLoader().getResourceAsStream("dao.properties");
			Properties prop = new Properties();
			System.out.println(resourceAsStreams);
			prop.load(resourceAsStreams);
			
			String daoClassName = prop.getProperty(className);
			dao = (DAO)Class.forName(daoClassName).newInstance();
		} catch (IOException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
	
	private static DAOFactory instance;
	
	public static DAOFactory getInstance(String className) {		
		return new DAOFactory(className);
	}


	public UserDAOImp getUser() {
		return (UserDAOImp)dao;
	}

	public CartDAOImp getCart() {
		return (CartDAOImp)dao;
	}

	public CommoDAOImp getCommo() {
		return (CommoDAOImp)dao;
	}

	public ItemOrderDAOImp getItemOrder() {
		return (ItemOrderDAOImp)dao;
	}

	public MailDAOImp getMail() {
		return (MailDAOImp)dao;
	}

	public OrderDAOImp getOrder() {
		return (OrderDAOImp)dao;
	}
	
	public CommoTypeDAOImp getCommoType() {
		return (CommoTypeDAOImp)dao;	
	}

	public static DAOFactory getInstance() {
		return instance;
	}
	
	
	
}
