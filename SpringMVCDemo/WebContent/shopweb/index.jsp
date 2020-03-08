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
		<script src="./js/vendor/jquery-1.12.4.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/vendor/jquery.js" type="text/javascript" charset="utf-8"></script>
		<script src="./js/commotype.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/showcart.js" type="text/javascript" charset="utf-8"></script>
		<!-- 购物车回显 -->
	</head>

	<body>
		<!--[if lt IE 8]>
        <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
    <![endif]-->

		<!-- Body main wrapper start -->
		<div class="wrapper">
			<!-- Start of header area -->
			<header>
				<div class="header-top gray-bg">
					<div class="container">
						<div class="row">
							<div class="col-sm-5 hidden-xs">
								<div class="header-top-left">
									<ul class="header-top-style text-capitalize mr-25">
										<li><a href="#"><span class="mr-10">My Account</span><i class="fa fa-angle-down"></i></a>
											<ul class="ul-style my-account box-shadow white-bg">
												<li><a href="login.jsp">Login</a></li>
												<li><a href="my-account.jsp">My Account</a></li>
											</ul>
										</li>
									</ul>
								</div>
							</div>
							<div class="col-sm-3 col-xs-6">
								<div class="header-top-middle">
									<ul class="header-top-style">
										<li>
											<a href="login.jsp">
												<span>Login or Register</span>
											</a>
											<div class="ul-style login-register box-shadow white-bg p-30">
												<h6 class="mb-20"><strong>Login</strong></h6>
												<input type="text" name="s" class="pl-30" placeholder="user name" id="user-name">
												<input type="password" name="d" class="pl-30" placeholder="Password" id="password">
												<label class="remmember">
													<input type="checkbox">
													remember me
												</label>
												<button value="submit" class="btn-default">Login</button>
												<h6 class="mb-20"><strong>or Register</strong></h6>
												<input type="email" name="s" placeholder="Your mail" id="user-email">
												<input type="password" name="d" placeholder="Password" id="c-password">
												<button value="submit" class="btn-default">Login</button>
												<h6 class="mb-20"><strong>or register to</strong></h6>
												<ul class="login-social">
													<li><a href="#"><i class="fa fa-facebook"></i></a></li>
													<li><a href="#"><i class="fa fa-twitter"></i></a></li>
													<li><a href="#"><i class="fa fa-linkedin"></i></a></li>
													<li><a href="#"><i class="fa fa-google-plus"></i></a></li>
												</ul>
											</div>
										</li>
									</ul>
								</div>
							</div>
							<div class="col-sm-4 col-xs-6">
								<div class="header-top-right">
									<span class="mr-20"><a href="#"><img alt="" src="images/header/search-icon.png"></a></span>
									<span><input type="text" class="pl-10" placeholder="Search..."></span>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="header-bottom">
					<div class="container">
						<div class="row header-middle-content">
							<div class="col-md-5 col-sm-4 hidden-xs">
								<div class="service-inner mt-10">
                                <span class="service-img b-img">
                                    <img alt="" src="images/service.png">
                                </span>
                                <span class="service-content ml-15"><strong>+88 (012) 564 979 56</strong><br>We are open 9 am - 10 pm</span>
                            </div>
							</div>
							<div class="col-md-2 col-sm-4 col-xs-12">
								<div class="header-logo text-center">
									<a href="index.html"><img alt="" src="images/logo.png"></a>
								</div>
							</div>




							<div class="col-md-offset-0 col-md-5 col-sm-offset-0 col-sm-4 col-xs-offset-3 col-xs-6">
								<div class="shopping-cart">
									<a href="order.jsp">
										<span class="shopping-cart-control">
											<img alt="" src="images/shop.png">
										</span>
										<span class="cart-size-value"><strong>购物车</strong><br>
										     <span id="totalprice">
										     	
										     </span>
										</span>
									</a>
									<ul id="showcart" class="shopping-cart-down box-shadow white-bg">
										
										
