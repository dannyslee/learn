package com.springmvc.frame.controller;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.springmvc.frame.dto.CartDTO;
import com.springmvc.frame.po.ShoppingCartPO;
import com.springmvc.frame.po.UserPO;
import com.springmvc.frame.service.CartService;
import com.springmvc.frame.service.imp.CartServiceImp;
import com.woniuxy.springmvc.annotation.framework.Controller;
import com.woniuxy.springmvc.annotation.handlermapping.RequestMapping;
import com.woniuxy.springmvc.annotation.handlermapping.ResponseBody;
/*
 * 购物车
 */
@Controller
@RequestMapping("/cart")
public class CartController {
	
	private Map<Integer,ShoppingCartPO> carts;
	
	
	//添加到购物车。
	@ResponseBody
	@RequestMapping("/addcart")
	public CartDTO addCart(HttpServletRequest req,int c_id,ShoppingCartPO cart) {
		System.out.println("获取到的c_id:"+c_id);
		CartDTO cartDTO = null;
		//获取session里su_id
		//获取session
		HttpSession session = req.getSession(false);
		//获取session存入的属性值(登录时，存入了该属性)
		Object sessionAttribute = session.getAttribute("user");
		//判断获取到的内容是否为空，如过为空，就能不能执行后面的操作
		if(sessionAttribute==null) {
			return null;
		}
		//该属性为登录用户的UserPO的对象
		UserPO userSessionAttr = (UserPO)sessionAttribute;
		//得到该用户 的u_id
		int su_id = userSessionAttr.getU_id();
		System.out.println("用户id："+su_id);
		//System.out.println(su_id);
		//service
		CartService cartService = new CartServiceImp();
		/*
		 * 下面代码与添加数量有耦合，暂时不实现，首次添加，商品数量设为固定值1
		 */
		//获取数据库该su_id,c_id下的s_num,执行+1操作（支付后，删除该用户购物车里的东西，s_num则需要恢复默认值0）
		//删除之前的该行数据
		
		
		//通过session,建立一个map，将用户信息存入session中
		//获取session中的信息购物车信息
		Object sessionCart = session.getAttribute("cart");
		//如果没有cart,新创建一个
		if(sessionCart==null) {
			carts= new HashMap<>();
		}else {
			carts = (Map<Integer,ShoppingCartPO>)sessionCart;
		}
		
		//根据购物车id，获取cart对象
		ShoppingCartPO oldMapCartPO = carts.get(cart.getSc_id());
		//如果没有,就执行新增
		if(oldMapCartPO==null) {
			carts.put(cart.getSc_id(), cart);
			session.setAttribute("cart", carts);
		}
		
		System.out.println(carts);
		
		//仍然存进数据库，但是不直接对其操作
		
		//判断是否有该商品的购物车信息，如果有，不执行添加,就展示现有的数据
		ShoppingCartPO searchCartByid = cartService.getSearchCartByid(c_id,su_id);
		//System.out.println("searchCartByid.getS_id():"+searchCartByid.getS_id());
		if(searchCartByid.getS_num()!=0) {
			return new CartDTO(cartService);
		}
		//如果没，执行插入
		ShoppingCartPO insertCart = cartService.getInsertCart(c_id, su_id, 1);//新增，对购物车的数量+1
		if(insertCart!=null) {
			return new CartDTO(cartService);
		}
		return cartDTO;	
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
	public boolean removeCart(HttpServletRequest req,int s_id){
		boolean deleteCart = false;
		
		// 获取session
		HttpSession session = req.getSession();
		// 获取session存入的属性值(登录时，存入了该属性)
		Object sessionAttribute = session.getAttribute("user");
		// 判断获取到的内容是否为空，如过为空，就能不能执行后面的操作
		if (sessionAttribute == null) {
			return false;
		}
		//删除按钮，实在购物车页面
		//先查询，如果存在
		//判断s_soft是否=0
		CartService cartService = new CartServiceImp();
		ShoppingCartPO searchCartBysid = cartService.getSearchCartBysid(s_id);
		//System.out.println("searchCartBysid:"+searchCartBysid.getS_id());
		if(!(searchCartBysid.getS_num()>0)) {
			return false;
		}
		//如果s_soft=0,执行update，让s_soft为1，并得到返回结果
		deleteCart = cartService.getDeleteCart(s_id);
		System.out.println(deleteCart);
		if(deleteCart) {
			deleteCart = true;
		}
		
		return deleteCart;
	}
	
	//清空购物车（删除所有）
	@ResponseBody
	@RequestMapping("/clearcart")
	public boolean clearCart(HttpServletRequest req) {
		boolean clearCart = false;
		// 通过session获取该用户的u_id
		// clear就对整个表内容全部删除
		// 获取session
		HttpSession session = req.getSession();
		// 获取session存入的属性值(登录时，存入了该属性)
		Object sessionAttribute = session.getAttribute("user");
		// 判断获取到的内容是否为空，如过为空，就能不能执行后面的操作
		if (sessionAttribute == null) {
			return false;
		}
		// 该属性为登录用户的UserPO的对象
		UserPO userSessionAttr = (UserPO) sessionAttribute;
		// 得到该用户 的u_id
		int su_id = userSessionAttr.getU_id();
		
		//执行清空
		CartService cartService = new CartServiceImp();
		clearCart = cartService.getClearCart(su_id);
		
		if(clearCart) {
			clearCart=true;
		}
		return clearCart;
		
	}
	//修改商品数量
	@ResponseBody
	@RequestMapping("/updatecart")
	public boolean updateCountCart(HttpServletRequest req, int s_id, int s_num) {
		boolean updateCart = false;
		// update数量即可
		// 获取session
		HttpSession session = req.getSession();
		// 获取session存入的属性值(登录时，存入了该属性)
		Object sessionAttribute = session.getAttribute("user");
		// 判断获取到的内容是否为空，如过为空，就能不能执行后面的操作
		if (sessionAttribute == null) {
			return false;
		}
		// 该属性为登录用户的UserPO的对象
		UserPO userSessionAttr = (UserPO) sessionAttribute;
		// 得到该用户 的u_id
		int su_id = userSessionAttr.getU_id();
		// 执行更改
		CartService cartService = new CartServiceImp();
		updateCart = cartService.getUpdateCart(s_id, su_id, s_num);
		if(updateCart) {
			updateCart=true;
		}
		return updateCart;

	}
	
	@ResponseBody
	@RequestMapping("/showcart")
	public CartDTO showAllCartByuid(HttpServletRequest req) {
		CartDTO cartDTO = null;
		CartService cartService = new CartServiceImp();
		// 获取session
		HttpSession session = req.getSession();
		// 获取session存入的属性值(登录时，存入了该属性)
		Object sessionAttribute = session.getAttribute("user");
		// 判断获取到的内容是否为空，如过为空，就能不能执行后面的操作
		if (sessionAttribute == null) {
			return null;
		}
		// 该属性为登录用户的UserPO的对象
		UserPO userSessionAttr = (UserPO) sessionAttribute;
		// 得到该用户 的u_id
		int su_id = userSessionAttr.getU_id();
		System.out.println("用户id：" + su_id);
		//获取到集合
		List<ShoppingCartPO> searchCartAllbyuid = cartService.searchCartAllbyuid(su_id);
		//如果集合不为空
		if(searchCartAllbyuid!=null) {
			//就实例化一个CartDTO对象返回
			return new CartDTO(cartService);
		}
		
		return cartDTO;
	}
	
}
