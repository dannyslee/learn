package com.springmvc.frame.dao.imp;

import java.sql.Connection;
import java.sql.Timestamp;
import java.util.List;

import com.springmvc.frame.dao.OrderDAO;
import com.springmvc.frame.po.ItemCommoPO;
import com.springmvc.frame.po.OrderPO;
import com.springmvc.frame.util.ExecJDBC;
import com.springmvc.frame.util.TimeUtil;

public class OrderDAOImp implements OrderDAO {

	@Override
	public boolean saveOrder(Connection con, OrderPO orderPO) {
		String sql = "insert into `order`(o_no,o_creattime,o_status,ou_id) values(?,?,?,?)";
		//时间转化
		Timestamp strToSqlDate = TimeUtil.strToSqlDate(orderPO.getO_creattime(), "yyyy-MM-dd HH:mm:ss");
		return ExecJDBC.sql(con, sql, orderPO.getO_no(),strToSqlDate,0,orderPO.getOu_id());
	}

	@Override
	public List<OrderPO> searchAllOrder(Connection con) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean changeOrderStatus(Connection con, int o_id, int o_status) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<OrderPO> searchOrdersByUserId(Connection con, int ou_id) {
		String sql="select o_id,o_no,o_payid,o_creattime,o_updatetime,o_status,ou_id,o_soft from `order` where ou_id=? and o_soft=0; ";
		return ExecJDBC.sqlByObj(sql, con, OrderPO.class, ou_id);
	}

	public List<ItemCommoPO> queryItemOrdersByuid(Connection con,int su_id,int io_id) {
		String sql="select i_id,ic_id,io_id,ct_id,c_name,c_price,i_num,i_price,c_img,c_show,c_stock,i_soft,c_soft,ou_id from itemcommo where ou_id=? and io_id=? and i_soft=0 and c_soft=0";		
		return ExecJDBC.sqlByObj(sql, con, ItemCommoPO.class, su_id,io_id);
	}
	
//	public List<ItemCommoPO> queryOrdersByuid(Connection con,int su_id) {
//		String sql="SELECT o_id,o_no,o_payid,o_creattime,o_updatetime,o_status,ou_id,o_soft FROM `order` where ou_id=? and o_soft=0";		
//		return ExecJDBC.sqlByObj(sql, con, ItemCommoPO.class, su_id);
//	}

}
