<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="../../js/jquery.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">
	//通过ajax获取到相关信息
	function showCart(){
		$.ajax({
			url:"../../controller/cart/showcart",
			dataType:"json",
			success:function(data){
				
				var cartInfo = data.cartService.listShoppingCart;
				var commoInfo = data.cartService.listCommoditityPO;
				var context="";
				for (let i = 0; i < cartInfo.length; i++) {
					context += '<li>' +
						'<div>' +
					//	'<img src="' + simpleData.listCommoditityPO[i].c_img + '">' +
						'</div>' +
						'<div>' +
						'商品名称：<h3>' + commoInfo[i].c_name + '</h3>' +
						'商品数量：<input type="text"  id="ccount'+cartInfo[i].s_id+'" onblur="updateCart('+cartInfo[i].s_id+')" value="' + cartInfo[i].s_num + '" />'+
						//'商品数量：<p>' + cartInfo[i].s_num + '</p>' +
						'单价：<p>' + commoInfo[i].c_price + '</p>' +
						//该位置计算金额，建议使用中间表的方式，获取金额，以免不安全（创建一个联表视图，让：数量*金额）
						'金额：<p>' + cartInfo[i].s_num*commoInfo[i].c_price + '</p>'
						//这里可以放置一个 隐藏的button 一旦点击，就执行添加购物车的方法
						+
						'<button type="button" id="sc_id" value="' + cartInfo[i].s_id +
						'" onclick="removeCart('+cartInfo[i].s_id+')">删除</input>' +
						'</div>' +
						'</li>';
				}
				
				$("#cart").html(context)
			}
		})
	}
	
	//数量更改
	function updateCart(num){
		var count = '#ccount'+num+'';
		$.ajax({
			url:"../../controller/cart/updatecart",
			type:"POST",
			data:{
				req:"req",
				s_id:num,
				s_num:$(count).val(),
			},
			dataType:"json",
			success:function(data){
				if(data){
					showCart(); 
				}
			}
		})
	}
	
	
	
	//加载时启动
	$(function(){
		showCart();
	})
	//删除功能
	function removeCart(num){
		$.ajax({
			url:"../../controller/cart/removecart",
			type:"POST",
			data:{
				s_id:num,
			},
			dataType:"json",
			success:function(data){
				if(data){
					showCart(); 
				}
			}
		})
	}

	//清空功能
	function clearCart(){
		$.ajax({
			url:"../../controller/cart/clearcart",
			type:"POST",
			data:{
				req:"req",
			},
			dataType:"json",
			success:function(data){
				if(data){
					showCart(); 
				}
			}
		})
	}
	
	

	//创建订单（属于订单模块）
 	function createOrder() {
		$.ajax({
			url:"../../controller/order/creorder",
			type:"POST",
			data:{
				m_name:$("#name").val(),
				m_tel:$("#tel").val(),
				m_address:$("#address").val()
			}
		})
	} 

	
</script>
</head>
<body>
   <%@ include file="mail.jsp" %>
	<button type="button" id="clear" onclick="clearCart()">清空购物车</button>
	<a href="order.jsp">
		<button type="button" id="create" onclick="createOrder()">提交订单</button>
	</a>

	
	<!-- 数量：<span id="pageNow"></span> -->
<!-- 展示页中：
 商品名称 商品数量 单价 金额 删除按钮（id）
 -->
 
   <div id="cart"></div>
   
</body>
</html>