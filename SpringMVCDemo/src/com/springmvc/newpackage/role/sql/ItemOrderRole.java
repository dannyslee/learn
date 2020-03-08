package com.springmvc.newpackage.role.sql;

import java.sql.Connection;

import com.springmvc.frame.util.ExecJDBC;
import com.springmvc.newpackage.po.ItemCommoPO;
import com.springmvc.newpackage.po.ItemOrderPO;
import com.springmvc.newpackage.result.Result;
import com.springmvc.newpackage.sql.SQLtodo;

public enum ItemOrderRole implements SQLtodo {
	//视图订单项与商品表连接查询
		ORDERITEM_AND_COMMO_SELECT_UID_OID{

			@Override
			public Object sql(Object... args) {
				String sql="select i_id,ic_id,io_id,ct_id,c_name,c_price,i_num,i_price,c_img,c_show,c_stock,i_soft,c_soft,ou_id from itemcommo where ou_id=? and io_id=? and i_soft=0 and c_soft=0";	
				return new Result(ExecJDBC.sqlByObj(sql, (Connection)args[0], ItemCommoPO.class, (int)args[1],(int)args[2]));
			}
			
		},
		
		//插入订单项
		ORDERITEM_INSERT_ITEMORDERPO{

			@Override
			public Object sql(Object... args) {
				String sql = "insert into itemorder(ic_id,i_num,i_price,io_id) values(?,?,?,?)";	
				return new Result(ExecJDBC.sql(sql, (Connection)args[0], ((ItemOrderPO)args[1]).getIc_id(),((ItemOrderPO)args[1]).getI_num(),((ItemOrderPO)args[1]).getI_price(),((ItemOrderPO)args[1]).getIo_id()));
			}
			
		}
}
