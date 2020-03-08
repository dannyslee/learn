package com.springmvc.frame.service.imp;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import com.springmvc.frame.dao.ItemOrderDAO;
import com.springmvc.frame.dao.OrderDAO;
import com.springmvc.frame.dao.imp.CommoditityDAOImp;
import com.springmvc.frame.dao.imp.ItemOrderDAOImp;
import com.springmvc.frame.dao.imp.OrderDAOImp;
import com.springmvc.frame.po.CartCommoPO;
import com.springmvc.frame.po.ItemCommoPO;
import com.springmvc.frame.po.ItemOrderPO;
import com.springmvc.frame.po.OrderPO;
import com.springmvc.frame.po.ShoppingCartPO;
import com.springmvc.frame.util.C3P0Util;
import com.springmvc.frame.util.MathUtil;
import com.springmvc.frame.util.TimeUtil;

public class OrderServiceImp {
	
	//OrderService需要用到订单项 & 订单
	private OrderDAO orderDAO = new OrderDAOImp();
	
	private ItemOrderDAO itemOrderDAO = new ItemOrderDAOImp(); 
	
	
	//如果是session
	public void creatOrder(HttpServletRequest req,Map<Integer, ShoppingCartPO> mapShoppingCart, int su_id) {
		
		//数据库连接
		Connection con = C3P0Util.getConnection();
		
		//创建订单对象
		//订单号，唯一：创建时间+用户id
		String o_no = System.currentTimeMillis()+""+su_id;
		System.out.println("o_no:"+o_no);
		Timestamp dateToSqlDate = TimeUtil.dateToSqlDate(new Date());
		OrderPO orderPO = new OrderPO(o_no, dateToSqlDate, 0, su_id);
		//数据库创建订单
		if(mapShoppingCart.isEmpty()) {
			return;
		}
		orderDAO.saveOrder(con, orderPO);
		
		//创建订单项
		//Map迭代器取得购物车信息
		Set<Entry<Integer,ShoppingCartPO>> es = mapShoppingCart.entrySet();
		Iterator<Entry<Integer,ShoppingCartPO>> it =es.iterator();
		while(it.hasNext()) {
			Entry<Integer, ShoppingCartPO> nt = it.next();
			//获取每一份订单项目
			ShoppingCartPO cart = nt.getValue();
			//实际价格，等于数量X价格
			BigDecimal priceXs_num = MathUtil.mul(cart.getS_num(), cart.getSesssin_price());
			ItemOrderPO itemOrderPO = new ItemOrderPO(cart.getSc_id(), cart.getS_num(), priceXs_num, orderPO.getO_id());
			//保存到数据库
			itemOrderDAO.saveOrderItem(con,itemOrderPO);
		}
		//删除订单
		//session中的需要删除
		req.getSession().removeAttribute("cart");
		//数据库里面也要删除
		new CartServiceImp().getClearCart(su_id);
		
		
		//关闭连接
		C3P0Util.close(con);
	}
	
	
	private BigDecimal totolprice;
	
	
	//方法：数据回滚
	public void rollback(Connection con) {
		/*
		 * 建议使用try...catch,将失败场景放入，最后进行回滚
		 *    注意：再回滚前的业务，没有问题，执行提交
		 */
		try {
			con.rollback();
			con.setAutoCommit(true);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//如果是数据库
	public boolean creatOrder( HttpServletRequest req,List<CartCommoPO> listShoppingCart,int su_id) {
		
		
		
		//数据有效性检查
		
		//邮寄地址判断
//		if(mailId<1) {
//			return "邮寄地址错误";
//		}
		
		
		//数据库连接
		Connection con = C3P0Util.getConnection();		
		
		/*
		 * 事务
		 *   关闭自动提交
		 */
		//创建订单对象
		//订单号，唯一：创建时间+用户id
		String o_no = System.currentTimeMillis()+""+su_id;
		System.out.println("o_no:"+o_no);
		try {
			con.setAutoCommit(false);
			Timestamp dateToSqlDate = TimeUtil.dateToSqlDate(new Date());
			OrderPO orderPO = new OrderPO(o_no, null, dateToSqlDate, null, 0, su_id);
			if(listShoppingCart.isEmpty()) {
				return false;
			}
			//插入订单数据
			boolean saveOrderFlag = orderDAO.saveOrder(con, orderPO);
			System.out.println("saveOrderFlag:"+saveOrderFlag);
			//判断插入清空
			if(!saveOrderFlag) {
				return false;
			}
			/*
			 * 插入订单项数据
			 *   计算总额
			 *   查询订单编号
			 *   购物车商品价格与实际商品价格判断
			 */	
			for (CartCommoPO cart : listShoppingCart) {
				
				//价格判断-->未存入session无法判断
				//if(cart.getC_price().compareTo(carts.getSesssin_price()){};
				
				
				//库存检查
				//当前库存-购物车数量
				int number = cart.getC_stock()-cart.getS_num();
				System.out.println("number:"+number);
				if(number<0) {
					return false;
				}
				
				//库存更新
				boolean updateStockByid = new CommoditityDAOImp().updateStockByid(con,cart.getSc_id(), number);
				if(!updateStockByid) {
					return false;
				}
				
				//实际价格，等于数量X价格
				System.out.println("cart c_id:"+cart.getSc_id());			
				//从视图获取商品表价格		
				BigDecimal priceXs_num = MathUtil.mul(cart.getS_num(), cart.getC_price());
				//要从数据库里获取orderid
				List<OrderPO> searchOrdersByUserId = orderDAO.searchOrdersByUserId(con, su_id);
				for (OrderPO order:searchOrdersByUserId) {
					//查询订单号
					if(order.getO_id()<1) {
						return false;
					}
					//如果当前获取到的订单号=设定的订单号，进行商品项的添加
					if(order.getO_no().equals(o_no)) {
						ItemOrderPO itemOrderPO = new ItemOrderPO(cart.getSc_id(), cart.getS_num(), priceXs_num, order.getO_id());
						//保存到数据库
						boolean saveOrderItemFlag = itemOrderDAO.saveOrderItem(con,itemOrderPO);
						System.out.println("saveOrderItemFlag:"+saveOrderItemFlag);
						if(!saveOrderItemFlag) {
							return false;
						}
					}			
				}
				//得到总金额
				totolprice = new BigDecimal(0+"");
				totolprice=totolprice.add(priceXs_num);
				
			}
			//删除购物车
			//new CartServiceImp().getClearCart(su_id);
			con.commit();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//回滚并打开自动提交
			rollback(con);
		}

		/*
		 * 清空购物车 controller层执行
		 */

		/*
		 * 将订单编号与总金额存入session
		 */
		
		
		//关闭连接
		C3P0Util.close(con);
		return true;
	}
	
	//展示我的订单
	public List<OrderPO> showMyOrders(int su_id) {
		//
		List<OrderPO> listItemCommoPO = null;
		//数据库连接
		Connection con = C3P0Util.getConnection();
		
		listItemCommoPO = new OrderDAOImp().searchOrdersByUserId(con,su_id);
		
		//关闭连接
		C3P0Util.close(con);
		return listItemCommoPO;	
	}
	
	//产看详情
	public List<ItemCommoPO> showMyItemOrders(int ou_id,int o_id){
		List<ItemCommoPO> listItemCommoPO = null;
		//数据库连接
		Connection con = C3P0Util.getConnection();
		listItemCommoPO = new OrderDAOImp().queryItemOrdersByuid(con,ou_id,o_id);
		//关闭连接
		C3P0Util.close(con);
		return listItemCommoPO;	
	}

//	public void creatOrder(HttpServletRequest req, List<CartCommoPO> listShoppingCart, int su_id) {
//		// TODO Auto-generated method stub
//		
//	}   

}
