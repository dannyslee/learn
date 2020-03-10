package com.springmvc.newpackage.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.springmvc.frame.po.CartCommoPO;
import com.springmvc.newpackage.po.MailPO;
import com.springmvc.newpackage.po.UserPO;
import com.springmvc.newpackage.result.Result;
import com.springmvc.newpackage.service.factory.ServiceFactory;
import com.woniuxy.springmvc.annotation.framework.Controller;
import com.woniuxy.springmvc.annotation.handlermapping.RequestMapping;
import com.woniuxy.springmvc.annotation.handlermapping.ResponseBody;

@Controller
@RequestMapping("/order")
public class OrderController {
	@ResponseBody
	@RequestMapping("/creatorder")
	public Result createOrder(HttpServletRequest req,String m_name,String m_tel,String m_address) {
		//获取session
		Object sessionAttribute = req.getSession(false).getAttribute("user");
		if(sessionAttribute==null) {
			return new Result("请重新登录！");
		}
		//获取u_id
		int u_id = ((UserPO)(((Result)sessionAttribute).getObj1())).getU_id();
		
		//获取快递信息
		MailPO mailPO = new MailPO(m_name,m_tel,m_address,u_id);
		System.out.println(mailPO);
		if(mailPO.getM_address()==null || mailPO.getM_tel()==null || mailPO.getM_name()==null) {
			return new Result("登录信息不全");
		}
		//插入邮件信息
		ServiceFactory.getInstance("mail").getMail().getInsertMail(mailPO);
		//获取该用户购物类及其商品信息
		Result searchCartAllbyuid = ServiceFactory.getInstance("cart").getCart().searchCartAllbyuid(u_id);
		//如果内容为空，返回错误信息
		List<CartCommoPO> listCartCommoPO = (List<CartCommoPO>)searchCartAllbyuid.getObj1();
		if(listCartCommoPO.isEmpty()) {
			return new Result("商品不能为空");
		}
		//生成订单
		ServiceFactory.getInstance("order").getOrder().createOrder(req, listCartCommoPO, u_id);
		//清空购物车
		ServiceFactory.getInstance("cart").getCart().getClearCart(u_id);
		
		return new Result("订单创建成功");		
	}
	
	
	@RequestMapping("/showorder")
	@ResponseBody
	public Result showOrder(HttpServletRequest req) {
		// 获取session
		Object sessionAttribute = req.getSession(false).getAttribute("user");
		if (sessionAttribute == null) {
			return new Result("请重新登录！");
		}
		// 获取u_id
		int u_id = ((UserPO) (((Result) sessionAttribute).getObj1())).getU_id();
		// 得到返回结果
		return ServiceFactory.getInstance("order").getOrder().getSearchOrdersByUserId(u_id);
	}
	
	@RequestMapping("/showitem")
	@ResponseBody
	public Result showItemOrder(HttpServletRequest req,int o_id) {
		// 获取session
		Object sessionAttribute = req.getSession(false).getAttribute("user");
		if (sessionAttribute == null) {
			return new Result("请重新登录！");
		}
		// 获取u_id
		int u_id = ((UserPO) (((Result) sessionAttribute).getObj1())).getU_id();
		// 得到返回结果
		return ServiceFactory.getInstance("item").getItenOrder().getSearchOrderItemCommo(u_id, o_id);
	
	}
}
