<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html class="no-js" lang="zxx">

	<head>
		<meta charset="utf-8">
		<meta http-equiv="x-ua-compatible" content="ie=edge">
		<title>Home</title>
		<meta name="description" content="">
		<meta name="viewport" content="width=device-width, initial-scale=1">

		<!-- Favicon -->
		<link rel="shortcut icon" type="image/x-icon" href="images/favicon.png">

		<!-- All css files are included here -->
		<!-- Bootstrap fremwork main css -->
		<link rel="stylesheet" type="text/css" href="http://www.jq22.com/jquery/bootstrap-3.3.4.css">
		<!-- This core.css file contents all plugings css file. -->
		<link rel="stylesheet" href="css/core.css">
		<!-- Theme shortcodes/elements style -->
		<link rel="stylesheet" href="css/shortcode/shortcodes.css">
		<!-- Theme main style -->
		<link rel="stylesheet" href="style.css">
		<!-- Responsive css -->
		<link rel="stylesheet" href="css/responsive.css">
		<!-- User style -->
		<link rel="stylesheet" href="css/custom.css">



		<!-- Modernizr JS -->
		<script src="js/vendor/modernizr-2.8.3.min.js"></script>
		
		
		<!-- 购物车回显 -->
		<script type="text/javascript">
			function showCart(){
					$.ajax({
						url:"http://localhost:8080/SpringMVCDemo/controller/cart/showcart",
						dataType:"json",
						success:function(data){
							
							var cartInfo = data.cartService.listShoppingCart;
							var commoInfo = data.cartService.listCommoditityPO;
							var context="";
							for (let i = 0; i < cartInfo.length; i++) {
								
								
								context += '<li class="media">'+
			                                 '<a href="#"><img alt="" src="images/cart/1.jpg"></a>'+
			                                 '<div class="cart-item-wrapper">'+
				                                '<a href="#">' + commoInfo[i].c_name + '</a>'+
				                                   '<span class="quantity'+
					                                     '<span class="amount">' + cartInfo[i].s_num*commoInfo[i].c_price + '</span>'+
					                                     'x'+
										                 '<span class="amount" id="ccount'+cartInfo[i].s_id+'">' + cartInfo[i].s_num + '</span>'+
				                                   '</span>'+
				                                   '<a title="Remove this item" class="remove" onclick="removeCart('+cartInfo[i].s_id+')" href="#">'+
					                               '<i class="fa fa-trash-o"></i>'+
				                                   '</a>'+
			                               '</div>'+
		                                  '</li>';
								
								
								// context += '<li>' +
								// 	'<div>' +
								// //	'<img src="' + simpleData.listCommoditityPO[i].c_img + '">' +
								// 	'</div>' +
								// 	'<div>' +
								// 	'商品名称：<h3>' + commoInfo[i].c_name + '</h3>' +
								// 	'商品数量：<input type="text"  id="ccount'+cartInfo[i].s_id+'" onblur="updateCart('+cartInfo[i].s_id+')" value="' + cartInfo[i].s_num + '" />'+
								// 	//'商品数量：<p>' + cartInfo[i].s_num + '</p>' +
								// 	'单价：<p>' + commoInfo[i].c_price + '</p>' +
								// 	//该位置计算金额，建议使用中间表的方式，获取金额，以免不安全（创建一个联表视图，让：数量*金额）
								// 	'金额：<p>' + cartInfo[i].s_num*commoInfo[i].c_price + '</p>'
								// 	//这里可以放置一个 隐藏的button 一旦点击，就执行添加购物车的方法
								// 	+
								// 	'<button type="button" id="sc_id" value="' + cartInfo[i].s_id +
								// 	'" onclick="removeCart('+cartInfo[i].s_id+')">删除</input>' +
								// 	'</div>' +
								// 	'</li>';
							}
							
							$("#cart").html(context)
						}
					})
				}
		</script>
		
	</head>

	<body>
		<!--[if lt IE 8]>
        <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
    <![endif]-->

		<!-- Body main wrapper start -->
		<div class="wrapper">
			<!-- Start of header area -->
			<%@ include file="header.jsp" %>
			<!-- End of header area -->
			<!-- Start of slider area -->
			<section class="slider-container">
			<!-- Start page content -->
			<section id="page-content" class="page-wrapper">
				<!-- Start About us Area -->
				<div class="why-us section-padding text-center">
					<div class="container">
						<div class="row">
							
						</div>
					</div>
				</div>
				<!-- End About us Area -->

				<!-- Start New Arrival Area  -->
				<div class="new-arrival-area">
					<div class="container">
						<div class="row rp-style-2">
							<div class="col-md-12">
								<div class="section-title text-center mb-35">
									<h2 class="text-uppercase"><strong>FRESH NEW ARRIVAL</strong></h2>
									<p class="text-defualt">ALL NEW ITEAMS</p>
									<img alt="" src="images/section-border.png">
								</div>
							</div>
						</div>
						<div class="row rp-style-2">
							<div class="featured-carousel indicator-style">
								<div class="product-container cp-style-2">
									<div class="product-inner">
										<a href="#">
											<div class="product-img b-img">
												<img src="images/product/arrival/1.jpg" alt="">
											</div>
										</a>
										<span class="product-tag text-uppercase orang-bg">-20%</span>
										<ul class="quick-veiw text-center">
											<li><a href="#"><i class="fa fa-shopping-cart"></i></a></li>
											<li><a href="#"><i class="fa fa-eye"></i></a></li>
											<li><a href="#"><i class="fa fa-refresh"></i></a></li>
											<li><a href="#"><i class="fa fa-heart"></i></a></li>
										</ul>
										<div class="product-text">
											<ul class="pull-left list-inline ratings">
												<li><i class="rated fa fa-star"></i></li>
												<li><i class="rated fa fa-star"></i></li>
												<li><i class="rated fa fa-star"></i></li>
												<li><i class="rated fa fa-star"></i></li>
												<li><i class="rated fa fa-star"></i></li>
											</ul>
											<ul class="pricing list-inline pull-right">
												<li class="text-right c-price">$170</li>
												<li class="text-right p-price">$190</li>
											</ul>
											<div class="clear"></div>
											<h6 class="product-name">
												<a href="#" title="Eletria ostma">Teletria ostma</a>
											</h6>
										</div>
									</div>
									<div class="product-inner mt-35">
										<a href="#">
											<div class="product-img b-img">
												<img src="images/product/arrival/2.jpg" alt="">
											</div>
										</a>
										<ul class="quick-veiw text-center">
											<li><a href="#"><i class="fa fa-shopping-cart"></i></a></li>
											<li><a href="#"><i class="fa fa-eye"></i></a></li>
											<li><a href="#"><i class="fa fa-refresh"></i></a></li>
											<li><a href="#"><i class="fa fa-heart"></i></a></li>
										</ul>
										<div class="product-text">
											<ul class="pull-left list-inline ratings">
												<li><i class="rated fa fa-star"></i></li>
												<li><i class="rated fa fa-star"></i></li>
												<li><i class="rated fa fa-star"></i></li>
												<li><i class="rated fa fa-star"></i></li>
												<li><i class="rated fa fa-star"></i></li>
											</ul>
											<ul class="pricing list-inline pull-right">
												<li class="text-right c-price">$160</li>
												<li class="text-right p-price">$180</li>
											</ul>
											<div class="clear"></div>
											<h6 class="product-name">
												<a href="#" title="Eletria ostma">Eletria ostma</a>
											</h6>
										</div>
									</div>
								</div>
								<div class="product-container cp-style-2">
									<div class="product-inner">
										<a href="#">
											<div class="product-img b-img">
												<img src="images/product/arrival/3.jpg" alt="">
											</div>
										</a>
										<span class="product-tag text-uppercase black-bg">new</span>
										<ul class="quick-veiw text-center">
											<li><a href="#"><i class="fa fa-shopping-cart"></i></a></li>
											<li><a href="#"><i class="fa fa-eye"></i></a></li>
											<li><a href="#"><i class="fa fa-refresh"></i></a></li>
											<li><a href="#"><i class="fa fa-heart"></i></a></li>
										</ul>
										<div class="product-text">
											<ul class="pull-left list-inline ratings">
												<li><i class="rated fa fa-star"></i></li>
												<li><i class="rated fa fa-star"></i></li>
												<li><i class="rated fa fa-star"></i></li>
												<li><i class="rated fa fa-star"></i></li>
												<li><i class="rated fa fa-star"></i></li>
											</ul>
											<ul class="pricing list-inline pull-right">
												<li class="text-right c-price">$170</li>
												<li class="text-right p-price">$190</li>
											</ul>
											<div class="clear"></div>
											<h6 class="product-name">
												<a href="#" title="Wetria postma">Wetria postma</a>
											</h6>
										</div>
									</div>
									<div class="product-inner mt-35">
										<a href="#">
											<div class="product-img b-img">
												<img src="images/product/arrival/4.jpg" alt="">
											</div>
										</a>
										<span class="product-tag text-uppercase orang-bg">-20%</span>
										<ul class="quick-veiw text-center">
											<li><a href="#"><i class="fa fa-shopping-cart"></i></a></li>
											<li><a href="#"><i class="fa fa-eye"></i></a></li>
											<li><a href="#"><i class="fa fa-refresh"></i></a></li>
											<li><a href="#"><i class="fa fa-heart"></i></a></li>
										</ul>
										<div class="product-text">
											<ul class="pull-left list-inline ratings">
												<li><i class="rated fa fa-star"></i></li>
												<li><i class="rated fa fa-star"></i></li>
												<li><i class="rated fa fa-star"></i></li>
												<li><i class="rated fa fa-star"></i></li>
												<li><i class="rated fa fa-star"></i></li>
											</ul>
											<ul class="pricing list-inline pull-right">
												<li class="text-right c-price">$160</li>
												<li class="text-right p-price">$180</li>
											</ul>
											<div class="clear"></div>
											<h6 class="product-name">
												<a href="#" title="Eletria ostma">Eletria ostma</a>
											</h6>
										</div>
									</div>
								</div>
								<div class="product-container cp-style-2">
									<div class="product-inner">
										<a href="#">
											<div class="product-img b-img">
												<img src="images/product/arrival/5.jpg" alt="">
											</div>
										</a>
										<ul class="quick-veiw text-center">
											<li><a href="#"><i class="fa fa-shopping-cart"></i></a></li>
											<li><a href="#"><i class="fa fa-eye"></i></a></li>
											<li><a href="#"><i class="fa fa-refresh"></i></a></li>
											<li><a href="#"><i class="fa fa-heart"></i></a></li>
										</ul>
										<div class="product-text">
											<ul class="pull-left list-inline ratings">
												<li><i class="rated fa fa-star"></i></li>
												<li><i class="rated fa fa-star"></i></li>
												<li><i class="rated fa fa-star"></i></li>
												<li><i class="rated fa fa-star"></i></li>
												<li><i class="rated fa fa-star"></i></li>
											</ul>
											<ul class="pricing list-inline pull-right">
												<li class="text-right c-price">$170</li>
												<li class="text-right p-price">$190</li>
											</ul>
											<div class="clear"></div>
											<h6 class="product-name">
												<a href="#" title="Kelletria ostma">Kelletria ostma</a>
											</h6>
										</div>
									</div>
									<div class="product-inner mt-35">
										<a href="#">
											<div class="product-img b-img">
												<img src="images/product/arrival/6.jpg" alt="">
											</div>
										</a>
										<span class="product-tag text-uppercase black-bg">new</span>
										<ul class="quick-veiw text-center">
											<li><a href="#"><i class="fa fa-shopping-cart"></i></a></li>
											<li><a href="#"><i class="fa fa-eye"></i></a></li>
											<li><a href="#"><i class="fa fa-refresh"></i></a></li>
											<li><a href="#"><i class="fa fa-heart"></i></a></li>
										</ul>
										<div class="product-text">
											<ul class="pull-left list-inline ratings">
												<li><i class="rated fa fa-star"></i></li>
												<li><i class="rated fa fa-star"></i></li>
												<li><i class="rated fa fa-star"></i></li>
												<li><i class="rated fa fa-star"></i></li>
												<li><i class="rated fa fa-star"></i></li>
											</ul>
											<ul class="pricing list-inline pull-right">
												<li class="text-right c-price">$160</li>
												<li class="text-right p-price">$180</li>
											</ul>
											<div class="clear"></div>
											<h6 class="product-name">
												<a href="#" title="Eletria ostma">Eletria ostma</a>
											</h6>
										</div>
									</div>
								</div>
								<div class="product-container cp-style-2">
									<div class="product-inner">
										<a href="#">
											<div class="product-img b-img">
												<img src="images/product/arrival/7.jpg" alt="">
											</div>
										</a>
										<span class="product-tag text-uppercase orang-bg">-20%</span>
										<ul class="quick-veiw text-center">
											<li><a href="#"><i class="fa fa-shopping-cart"></i></a></li>
											<li><a href="#"><i class="fa fa-eye"></i></a></li>
											<li><a href="#"><i class="fa fa-refresh"></i></a></li>
											<li><a href="#"><i class="fa fa-heart"></i></a></li>
										</ul>
										<div class="product-text">
											<ul class="pull-left list-inline ratings">
												<li><i class="rated fa fa-star"></i></li>
												<li><i class="rated fa fa-star"></i></li>
												<li><i class="rated fa fa-star"></i></li>
												<li><i class="rated fa fa-star"></i></li>
												<li><i class="rated fa fa-star"></i></li>
											</ul>
											<ul class="pricing list-inline pull-right">
												<li class="text-right c-price">$170</li>
												<li class="text-right p-price">$190</li>
											</ul>
											<div class="clear"></div>
											<h6 class="product-name">
												<a href="#" title="Celletria ostma">Celletria ostma</a>
											</h6>
										</div>
									</div>
									<div class="product-inner mt-35">
										<a href="#">
											<div class="product-img b-img">
												<img src="images/product/arrival/8.jpg" alt="">
											</div>
										</a>
										<ul class="quick-veiw text-center">
											<li><a href="#"><i class="fa fa-shopping-cart"></i></a></li>
											<li><a href="#"><i class="fa fa-eye"></i></a></li>
											<li><a href="#"><i class="fa fa-refresh"></i></a></li>
											<li><a href="#"><i class="fa fa-heart"></i></a></li>
										</ul>
										<div class="product-text">
											<ul class="pull-left list-inline ratings">
												<li><i class="rated fa fa-star"></i></li>
												<li><i class="rated fa fa-star"></i></li>
												<li><i class="rated fa fa-star"></i></li>
												<li><i class="rated fa fa-star"></i></li>
												<li><i class="rated fa fa-star"></i></li>
											</ul>
											<ul class="pricing list-inline pull-right">
												<li class="text-right c-price">$160</li>
												<li class="text-right p-price">$180</li>
											</ul>
											<div class="clear"></div>
											<h6 class="product-name">
												<a href="#" title="Eletria ostma">Eletria ostma</a>
											</h6>
										</div>
									</div>
								</div>
								<div class="product-container cp-style-2">
									<div class="product-inner">
										<a href="#">
											<div class="product-img b-img">
												<img src="images/product/arrival/9.jpg" alt="">
											</div>
										</a>
										<ul class="quick-veiw text-center">
											<li><a href="#"><i class="fa fa-shopping-cart"></i></a></li>
											<li><a href="#"><i class="fa fa-eye"></i></a></li>
											<li><a href="#"><i class="fa fa-refresh"></i></a></li>
											<li><a href="#"><i class="fa fa-heart"></i></a></li>
										</ul>
										<div class="product-text">
											<ul class="pull-left list-inline ratings">
												<li><i class="rated fa fa-star"></i></li>
												<li><i class="rated fa fa-star"></i></li>
												<li><i class="rated fa fa-star"></i></li>
												<li><i class="rated fa fa-star"></i></li>
												<li><i class="rated fa fa-star"></i></li>
											</ul>
											<ul class="pricing list-inline pull-right">
												<li class="text-right c-price">$170</li>
												<li class="text-right p-price">$190</li>
											</ul>
											<div class="clear"></div>
											<h6 class="product-name">
												<a href="#" title="Celletria ostma">Celletria ostma</a>
											</h6>
										</div>
									</div>
									<div class="product-inner mt-35">
										<a href="#">
											<div class="product-img b-img">
												<img src="images/product/arrival/10.jpg" alt="">
											</div>
										</a>
										<span class="product-tag text-uppercase orang-bg">-20%</span>
										<ul class="quick-veiw text-center">
											<li><a href="#"><i class="fa fa-shopping-cart"></i></a></li>
											<li><a href="#"><i class="fa fa-eye"></i></a></li>
											<li><a href="#"><i class="fa fa-refresh"></i></a></li>
											<li><a href="#"><i class="fa fa-heart"></i></a></li>
										</ul>
										<div class="product-text">
											<ul class="pull-left list-inline ratings">
												<li><i class="rated fa fa-star"></i></li>
												<li><i class="rated fa fa-star"></i></li>
												<li><i class="rated fa fa-star"></i></li>
												<li><i class="rated fa fa-star"></i></li>
												<li><i class="rated fa fa-star"></i></li>
											</ul>
											<ul class="pricing list-inline pull-right">
												<li class="text-right c-price">$160</li>
												<li class="text-right p-price">$180</li>
											</ul>
											<div class="clear"></div>
											<h6 class="product-name">
												<a href="#" title="Eletria ostma">Eletria ostma</a>
											</h6>
										</div>
									</div>
								</div>
								<div class="product-container cp-style-2">
									<div class="product-inner">
										<a href="#">
											<div class="product-img b-img">
												<img src="images/product/arrival/1.jpg" alt="">
											</div>
										</a>
										<span class="product-tag text-uppercase orang-bg">-20%</span>
										<ul class="quick-veiw text-center">
											<li><a href="#"><i class="fa fa-shopping-cart"></i></a></li>
											<li><a href="#"><i class="fa fa-eye"></i></a></li>
											<li><a href="#"><i class="fa fa-refresh"></i></a></li>
											<li><a href="#"><i class="fa fa-heart"></i></a></li>
										</ul>
										<div class="product-text">
											<ul class="pull-left list-inline ratings">
												<li><i class="rated fa fa-star"></i></li>
												<li><i class="rated fa fa-star"></i></li>
												<li><i class="rated fa fa-star"></i></li>
												<li><i class="rated fa fa-star"></i></li>
												<li><i class="rated fa fa-star"></i></li>
											</ul>
											<ul class="pricing list-inline pull-right">
												<li class="text-right c-price">$170</li>
												<li class="text-right p-price">$190</li>
											</ul>
											<div class="clear"></div>
											<h6 class="product-name">
												<a href="#" title="Eletria ostma">Teletria ostma</a>
											</h6>
										</div>
									</div>
									<div class="product-inner mt-35">
										<a href="#">
											<div class="product-img b-img">
												<img src="images/product/arrival/2.jpg" alt="">
											</div>
										</a>
										<ul class="quick-veiw text-center">
											<li><a href="#"><i class="fa fa-shopping-cart"></i></a></li>
											<li><a href="#"><i class="fa fa-eye"></i></a></li>
											<li><a href="#"><i class="fa fa-refresh"></i></a></li>
											<li><a href="#"><i class="fa fa-heart"></i></a></li>
										</ul>
										<div class="product-text">
											<ul class="pull-left list-inline ratings">
												<li><i class="rated fa fa-star"></i></li>
												<li><i class="rated fa fa-star"></i></li>
												<li><i class="rated fa fa-star"></i></li>
												<li><i class="rated fa fa-star"></i></li>
												<li><i class="rated fa fa-star"></i></li>
											</ul>
											<ul class="pricing list-inline pull-right">
												<li class="text-right c-price">$160</li>
												<li class="text-right p-price">$180</li>
											</ul>
											<div class="clear"></div>
											<h6 class="product-name">
												<a href="#" title="Eletria ostma">Eletria ostma</a>
											</h6>
										</div>
									</div>
								</div>
								<div class="product-container cp-style-2">
									<div class="product-inner">
										<a href="#">
											<div class="product-img b-img">
												<img src="images/product/arrival/3.jpg" alt="">
											</div>
										</a>
										<span class="product-tag text-uppercase black-bg">new</span>
										<ul class="quick-veiw text-center">
											<li><a href="#"><i class="fa fa-shopping-cart"></i></a></li>
											<li><a href="#"><i class="fa fa-eye"></i></a></li>
											<li><a href="#"><i class="fa fa-refresh"></i></a></li>
											<li><a href="#"><i class="fa fa-heart"></i></a></li>
										</ul>
										<div class="product-text">
											<ul class="pull-left list-inline ratings">
												<li><i class="rated fa fa-star"></i></li>
												<li><i class="rated fa fa-star"></i></li>
												<li><i class="rated fa fa-star"></i></li>
												<li><i class="rated fa fa-star"></i></li>
												<li><i class="rated fa fa-star"></i></li>
											</ul>
											<ul class="pricing list-inline pull-right">
												<li class="text-right c-price">$170</li>
												<li class="text-right p-price">$190</li>
											</ul>
											<div class="clear"></div>
											<h6 class="product-name">
												<a href="#" title="Wetria postma">Wetria postma</a>
											</h6>
										</div>
									</div>
									<div class="product-inner mt-35">
										<a href="#">
											<div class="product-img b-img">
												<img src="images/product/arrival/4.jpg" alt="">
											</div>
										</a>
										<span class="product-tag text-uppercase orang-bg">-20%</span>
										<ul class="quick-veiw text-center">
											<li><a href="#"><i class="fa fa-shopping-cart"></i></a></li>
											<li><a href="#"><i class="fa fa-eye"></i></a></li>
											<li><a href="#"><i class="fa fa-refresh"></i></a></li>
											<li><a href="#"><i class="fa fa-heart"></i></a></li>
										</ul>
										<div class="product-text">
											<ul class="pull-left list-inline ratings">
												<li><i class="rated fa fa-star"></i></li>
												<li><i class="rated fa fa-star"></i></li>
												<li><i class="rated fa fa-star"></i></li>
												<li><i class="rated fa fa-star"></i></li>
												<li><i class="rated fa fa-star"></i></li>
											</ul>
											<ul class="pricing list-inline pull-right">
												<li class="text-right c-price">$160</li>
												<li class="text-right p-price">$180</li>
											</ul>
											<div class="clear"></div>
											<h6 class="product-name">
												<a href="#" title="Eletria ostma">Eletria ostma</a>
											</h6>
										</div>
									</div>
								</div>
								<div class="product-container cp-style-2">
									<div class="product-inner">
										<a href="#">
											<div class="product-img b-img">
												<img src="images/product/arrival/5.jpg" alt="">
											</div>
										</a>
										<ul class="quick-veiw text-center">
											<li><a href="#"><i class="fa fa-shopping-cart"></i></a></li>
											<li><a href="#"><i class="fa fa-eye"></i></a></li>
											<li><a href="#"><i class="fa fa-refresh"></i></a></li>
											<li><a href="#"><i class="fa fa-heart"></i></a></li>
										</ul>
										<div class="product-text">
											<ul class="pull-left list-inline ratings">
												<li><i class="rated fa fa-star"></i></li>
												<li><i class="rated fa fa-star"></i></li>
												<li><i class="rated fa fa-star"></i></li>
												<li><i class="rated fa fa-star"></i></li>
												<li><i class="rated fa fa-star"></i></li>
											</ul>
											<ul class="pricing list-inline pull-right">
												<li class="text-right c-price">$170</li>
												<li class="text-right p-price">$190</li>
											</ul>
											<div class="clear"></div>
											<h6 class="product-name">
												<a href="#" title="Kelletria ostma">Kelletria ostma</a>
											</h6>
										</div>
									</div>
									<div class="product-inner mt-35">
										<a href="#">
											<div class="product-img b-img">
												<img src="images/product/arrival/6.jpg" alt="">
											</div>
										</a>
										<span class="product-tag text-uppercase black-bg">new</span>
										<ul class="quick-veiw text-center">
											<li><a href="#"><i class="fa fa-shopping-cart"></i></a></li>
											<li><a href="#"><i class="fa fa-eye"></i></a></li>
											<li><a href="#"><i class="fa fa-refresh"></i></a></li>
											<li><a href="#"><i class="fa fa-heart"></i></a></li>
										</ul>
										<div class="product-text">
											<ul class="pull-left list-inline ratings">
												<li><i class="rated fa fa-star"></i></li>
												<li><i class="rated fa fa-star"></i></li>
												<li><i class="rated fa fa-star"></i></li>
												<li><i class="rated fa fa-star"></i></li>
												<li><i class="rated fa fa-star"></i></li>
											</ul>
											<ul class="pricing list-inline pull-right">
												<li class="text-right c-price">$160</li>
												<li class="text-right p-price">$180</li>
											</ul>
											<div class="clear"></div>
											<h6 class="product-name">
												<a href="#" title="Eletria ostma">Eletria ostma</a>
											</h6>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<!-- End Of New Arrival Area  -->
				<!-- Start Offer Banner Area -->

				<!-- End Offer Banner Area -->
				<!-- Start Best Seller Iteams Area -->
				<div class="best-saller-iteam-area pb-90">
					<div class="container">
						<div class="row">
							<div class="col-md-6 cp-style-2">
								
							</div>
							
						</div>
					</div>
				</div>
				<!-- End Of Best Seller Iteams Area -->
				<!-- Start Blog Area -->

				<!-- End Blog Area -->
				<!-- Start Brand Area -->
				<div class="brand-area pb-90">
					<div class="container">
						<div class="row">
							<div class="col-md-12">
								<div class="section-title text-center mb-35">
									<h2 class="text-uppercase"><strong>OUR BRAND</strong></h2>
									<p class="text-defualt">BRAND</p>
									<img alt="" src="images/section-border.png">
								</div>
								<div class="brand-carousel">

								</div>
							</div>
						</div>
					</div>
				</div>
				<!-- End Brand Area -->
			</section>
			<!-- End page content -->
			<!-- Start footer area -->
			<footer id="footer" class="footer-area">


				
				<div class="footer-bottom-area">
					<div class="container">
						<div class="row">
							<div class="col-md-4 col-sm-6 col-xs-12">
								<div class="copyright">
									<p>Copyright &copy; 2017.Company name All rights reserved.</p>
								</div>
							</div>
							<div class="col-md-5 hidden-sm hidden-xs">
								<nav>
									<ul class="footer-bottom-menu">
										<li><a href="#">Site Map</a></li>
										<li><a href="contact.html">Contact Us</a></li>
										<li><a href="">Wish List</a></li>
										<li><a href="#">Newsletter</a></li>
									</ul>
								</nav>
							</div>
							<div class="col-md-3 col-sm-6 col-xs-12">
								<div class="payment-method b-img">
									<img alt="" src="images/footer/footer-bottom.png">
								</div>
							</div>
						</div>
					</div>
				</div>
			</footer>
			<!-- End footer area -->
		</div>
		<!-- Body main wrapper end -->

		<!-- Placed js at the end of the document so the pages load faster -->

		<!-- jquery latest version -->
		<script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>
		<!-- Bootstrap framework js -->
		<script src="http://www.jq22.com/jquery/bootstrap-3.3.4.js"></script>
		<!-- All js plugins included in this file. -->
		<script src="js/plugins.js"></script>
		<!-- Main js file that contents all jQuery plugins activation. -->
		<script src="js/main.js"></script>
		<!-- jquery.scrollUp.min.js -->
		<script src="js/main.js"></script>
	</body>

</html>
