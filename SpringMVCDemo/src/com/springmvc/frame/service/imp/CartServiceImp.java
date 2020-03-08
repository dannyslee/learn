package com.springmvc.frame.service.imp;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.springmvc.frame.dao.CartDAO;
import com.springmvc.frame.dao.CommoditityDAO;
import com.springmvc.frame.dao.imp.CartDAOImp;
import com.springmvc.frame.dao.imp.CommoditityDAOImp;
import com.springmvc.frame.dao.imp.UserDAOImp;
import com.springmvc.frame.po.CartCommoPO;
import com.springmvc.frame.po.CommoditityPO;
import com.springmvc.frame.po.ShoppingCartPO;
import com.springmvc.frame.po.UserPO;
import com.springmvc.frame.service.CartService;
import com.springmvc.frame.util.C3P0Util;

public class CartServiceImp implements CartService {
	//存在对商品的依赖
	private CommoditityPO commoditityPO;
	
	//存在对用户的依赖
	private UserPO userPO;
	
	//返回的ShoppingCartPO
	private ShoppingCartPO shoppingCart;
	
	//返回 List<ShoppingCartPO>
	private List<ShoppingCartPO> listShoppingCart;
	
	//返回List<CommoditityPO>
	private List<CommoditityPO> listCommoditityPO;
	


	public List<CommoditityPO> getListCommoditityPO() {
		return listCommoditityPO;
	}
	



	@Override
	public List<ShoppingCartPO> searchCartAllbyuid(int su_id) {
		
		listCommoditityPO=null;
		listShoppingCart=null;
		
		listCommoditityPO = new ArrayList<CommoditityPO>();
		
		//建立通道
		Connection con = C3P0Util.getConnection();
		
		//获取该用户的所有购物车信息
		CartDAO cartDAO = new CartDAOImp();
		listShoppingCart = cartDAO.searchCartAllbyuid(con, su_id);
		if(listShoppingCart==null) {
			return null;
		}
		//通过购物车信息的商品id，获取对应的商品信息
		for (ShoppingCartPO commoditity : listShoppingCart) {
			int sc_id = commoditity.getSc_id();
			System.out.println(sc_id);
			CommoditityDAO commoditityDAO = new CommoditityDAOImp();
			CommoditityPO searchCommodititesBycid = commoditityDAO.SearchCommodititesBycid(con, sc_id);
			listCommoditityPO.add(searchCommodititesBycid);
		}
		
		//关流
		C3P0Util.close(con);
		return listShoppingCart;
	}

	
	
	@Override
	public ShoppingCartPO getSearchCartByid(int sc_id, int su_id) {
		//ShoppingCartPO
		//ShoppingCartPO cartPO = null;
		commoditityPO=null;
		userPO=null;
		shoppingCart=null;
		
		//建立通道
		Connection con = C3P0Util.getConnection();
		//DAO
		CartDAO cartDAO = new CartDAOImp();
		//获取内容
		shoppingCart = cartDAO.searchCartByid(con, sc_id, su_id);
		if(shoppingCart!=null) {
			//通过sc_id，得到商品对象
			commoditityPO = new CommoditityDAOImp().SearchCommodititesBycid(con, sc_id);
			// 通过su_id,得到用户对象
			userPO = new UserDAOImp().SearchUserByuid(con, su_id);
		}
		//关连接
		C3P0Util.close(con);
		return shoppingCart;
	}
	

	@Override
	public ShoppingCartPO getInsertCart(int sc_id, int su_id,int s_num) {
		commoditityPO=null;
		userPO=null;
		shoppingCart=null;
		boolean flag = false;
		//建立通道
		Connection con = C3P0Util.getConnection();
		//通过sc_id，得到商品对象
		commoditityPO = new CommoditityDAOImp().SearchCommodititesBycid(con, sc_id);
		//通过su_id,得到用户对象
		userPO = new UserDAOImp().SearchUserByuid(con,su_id);
		//通过形参，插入一条新信息
		flag = new CartDAOImp().insertCart(con,sc_id, su_id, s_num);
		if(flag) {
			shoppingCart = new CartDAOImp().searchCartByid(con, sc_id, su_id);
		}
		//关闭连接
		C3P0Util.close(con);
		return shoppingCart;
	}

	@Override
	public boolean getDeleteCart(int s_id) {
		boolean deleteCart = false;
		//建立通道
		Connection con = C3P0Util.getConnection();
		//
		CartDAO cartDAO = new CartDAOImp();
		deleteCart = cartDAO.deleteCart(con, s_id);
		if(deleteCart) {
			deleteCart=true;
		}
		C3P0Util.close(con);
		return deleteCart;
	}
	

	@Override
	public ShoppingCartPO getSearchCartBysid(int s_id) {
		shoppingCart =null;
		//建立通道
		Connection con = C3P0Util.getConnection();
		//DAO
		CartDAO cartDAO = new CartDAOImp();
		//DAO方法
		shoppingCart = cartDAO.searchCartAllbysid(con, s_id);
		//关闭
		C3P0Util.close(con);
		return shoppingCart;
	}

	
	@Override
	public boolean getClearCart(int su_id) {
		boolean shoppingCart = false;
		// 建立通道
		Connection con = C3P0Util.getConnection();
		// DAO
		CartDAO cartDAO = new CartDAOImp();
		// DAO方法
		shoppingCart = cartDAO.clearCart(con, su_id);
		// 关闭
		C3P0Util.close(con);
		return shoppingCart;
	}

	@Override
	public boolean getUpdateCart(int s_id, int su_id, int s_num) {
		boolean shoppingCart = false;
		// 建立通道
		Connection con = C3P0Util.getConnection();
		// DAO
		CartDAO cartDAO = new CartDAOImp();
		// DAO方法
		shoppingCart = cartDAO.updateCart(con, s_id, su_id, s_num);
		// 关闭
		C3P0Util.close(con);
		return shoppingCart;
	}
	
	//通过su_id，获取视图信息
	public List<CartCommoPO> getSearchCartCommoAllbyuid(int su_id) {
		List<CartCommoPO> cartCommoPO = null;
		// 建立通道
		Connection con = C3P0Util.getConnection();
		// DAO
		CartDAOImp cartDAO = new CartDAOImp();
		// DAO方法
		cartCommoPO = cartDAO.searchCartCommoAllbyuid(con, su_id);
		// 关闭
		C3P0Util.close(con);
		return cartCommoPO;
	}
	
	
	public CommoditityPO getCommoditityPO() {
		return commoditityPO;
	}

	public void setCommoditityPO(CommoditityPO commoditityPO) {
		this.commoditityPO = commoditityPO;
	}

	public UserPO getUserPO() {
		return userPO;
	}

	public void setUserPO(UserPO userPO) {
		this.userPO = userPO;
	}


	public ShoppingCartPO getShoppingCart() {
		return shoppingCart;
	}


	public void setShoppingCart(ShoppingCartPO shoppingCart) {
		this.shoppingCart = shoppingCart;
	}

	
	public List<ShoppingCartPO> getListShoppingCart() {
		return listShoppingCart;
	}



	public void setListShoppingCart(List<ShoppingCartPO> listShoppingCart) {
		this.listShoppingCart = listShoppingCart;
	}







	



	
	
	
}
