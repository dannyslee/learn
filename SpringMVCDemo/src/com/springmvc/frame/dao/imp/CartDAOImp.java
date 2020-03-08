package com.springmvc.frame.dao.imp;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.List;

import com.springmvc.frame.dao.CartDAO;
import com.springmvc.frame.po.CartCommoPO;
import com.springmvc.frame.po.ShoppingCartPO;
import com.springmvc.frame.util.ExecJDBC;

public class CartDAOImp implements CartDAO{

	@Override
	public boolean insertCart(Connection con, int sc_id, int su_id, int s_num) {
		String sql ="insert into shoppingcart(sc_id,su_id,s_num) values(?,?,?)";
		return ExecJDBC.sql(con, sql, sc_id,su_id,s_num);
	}

	@Override
	public boolean deleteCart(Connection con, int s_id) {
		String sql = "update shoppingcart set s_soft=1 where s_id=?";
		return ExecJDBC.sql(con, sql, s_id);
	}

	@Override
	public boolean clearCart(Connection con,int su_id) {
		String sql = "update shoppingcart set s_soft=1 where su_id=?";
		return ExecJDBC.sql(con, sql, su_id);
	}

	@Override
	public boolean updateCart(Connection con, int s_id, int su_id, int s_num) {
		String sql = "update shoppingcart set s_num=? where su_id=? and s_id=? and s_soft=0";
		return ExecJDBC.sql(sql, con, s_num,su_id,s_id);
	}

	@Override
	public ShoppingCartPO searchCartByid(Connection con, int sc_id, int su_id) {
		String sql = "select s_id,su_id,sc_id,s_num,s_soft from shoppingcart where su_id=? and sc_id=? and s_soft=0";
		return ExecJDBC.sql(sql, con, ShoppingCartPO.class, su_id,sc_id);
	}

	@Override
	public List<ShoppingCartPO> searchCartAllbyuid(Connection con, int su_id) {
		String sql = "select s_id,su_id,sc_id,s_num,s_soft from shoppingcart where su_id=? and s_soft=0";
		return ExecJDBC.sqlByObj(sql, con, ShoppingCartPO.class, su_id);
	}

	@Override
	public ShoppingCartPO searchCartAllbysid(Connection con, int s_id) {
		String sql = "select s_id,su_id,sc_id,s_num,s_soft from shoppingcart where s_id=? and s_soft=0";
		return ExecJDBC.sql(sql, con, ShoppingCartPO.class, s_id);
	}
	
	//通过用户，获取购物车视图信息
	public List<CartCommoPO> searchCartCommoAllbyuid(Connection con,int su_id){
		String sql = "select s_id,sc_id,su_id,s_num,ct_id,c_name,c_show,c_img,c_price,c_stock,s_soft,c_soft from cartcommo where su_id=? and s_soft=0 and c_soft=0";
		return ExecJDBC.sqlByObj(sql, con, CartCommoPO.class, su_id);
	}
}
