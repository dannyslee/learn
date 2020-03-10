package com.springmvc.newpackage.service;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.springmvc.frame.po.CartCommoPO;
import com.springmvc.frame.util.C3P0Util;
import com.springmvc.frame.util.MathUtil;
import com.springmvc.frame.util.TimeUtil;
import com.springmvc.newpackage.dao.ItemOrderDAOImp;
import com.springmvc.newpackage.dao.OrderDAOImp;
import com.springmvc.newpackage.dao.factory.DAOFactory;
import com.springmvc.newpackage.po.ItemOrderPO;
import com.springmvc.newpackage.po.OrderPO;
import com.springmvc.newpackage.result.Result;
import com.springmvc.newpackage.service.abs.OrderServiceAbs;
import com.springmvc.newpackage.service.intface.Service;

public class OrderServiceImp extends OrderServiceAbs implements Service {

	private OrderDAOImp orderDAO = (OrderDAOImp) DAOFactory.getInstance("order").getOrder();
	private ItemOrderDAOImp itemOrderDAO = (ItemOrderDAOImp) DAOFactory.getInstance("item").getItemOrder();

	/**
	 * 创建订单
	 * 
	 * @return
	 */
	public Result createOrder(HttpServletRequest req, List<CartCommoPO> listCartCommoPO, int su_id) {
		// 数据判断
		if (listCartCommoPO.isEmpty()) {
			return new Result("无购物车数据，订单无法生成");
		}
		//总金额预设
		BigDecimal totolprice = new BigDecimal(0 + "");
		// 数据事务
		Connection con = C3P0Util.getConnection();
		try {
			// 关闭自动提交
			con.setAutoCommit(false);
			// 创建订单
			// 生成自定义订单号
			String o_no = System.currentTimeMillis() + "" + su_id;
			// 时间转化
			Timestamp dateToSqlDate = TimeUtil.dateToSqlDate(new Date());
			OrderPO orderPO = new OrderPO(o_no, null, dateToSqlDate, null, 0, su_id);
			// 数据库插入订单
			Result saveOrder = orderDAO.saveOrder(con, orderPO);

			// 判断插入结果
			if (!saveOrder.isFlag()) {
				return new Result("订单生成时失败！");
			}

			for (CartCommoPO cart : listCartCommoPO) {

				// 库存检查
				int number = cart.getC_stock() - cart.getS_num();
				System.out.println("number:" + number);
				if (number < 0) {
					return new Result("库存不足,该订单无法生成!");
				}

				// 库存更新
				Result updateStockByid = DAOFactory.getInstance("commo").getCommo().updateStockByid(con, number,
						cart.getSc_id());
				// 判断更新结果
				if (!updateStockByid.isFlag()) {
					return new Result("更新库存时失败！");
				}

				// 计算实际价格

				// 从视图获取商品表价格
				BigDecimal priceXs_num = MathUtil.mul(cart.getS_num(), cart.getC_price());
				// 要从数据库里获取orderid

				List<OrderPO> searchOrdersByUserId = (List<OrderPO>) orderDAO.searchOrdersByUserId(con, su_id).getObj1();
				for (OrderPO order : searchOrdersByUserId) {
					// 查询订单号
					if (order.getO_id() < 1) {
						return new Result("订单不存在！");
					}

					// 找到对应订单
					if (order.getO_no().equals(o_no)) {
						// 生成订单项
						ItemOrderPO itemOrderPO = new ItemOrderPO(cart.getSc_id(), cart.getS_num(), priceXs_num,
								order.getO_id());
						// 订单项添加
						Result saveOrderItem = itemOrderDAO.saveOrderItem(con, itemOrderPO);
						// 添加结果判断
						if (!saveOrderItem.isFlag()) {
							return new Result("订单项添加时失败！");
						}
					}

				}

				// 获取总金额
				totolprice = totolprice.add(priceXs_num);
				
				
			}
			
			//给order存入总金额
			orderPO.setSession_subtotal(totolprice);
			
			//将订单存入session
			req.getSession(false).setAttribute("order", orderPO);
			
			// 事务提交
			con.commit();
	

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//失败回滚事务
			rollback(con);
		}

		C3P0Util.close(con);
		return new Result("订单创建成功！");
	}
	
	/**
	 * 回滚方法
	 * @param con
	 */
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
	
	


	
	@Override
	public Result getSaveOrder(OrderPO orderPO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result getSearchAllOrder() {
		// TODO Auto-generated method stub
		return null;
	}


	/**
	 * 展示订单页
	 */
	@Override
	public Result getSearchOrdersByUserId(int ou_id) {
		Connection con = C3P0Util.getConnection();
		Result select = (Result)getSelect("ORDERDAO_SELECT_UID",con,ou_id);
		C3P0Util.close(con);
		return select;
	}

	@Override
	public Result getChangeOrderStatusAndPayId(int o_status, String o_payid, String o_no) {
		Connection con = C3P0Util.getConnection();
		Result select = (Result)getUpdate("ORDERDAO_UPDATE_OSTATUS_AND_OPAYID_BY_OID",con,o_status,o_payid,o_no);
		C3P0Util.close(con);
		return select;
	}

	// 展示我的订单
//	public Result showMyOrders(int su_id) {
//		Connection con = C3P0Util.getConnection();
//		Result listItemCommoPO = new OrderDAOImp().searchOrdersByUserId(con, su_id);
//		C3P0Util.close(con);
//		return listItemCommoPO;
//	}
	
	
}
