<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script src="../../js/jquery.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript">
			//通过商品类型，获取商品信息
			function showCommoBytid(page) {
				$.ajax({
					url: "../../controller/commo/showCommo",
					type: "POST",
					//async:false,
					data: {
						t_id: $("#t_id").val(),
						page: page,
					},
					dataType: "json",
					success: function(data) {
						//alert(data.obj1.obj1[0].c_name);
						var context = "";
						var simpleData = data.obj1.obj1;
						var pageNow = data.pageNow;
						var pageCount = data.pageCount;
						var pageN = data.pageSplit;
						for (let i = 0; i < simpleData.length; i++) {
							context += '<li>' +
								'<div>' +
								'<img src="' + simpleData[i].c_img + '">' +
								'</div>' +
								'<div>' +
								'<h3>' + simpleData[i].c_name + '</h3>' +
								'<p>' + simpleData[i].c_show + '</p>' +
								'<p>' + simpleData[i].c_price + '</p>' +
								'<p>' + simpleData[i].c_stock + '</p>'
								//这里可以放置一个 隐藏的button 一旦点击，就执行添加购物车的方法
								+
								'<button type="button" id="sc_id" value="' + simpleData[i].c_id +
								'" onclick="addCart('+simpleData[i].c_id+','+simpleData[i].c_price+')">加入购物车</input>' +
								'</div>' +
								'</li>';
						}
						$("#commo").html(context);
						//总页数
						$("#pageN").html(pageN);
						//当前页数
						$("#pageNow").html(pageNow);
					}
				});
			}
			//在页面打开时执行获取商品信息的操作
			$(function() {
				showCommoBytid(1);
			})

			//点击添加到购物车，需要一个新的ajax
			function addCart(num,session_price) {
				$.ajax({
					url: "../../controller/cart/addcart",
					type: "POST",
					async:false,
					data: {
						req:"req",
						c_id: num,
						'cart.sc_id':num,
						'cart.s_num':1,
						'cart.sesssin_price':session_price,
					},
					dataType: "json",
					success: function(data) {
						//alert(data[0]);
					}
				})
			}

			//下一页
			function nextPage() {
				var pageNow = parseInt($("#pageNow").html());
				var pageN = parseInt($("#pageN").html());
				if (!(pageNow < 1 || pageNow >= pageN)) {
					showCommoBytid(pageNow + 1);
				}
			}
			//上一页
			function lastPage() {
				var pageNow = parseInt($("#pageNow").html());
				var pageN = parseInt($("#pageN").html());
				if (!(pageNow < 2 || pageNow > pageN)) {
					showCommoBytid(pageNow - 1);
				}
			}
			
			
		</script>
	</head>
	<body>
		<input type="hidden" id="t_id" value="${param.t_id}" />
		<button id="nextPage" onclick="nextPage()">下一页</button>
		<span id="pageNow"></span>/<span id="pageN"></span>
		<button id="lastPage" onclick="lastPage()">上一页</button>
		<div id="commo">
			<!-- 这里展示符合商品类型的商品页 -->
		</div>

	</body>
</html>
