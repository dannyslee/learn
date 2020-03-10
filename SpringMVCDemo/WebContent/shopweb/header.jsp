<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html class="no-js" lang="zxx">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

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
		<script src="./js/vendor/jquery-1.12.4.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/vendor/jquery.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/showcart.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/choose-account.js" type="text/javascript" charset="utf-8"></script>
	</head>

</head>
<body>
	<header>
		<div class="header-top gray-bg">
			<div class="container">
				<div class="row">
					<div class="col-sm-5 hidden-xs">
						<div class="header-top-left">
							<ul class="header-top-style text-capitalize mr-25">
								<%
									if (request.getSession(false).getAttribute("user") == null) {
								%>
								<li><a href="login.jsp"><span class="mr-10">登录</span></a></li>
								<%
									} else {
								%>
								<li><a href="../controller/user/chooseAccount"><span class="mr-10">我的账户</span><i class="fa fa-angle-down"></i></a>
								     <ul class="ul-style my-account box-shadow white-bg">
                                            <li><a href="../controller/user/logout">注销</a></li>
                                    </ul>
								</li>
								<%
									}
								%>
							</ul>
						</div>
					</div>
					<div class="col-sm-3 col-xs-6">
						<div class="header-top-middle">
							<ul class="header-top-style">
							</ul>
						</div>
					</div>
					<div class="col-sm-4 col-xs-6">
						<!-- 								<div class="header-top-right">
									<span class="mr-20"><a href="#"><img alt="" src="images/header/search-icon.png"></a></span>
									<span><input type="text" class="pl-10" placeholder="Search..."></span>
								</div> -->
					</div>
				</div>
			</div>
		</div>
		<div class="header-bottom">
			<div class="container">
				<div class="row header-middle-content">
					<div class="col-md-5 col-sm-4 hidden-xs">
						<div class="service-inner mt-10">
							<span class="service-img b-img"> <img alt=""
								src="images/service.png">
							</span> <span class="service-content ml-15"><strong>+88
									(012) 564 979 56</strong><br>We are open 9 am - 10 pm</span>
						</div>
					</div>
					<div class="col-md-2 col-sm-4 col-xs-12">
						<div class="header-logo text-center">
							<a href="index.jsp"><img alt="" src="images/logo.png"></a>
						</div>
					</div>

					<div
						class="col-md-offset-0 col-md-5 col-sm-offset-0 col-sm-4 col-xs-offset-3 col-xs-6">
						<div class="shopping-cart">
							<a href="order.jsp"> <span class="shopping-cart-control">
									<img alt="" src="images/shop.png">
							</span> <span class="cart-size-value"><strong>购物车</strong><br>
									<span id="totalprice"> </span> </span>
							</a>
							<ul class="shopping-cart-down box-shadow white-bg" id="showcart"></ul>
						</div>
					</div>
					<nav class="primary-menu">
						<ul class="header-top-style text-uppercase">
							<li><a href="index.jsp">home</a></li>

						</ul>
					</nav>
				</div>
			</div>
		</div>
		<!-- Mobile Menu Start -->
		<div class="mobile-menu-area">
			<div class="container">
				<div class="row">
					<div class="col-lg-12 col-md-12 col-sm-12">
						<div class="mobile-menu">
							<nav id="dropdown">
								<ul>
									<li><a href="index.jsp">home</a></li>

								</ul>
							</nav>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- Mobile Menu End -->
	</header>
</body>
</html>