<!-- 										<li class="media">
											<span class="total-title pull-left">Sub Total</span>
											<span class="total pull-right"></span>
										</li>
										
										<li class="media">
											<a class="cart-btn" href="#">VIEW CART</a>
											<a class="cart-btn" href="#">CHECKOUT</a>
										</li> -->
									</ul>
								</div>
							</div>
							<nav class="primary-menu">
								<ul class="header-top-style text-uppercase">
									<li><a href="index.html">home</a></li>
									<li><a href="about.html">about</a></li>
									<li><a href="shop.html">shop</a></li>
									<li><a href="contact.html">contact</a></li>

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
											<li><a href="index.html">home</a></li>
											<li><a href="about.html">about</a></li>
											<li><a href="shop.html">shop</a></li>
											<li><a href="contact.html">contact</a></li>
										</ul>
									</nav>
								</div>
							</div>
						</div>
					</div>
				</div>
				<!-- Mobile Menu End -->
			</header>
			<!-- End of header area -->
			<!-- Start of slider area -->
			<section class="slider-container">
				<!-- Slider Image -->
				<div id="mainSlider" class="nivoSlider slider-image">
					<img src="images/slider/1.jpg" alt="main slider" title="#htmlcaption1">
					<img src="images/slider/2.jpg" alt="main slider" title="#htmlcaption2">
				</div>
				<!-- Slider Caption 1 -->
				<div id="htmlcaption1" class="nivo-html-caption slider-caption-1">
					<div class="slider-progress"></div>
					<div class="container slider-height">
						<div class="row slider-height">
							<div class="col-xs-offset-6 col-xs-6 slider-height">
								<div class="slide-text">
									<div class="middle-text">
										<div class="cap-dec text-black text-uppercase wow fadeInDown" data-wow-duration="0.9s" data-wow-delay="0s">
											<h3>TRENDY DRESS COLLETIONS</h3>
										</div>
										<div class="cap-title text-black text-uppercase wow fadeInDown" data-wow-duration="1.5s" data-wow-delay="0.5s">
											<h2>FOR WOMEN - 2017</h2>
										</div>
										<div class="cap-para wow fadeInDown" data-wow-duration="2s" data-wow-delay="1s">
											<p>Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat vel illum dolore
												eu feugiat nulla facilisis at vero eros.</p>
										</div>
										<div class="cap-shop wow text-uppercase fadeInDown" data-wow-duration="2.5s" data-wow-delay="1.5s">
											<a href="#">Shop now</a>
											<button type="button" onclick="showCart()">点击提交</button>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<!-- Slider Caption 2 -->
				<div id="htmlcaption2" class="nivo-html-caption slider-caption-2">
					<div class="slider-progress"></div>
					<div class="container slider-height">
						<div class="row slider-height">
							<div class="col-xs-offset-5 col-xs-7 slider-height">
								<div class="slide-text">
									<div class="middle-text">
										<div class="cap-dec text-black text-uppercase wow fadeInDown" data-wow-duration="0.9s" data-wow-delay="0s">
											<h3>EXCLUSIVE COLLETIONS</h3>
										</div>
										<div class="cap-title text-black text-uppercase wow fadeInDown" data-wow-duration="1.5s" data-wow-delay="0.5s">
											<h2>OVER COATS FOR MAN</h2>
										</div>
										<div class="cap-para wow fadeInDown" data-wow-duration="2s" data-wow-delay="1s">
											<p>Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat vel illum dolore
												eu feugiat nulla facilisis at vero eros.</p>
										</div>
										<div class="cap-shop wow fadeInDown" data-wow-duration="2.5s" data-wow-delay="1.5s">
											<a href="#">Shop now</a>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</section>
			<!-- End of slider area -->
			<!-- Start page content -->
			<section id="page-content" class="page-wrapper">
				<!-- Start About us Area -->
				<div class="why-us section-padding text-center">
					<div class="container">
						<div class="row">
							<div class="col-md-3 col-sm-4">
								<div class="why-us-inner">
									<div class="why-us-icon mb-20">
										<img src="images/why-us/1.png" alt="">
									</div>
									<h5 class="text-uppercase m-0 text-defualt"><strong>FREE SHIPPING</strong></h5>
									<p class="why-us-title m-0">Free for all product</p>
								</div>
							</div>
							<div class="col-md-3 col-sm-4">
								<div class="why-us-inner">
									<div class="why-us-icon mb-20">
										<img src="images/why-us/2.png" alt="">
									</div>
									<h5 class="text-uppercase m-0 text-defualt"><strong>ORDER ONLINE</strong></h5>
									<p class="why-us-title m-0">www.forge.com</p>
								</div>
							</div>
							<div class="col-md-3 col-sm-4">
								<div class="why-us-inner">
									<div class="why-us-icon mb-20">
										<img src="images/why-us/3.png" alt="">
									</div>
									<h5 class="text-uppercase m-0 text-defualt"><strong>MONEY BACK</strong></h5>
									<p class="why-us-title m-0">Money back guarantee</p>
								</div>
							</div>
							<div class="col-md-3 hidden-sm">
								<div class="why-us-inner m-0">
									<div class="why-us-icon mb-20">
										<img src="images/why-us/4.png" alt="">
									</div>
									<h5 class="text-uppercase m-0 text-defualt"><strong>GIFT COUPON</strong></h5>
									<p class="why-us-title m-0">Surprise gift coupon</p>
								</div>
							</div>
						</div>
					</div>
				</div>
				<!-- End About us Area -->
				<!-- Start Banner Area -->
				<div class="banner-area" >
					<div class="container">
						<div class="row rp-style">
							<div class="col-sm-8 cp-style">
							    <div class="row rp-style" id="showAllType"> 


									
										</div>
									</div>
									
									
									<!-- start 商品类型1 -->
									<div class="col-sm-4 cp-style">
										<div class="banner-inner">
											<a class="test-popup-link banner-img" href="images/banner/1.jpg">
												<img src="images/banner/1.jpg" alt="">
											</a>
											<div class="banner-text banner-text-1">
												<a href="#" class="banner-heading text-uppercase text-right">其 他 类 型 ，陆 续 上 市</a>
												<h3 class="banner-title text-uppercase text-right">敬 请 期 待...</h3>
											</div>
										</div>
									</div>
									<!-- end 商品类型1 -->
									
									
							<!-- 以上插入商品类型 -->
							
						</div>
					</div>
				</div>
				<!-- End Banner Area -->

				<!-- Start New Arrival Area  -->
				<div class="new-arrival-area">
					<div class="container">
						<div class="row rp-style-2">
							<div class="col-md-12">
								<div class="section-title text-center mb-35">

								</div>
							</div>
						</div>
						<div class="row rp-style-2">
							<div class="featured-carousel indicator-style">

							</div>
						</div>
					</div>
				</div>
				<!-- End Of New Arrival Area  -->

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
