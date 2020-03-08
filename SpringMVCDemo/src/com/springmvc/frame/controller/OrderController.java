package com.springmvc.frame.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.springmvc.frame.po.CartCommoPO;
import com.springmvc.frame.po.ItemCommoPO;
import com.springmvc.frame.po.ItemOrderPO;
import com.springmvc.frame.po.MailPO;
import com.springmvc.frame.po.OrderPO;
import com.springmvc.frame.po.ShoppingCartPO;
import com.springmvc.frame.po.UserPO;
import com.springmvc.frame.service.imp.CartServiceImp;
import com.springmvc.frame.service.imp.MailServiceImp;
import com.springmvc.frame.service.imp.OrderServiceImp;
import com.woniuxy.springmvc.annotation.framework.Controller;
import com.woniuxy.springmvc.annotation.handlermapping.RequestMapping;
import com.woniuxy.springmvc.annotation.handlermapping.ResponseBody;

@Controller
@RequestMapping("/order")
public class OrderController {
	// 生成订单
	@ResponseBody
	@RequestMapping("/creorder")
	public void createOrder(HttpServletRequest req,String m_name,String m_tel,String m_address) {

		// 获取session
		HttpSession session = req.getSession(false);
		// 获取session存入的属性值(登录时，存入了该属性)
		Object sessionAttribute = session.getAttribute("user");
		// 判断获取到的内容是否为空，如过为空，就能不能执行后面的操作
		if (sessionAttribute == null) {
			// return false;
			return;
		}
		// 该属性为登录用户的UserPO的对象
		UserPO userSessionAttr = (UserPO) sessionAttribute;
		// 得到该用户 的u_id
		int su_id = userSessionAttr.getU_id();

		// 生成商品订单
		// 获取邮件信息
		MailPO mailPO = new MailPO(m_name, m_tel, m_address, su_id);
		boolean insertMail = new MailServiceImp().getInsertMail(mailPO);
		if (!insertMail) {
			return;
		}
		

		// 首先获取到session中的购物车信息，返回CartPOs
		// Map<Integer, ShoppingCartPO> mapShoppingCart = (HashMap<Integer,
		// ShoppingCartPO>) session.getAttribute("cart");
		// 如果session中没有，就从数据库里面拿（暂时不考虑）
		List<CartCommoPO> listShoppingCart = null;
		// 如果session中没有
		// if (mapShoppingCart.size()<1) {
		// 通过数据库，获取到该用户的所有商品信息
		listShoppingCart = new CartServiceImp().getSearchCartCommoAllbyuid(su_id);
		System.out.println(listShoppingCart);
		// 如果没有数据，不再继续下去
		if (listShoppingCart == null) {
			return;
		}
		// 如果有，生成数据库的订单
		new OrderServiceImp().creatOrder(req, listShoppingCart, su_id);
		
		//清空购物车
		new CartServiceImp().getClearCart(su_id);
		// }
		// 如sesssion中有
		// 然后将CartPOs，uid交予service
		// new OrderServiceImp().creatOrder(req, mapShoppingCart, su_id);

	}
	
	
	
	
	// 查看所有订单（admin）
	
	// 发货（admin）

	
	
	
	
	
	// 查看订单详情（admin/user）
	@ResponseBody
	@RequestMapping("/showAll")
	public List<ItemCommoPO> showItemOrders(HttpServletRequest req,int o_id){
		List<ItemCommoPO> listItemCommoPO = null;
		// 获取session
		HttpSession session = req.getSession(false);
		// 获取session存入的属性值(登录时，存入了该属性)
		Object sessionAttribute = session.getAttribute("user");
		// 判断获取到的内容是否为空，如过为空，就能不能执行后面的操作
		if (sessionAttribute == null) {
			// return false;
			return null;
		}
		// 该属性为登录用户的UserPO的对象
		UserPO userSessionAttr = (UserPO) sessionAttribute;
		// 得到该用户 的u_id
		int su_id = userSessionAttr.getU_id();
		// 核心
		listItemCommoPO = new OrderServiceImp().showMyItemOrders(su_id, o_id);
		if(listItemCommoPO==null) {
			return null;
		}
		return listItemCommoPO;
	}
	
	
	
	
	// 查看我的订单
	@ResponseBody
	@RequestMapping("/show")
	public List<OrderPO> showMyOrders(HttpServletRequest req) {
		List<OrderPO> listOrderPO = null;
		// 获取session
		HttpSession session = req.getSession(false);
		// 获取session存入的属性值(登录时，存入了该属性)
		Object sessionAttribute = session.getAttribute("user");
		// 判断获取到的内容是否为空，如过为空，就能不能执行后面的操作
		if (sessionAttribute == null) {
			// return false;
			return null;
		}
		// 该属性为登录用户的UserPO的对象
		UserPO userSessionAttr = (UserPO) sessionAttribute;
		// 得到该用户 的u_id
		int su_id = userSessionAttr.getU_id();
		// 核心
		listOrderPO = new OrderServiceImp().showMyOrders(su_id);
		if(listOrderPO==null) {
			return null;
		}
		return listOrderPO;
		
	}
	// 签收订单
}
