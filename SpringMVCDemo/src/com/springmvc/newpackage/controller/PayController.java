package com.springmvc.newpackage.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.config.AlipayConfig;
import com.springmvc.newpackage.po.OrderPO;
import com.springmvc.newpackage.service.factory.ServiceFactory;
import com.woniuxy.springmvc.annotation.framework.Controller;
import com.woniuxy.springmvc.annotation.handlermapping.RequestMapping;
import com.woniuxy.springmvc.annotation.handlermapping.ResponseRedirect;

@Controller
@RequestMapping("/pay")
public class PayController {
	
	@RequestMapping("/pay")
	public void pay(HttpServletRequest req,HttpServletResponse resp) {
		
		//获得初始化的AlipayClient
		AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);
		
		//设置请求参数
		AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
		alipayRequest.setReturnUrl(AlipayConfig.return_url);
		alipayRequest.setNotifyUrl(AlipayConfig.notify_url);
		
		//获取session中的订单
		OrderPO orderSessionattribute = (OrderPO)req.getSession(false).getAttribute("order");
		if(orderSessionattribute==null) {
			return;
		}
		//商户订单号，商户网站订单系统中唯一订单号，必填
		String out_trade_no = orderSessionattribute.getO_no();
		//付款金额，必填
		String total_amount = orderSessionattribute.getSession_subtotal().toString();
		//订单名称，必填
		String subject = "SHOPDEMO支付订单";
	
		alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\"," 
				+ "\"total_amount\":\""+ total_amount +"\"," 
				+ "\"subject\":\""+ subject +"\"," 
				+ "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");

		try {
			//请求
			String result = alipayClient.pageExecute(alipayRequest).getBody();
			//设置响应数据类型
			resp.setContentType("text/html;charset=utf-8");
			//输出
			resp.getWriter().println(result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@RequestMapping("/payNotify")
	public void payNotify(HttpServletRequest req,HttpServletResponse resp) {
		
		Map<String,String> params = new HashMap<String,String>();
		
		Map<String,String[]> requestParams = req.getParameterMap();
		
		for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
			String name = (String) iter.next();
			String[] values = (String[]) requestParams.get(name);
			String valueStr = "";
			for (int i = 0; i < values.length; i++) {
				valueStr = (i == values.length - 1) ? valueStr + values[i]
						: valueStr + values[i] + ",";
			}
			//乱码解决，这段代码在出现乱码时使用
			//valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
			params.put(name, valueStr);
		}
		
		boolean signVerified;
		
		try {
			
			signVerified = AlipaySignature.rsaCheckV1(params, AlipayConfig.alipay_public_key, AlipayConfig.charset, AlipayConfig.sign_type);
			
			if(signVerified) {//验证成功
				//商户订单号
				String out_trade_no = new String(req.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8");
			
				//支付宝交易号
				String trade_no = new String(req.getParameter("trade_no").getBytes("ISO-8859-1"),"UTF-8");
			
				//交易状态
				String trade_status = new String(req.getParameter("trade_status").getBytes("ISO-8859-1"),"UTF-8");
				
				// 支付完成
				if(trade_status.equals("TRADE_FINISHED")){
					
			    // 支付成功
				}else if (trade_status.equals("TRADE_SUCCESS")){
					
					//更新数据库中 payid 和 订单状态
					ServiceFactory.getInstance("order").getOrder().getChangeOrderStatusAndPayId(1, trade_no, out_trade_no);
		
				}
				
				resp.getWriter().println("success");
				
			}else {//验证失败
				resp.getWriter().println("fail");
			
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	@RequestMapping("/payReturn")
	@ResponseRedirect(true)
	public String payReturn(HttpServletRequest req,HttpServletResponse resp) {
		
		return "http://localhost:8080/SpringMVCDemo/shopweb/myaccounta.jsp";
	}
	
}
