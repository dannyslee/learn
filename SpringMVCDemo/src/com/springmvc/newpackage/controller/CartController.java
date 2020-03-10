package com.springmvc.newpackage.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.springmvc.frame.po.CartCommoPO;
import com.springmvc.newpackage.po.ShoppingCartPO;
import com.springmvc.newpackage.po.UserPO;
import com.springmvc.newpackage.result.Result;
import com.springmvc.newpackage.service.CartServiceImp;
import com.springmvc.newpackage.service.factory.ServiceFactory;
import com.springmvc.newpackage.service.intface.ServiceDeleteInterface;
import com.woniuxy.springmvc.annotation.framework.Controller;
import com.woniuxy.springmvc.annotation.handlermapping.RequestMapping;
import com.woniuxy.springmvc.annotation.handlermapping.ResponseBody;

@Controller
@RequestMapping("/cart")
public class CartController {
	//添加到购物车。
		@ResponseBody
		@RequestMapping("/addcart")
		public Result addCart(HttpServletRequest req,int c_id,ShoppingCartPO cart) {
			
			//存入session		
			HttpSession session = req.getSession(false);
			
			//获取session中的uid
			int u_id = ((UserPO)(((Result)session.getAttribute("user")).getObj1())).getU_id();
			
			if(u_id==0) {
				session.removeAttribute("user");
				return new Result("抱歉！由于服务器原因，您需要重新登录！");
			}
			
			System.out.println("---------------------------------------通过session获取的uid:"+u_id+"----------------------------------------------------------");
			
			//如果session用户信息不存在
			if(session.getAttribute("user")==null) { return new Result("请重新登录！"); }
			
			//设置map
			Map<Integer, ShoppingCartPO> cartsHashMap = null;
			
			//如果购物车信息不存在，设定一个购物车集合
			if(session.getAttribute("carts")==null) {
				cartsHashMap = new HashMap<>();		
			}else {
				//如果存在
				cartsHashMap = (Map<Integer, ShoppingCartPO>)session.getAttribute("carts");

			}
			
			//从map中获取购物车对象
			System.out.println("cart获取的参数 | key："+cart.getSc_id()+", value: "+cart);
			
			if(cartsHashMap.get(cart.getSc_id())==null) {
				cart.setSu_id(u_id);
				cartsHashMap.put(cart.getSc_id(), cart);
			}
			
			session.setAttribute("carts", cartsHashMap);


			System.out.println("session.getAttribute(\"carts\"):"+session.getAttribute("carts"));
					
			
			//存入数据库
			
			
			//如果购物中有该商品，数额+1
			if(((CartCommoPO)(((Result)ServiceFactory.getInstance("cart").getCart().getSearchCartByid(c_id, u_id)).getObj1())).getC_img()!=null) {
				//返回查询结果对象cartCommoPO
				CartCommoPO cartCommoPO = (CartCommoPO)(((Result)ServiceFactory.getInstance("cart").getCart().getSearchCartByid(c_id, u_id)).getObj1());		
				//获得旧的订单数
				int mysqlOldnumber = cartCommoPO.getS_num();
				//获取s_id
				int s_id = cartCommoPO.getS_id();
				//更新购物车
				ServiceFactory.getInstance("cart").getCart().getUpdateCart(s_id, u_id,mysqlOldnumber+1);	
				//重新获取更新数据
				int mysqlNewnumber = ((CartCommoPO)(((Result)ServiceFactory.getInstance("cart").getCart().getSearchCartByid(c_id, u_id)).getObj1())).getS_num();
				
				return new Result("你已成功添加  "+mysqlNewnumber+" 件该商品！") ;
						
			}else{
				
				//否则,执行插入
				ServiceFactory.getInstance("cart").getCart().getInsertCart(c_id, u_id, 1);	
				
				//插入后查询判断,防止插入失败
				if(((CartCommoPO)(((Result)ServiceFactory.getInstance("cart").getCart().getSearchCartByid(c_id, u_id)).getObj1())).getC_img()!=null) {
					return new Result("添加购物车成功！");
				}						
			}
			
			return new Result("添加购物车失败！");
		}
		

		public void remove(HttpServletRequest req) {
			req.getSession().removeAttribute("carts");
			
		}
		

