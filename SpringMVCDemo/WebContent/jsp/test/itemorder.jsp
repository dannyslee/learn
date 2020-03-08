<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script src="../../js/jquery.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript">
			//以id获取页面
			function showItemOrders(){
				
				$.ajax({
					url:"../../controller/order/showAll",
					type:"POST",
					data:{
						o_id:$("#o_id").val(),
					},
					dataType:"json",
					success:function(data){
						//"c_name":"历史的力量2","c_price":20.50,"i_num":1,"i_price":20.50,
						var context="";
						for (let i = 0; i < data.length; i++) {
							context += '<li>' +
								'<div>' +
							//	'<img src="' + simpleData.listCommoditityPO[i].c_img + '">' +
								'</div>' +
								'<div>' +
								'编号：<p>' +i + '</p>' +
								'商品名称：<p>' + data[i].c_name + '</p>' +
								//该位置计算金额，建议使用中间表的方式，获取金额，以免不安全（创建一个联表视图，让：数量*金额）
								'单价：<p>' + data[i].c_price + '</p>'+
								'数量：<p>' + data[i].i_num + '</p>'+
								'金额：<p>' + data[i].i_price + '</p>'+
								//这里可以放置一个 隐藏的button 一旦点击，就执行添加购物车的方法
								
								//'<a href="itemorder.jsp?o_id='+data[i].i_num+'">' +
								// '<button type="button" id="showItemOrder" value="' + data[i].i_id +
								// '" onclick="showItemOrder('+data[i].i_id+')">查看详情</input>' +							     
								//'</a>'+
								
								'</div>' +
								'</li>';
						}
						$("#showItemOrders").html(context);
					}
				})
				
				
			}
			//加载
			$(function(){
				showItemOrders();
			})
		</script>
	</head>
	<body>
		<input type="hidden" name="" id="o_id" value="${param.o_id}" />
		<div id="showItemOrders">
			
		</div>
	</body>
</html>
