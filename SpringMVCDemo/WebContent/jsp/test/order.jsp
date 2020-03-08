<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script src="../../js/jquery.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript">
			//实现展示我的订单
			function showOrders(){
				$.ajax({
					url:"../../controller/order/show",
					type:"POST",
					dataType:"json",
					success:function(data){
						var context="";
						for (let i = 0; i < data.length; i++) {
							context += '<li>' +
								'<div>' +
							//	'<img src="' + simpleData.listCommoditityPO[i].c_img + '">' +
								'</div>' +
								'<div>' +
								'编号：<p>' +i + '</p>' +
								'订单号：<p>' + data[i].o_no + '</p>' +
								//该位置计算金额，建议使用中间表的方式，获取金额，以免不安全（创建一个联表视图，让：数量*金额）
								'订单生成时间：<p>' + data[i].o_creattime + '</p>'+
								//这里可以放置一个 隐藏的button 一旦点击，就执行添加购物车的方法
								
								'<a href="itemorder.jsp?o_id='+data[i].o_id+'">' +
								'<button type="button" id="showItemOrder" value="' + data[i].o_id +
								'" onclick="showItemOrder('+data[i].o_id+')">查看详情</input>' +							     
								'</a>'+
								
								'</div>' +
								'</li>';
						}
						$("#showOrders").html(context);
					}
				})
			}
			//加载执行
			$(function(){
				showOrders()
			})
			//查看详情
			function showItemOrder(num){
				$.ajax({
					url:"itemorder.jsp",
					type:"POST",
					data:{
						o_id:num,
					},
				})
			}
		</script>
	</head>
	<body>
		<div id="showOrders">
			
		</div>
	</body>
</html>