		/*
		 * 以下方法都存在于购物车展示页
		 * 该页面在执行所有操作的时候，有必要对页面进行一次刷新（该刷新，是前端实现）
		 * 注意：不点击button按钮，就不能执行内容操作，以免刷新时，执行程序
		 */
		//单项商品移除购物车
		//移除本质是软删除
		@ResponseBody
		@RequestMapping("/removecart")
		public Result removeCart(HttpServletRequest req,int s_id,int sc_id){			

			//获取session
			HttpSession session = req.getSession(false);		
			//判断session是否存在
			if(session==null) {
				return new Result("请重新登录！");
			}		
			//以商品id,清除该商品session数据
			if(session.getAttribute("carts")==null) {
				return new Result("请重新登录！");
			}
			((Map<Integer, ShoppingCartPO>)session.getAttribute("carts")).remove(sc_id);
			
			//清除该商品数据库数据,并返回结果	
			return 	ServiceFactory.getInstance("cart").getCart().getDeleteCart(s_id);
			
		}
//		
		//清空购物车（删除所有）
		@ResponseBody
		@RequestMapping("/clearcart")
		public Result clearCart(HttpServletRequest req) {
			//获取session
			HttpSession session = req.getSession(false);
			
			//判断session是否存在
			if(session==null) {
				return new Result("请重新登录！");
			}
			//获取session存入的用户信息
			int u_id = ((UserPO)((Result)session.getAttribute("user")).getObj1()).getU_id();
			
			System.out.println(session.getAttribute("carts"));
			//先清空session中的购物车内容
			((Map<Integer, ShoppingCartPO>)session.getAttribute("carts")).entrySet().removeIf(entry -> entry.getValue()!=null);
			System.out.println(session.getAttribute("carts"));

			//再清空购物车中的数据
			return ServiceFactory.getInstance("cart").getCart().getClearCart(u_id);
			
		}
		//修改商品数量
		@ResponseBody
		@RequestMapping("/updatecart")
		public Result updateCountCart(HttpServletRequest req, int s_id,int sc_id,int s_num) {
			//获取session
			HttpSession session = req.getSession(false);		
			//判断session是否存在
			if(session==null) {
				return new Result("请重新登录！");
			}
			//获取session存入的用户信息
			int u_id = ((UserPO)((Result)session.getAttribute("user")).getObj1()).getU_id();
			//更改session中的数据
			Map<Integer, ShoppingCartPO> carts = (Map<Integer, ShoppingCartPO>)session.getAttribute("carts");
			//获取原本session中存在的数据
			if(carts.get(sc_id)!=null) {
				int sessionOldnumber = carts.get(sc_id).getS_num();
				if(sessionOldnumber+s_num<1) {
					return new Result("修改失败，购买数量不可小于1！");
				}
				//更改session数额
				carts.get(sc_id).setS_num(sessionOldnumber+s_num);
				//添加更改内容
				carts.put(sc_id, carts.get(sc_id));
				//重新推入session
				session.setAttribute("cart", carts);

			}
			//获取数据库原本存在的数据
			int mysqlOldnumber = ((CartCommoPO)(((Result)ServiceFactory.getInstance("cart").getCart().getSearchCartByid(sc_id, u_id)).getObj1())).getS_num();
			//判断数量是否越界（session & 数据库）
			if(mysqlOldnumber+s_num<1) {
				return new Result("修改失败，购买数量不可小于1！");
			}
			
			
			
			// 更改数据库中数据，并返回
			return ServiceFactory.getInstance("cart").getCart().getUpdateCart(s_id, u_id,mysqlOldnumber+s_num);

		}
		
		/**
		 * 订单预处理层：一个小版本的失血模型
		 */
		
		//生成一个公共返回值(用订单预创建时，存取共用)
		private Result result;
		
		/**
		 * 订单预创建
		 * @param req
		 * @param s_id
		 * @param sc_id
		 * @return
		 */
		@ResponseBody
		@RequestMapping("/createAdvanceOrder")
		public Result setAdvanceOrder(HttpServletRequest req,int s_id) {
			//获取商品信息
			CartCommoPO checkedCommo = (CartCommoPO)(ServiceFactory.getInstance("cart").getCart().getSearchCartBysid(s_id).getObj1());
			//创建集合
			ArrayList<CartCommoPO> checkedCommoList = new ArrayList<CartCommoPO>();
			//复选的购物车商品添加到集合
			checkedCommoList.add(checkedCommo);
			//存入公共返回值对象中
			result = new Result(checkedCommoList);
			//由于要获取图片等信息，直接从数据库里取
			return result;		
		}
		
		/**
		 * 获取公共返回值的内容
		 * @return
		 */
		@ResponseBody
		@RequestMapping("/getAdvanceOrder")
		public Result getAdvanceOrder() {
			//返回该集合
			return result;		
		}
		
		
		/**
		 * 展示所有内容
		 * @param req
		 * @return
		 */
		@ResponseBody
		@RequestMapping("/showcart")
		public Result showAllCartByuid(HttpServletRequest req) {
			
			//获取session
			HttpSession session = req.getSession(false);
			
			//判断session是否存在
			if(session==null) {
				return new Result("请重新登录！");
			}
			//获取session存入的用户信息
			if(session.getAttribute("user")==null) {
				return new Result("请重新登录！");
			}
			
			int u_id = ((UserPO)((Result)session.getAttribute("user")).getObj1()).getU_id();

			//session数据不为空，从session中取
//			if(session.getAttribute("carts")!=null) {
//				return new Result((Collection<ShoppingCartPO>)((Map)session.getAttribute("carts")).values());
//			}
			//若session中数据为空，从数据库中取
			return ServiceFactory.getInstance("cart").getCart().searchCartAllbyuid(u_id);
						
		}
}
