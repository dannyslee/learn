<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html class="no-js" lang="zxx">

<head>
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>My Account</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Favicon -->
<link rel="shortcut icon" type="image/x-icon" href="images/favicon.png">

<!-- All css files are included here -->
<!-- Bootstrap fremwork main css -->
<link rel="stylesheet" type="text/css"
	href="http://www.jq22.com/jquery/bootstrap-3.3.4.css">
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
<script src="js/vendor/jquery.js" type="text/javascript" charset="utf-8"></script>
<script src="js/showorder.js" type="text/javascript" charset="utf-8"></script>
<script src="js/adminshow.js" type="text/javascript" charset="utf-8"></script>
</head>

<body>
	<!--[if lt IE 8]>
        <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
    <![endif]-->

	<!-- Body main wrapper start -->
	<div class="wrapper">
		<!-- Start of header area -->
		<%@ include file="header.jsp"%>
		<!-- End of header area -->
		<!-- Start Breadcrumbs Area -->
		<div class="breadcrumbs-area breadcrumbs-bg ptb-60">
			<div class="container">
				<div class="row">
					<div class="col-lg-12">
						<div class="breadcrumbs-inner">
							<h5 class="breadcrumbs-disc m-0">Best Products for you</h5>
							<h2 class="breadcrumbs-title text-black m-0">My Account</h2>
							<ul class="top-page">
								<li><a href="index.html">Home</a></li>
								<li>></li>
								<li>My Account</li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- End Breadcrumbs Area -->
		<!-- Start page content -->
		<section id="page-content" class="page-wrapper pt-10">
			<!-- Start My Account -->
			<div class="my-account-page section-padding">
				<div class="container">
					<!-- 后台处理的模板 -->
					<div class="row">
						<div class="col-md-12">
							<div class="procced-checkout">
								<h4 class="procced-title text-uppercase pb-15 mb-20">
									<strong>我的后台列表</strong>
								</h4>
								<p>可以在下面的选框处理相关业务</p>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="addresses-lists">
							<div class="col-xs-6 col-sm-6 col-lg-6">
								<div class="panel-group" id="accordion" role="tablist"
									aria-multiselectable="true">


<!-- 									<div class="panel panel-default">
										<div class="panel-heading" role="tab" id="headingTwo">
											<h4 class="panel-title">
												<a role="button" data-toggle="collapse"
													data-parent="#accordion" href="#collapseTwo"
													aria-expanded="true" aria-controls="collapseTwo"> <i
													class="fa fa-list-ol"></i> <span>商品处理</span>
												</a>
											</h4>
										</div>

										<div id="collapseTwo" class="panel-collapse collapse"
											role="tabpanel" aria-labelledby="headingTwo">
											<div class="panel-body">
												<div class="coupon-info">
													<h6 class="procced-title text-uppercase pb-15 mb-20">商品列表
													</h6>
												</div>
												<input type="text"></input>

												<div id="showOrderOne" class="alert">

													<p class="alert">
                                                          <span id="oid" class="alert">1</span>   <span id="odate" class="alert">2019-2-12 00：00：00</span>   <span id="status" class="alert">未支付</span>   <a class="alert" href="">xxxx</a>
                                                    </p> 
												</div>

											</div>
										</div>
									</div>
									 -->
									<!-- 库存与商品修改 -->
									
									<div class="panel panel-default">
										<div class="panel-heading" role="tab" id="headingOne">
											<h4 class="panel-title">
												<a role="button" data-toggle="collapse"
													data-parent="#accordion" href="#collapseOne"
													aria-expanded="true" aria-controls="collapseOne"> <i
													class="fa fa-list-ol"></i> <span>库存及商品处理</span>
												</a>
											</h4>
										</div>
										<div id="collapseOne" class="panel-collapse collapse"
											role="tabpanel" aria-labelledby="headingOne">
											<div class="panel-body">
												<div class="coupon-info">
													<h6 class="procced-title text-uppercase pb-15 mb-20">库存更改
													</h6>
												</div>
												
												

												<input type="text"></input>

												<div id="showCommo">
													<!-- <p class="alert">
														<span id="oid" class="alert">1</span> <span id="odate"
															class="alert">2019-2-12 00：00：00</span> <span id="status"
															class="alert">未支付</span> <a class="alert" href="">xxxx</a>
													</p>
													<p class="alert">
														<span id="oid" class="alert">1</span> <span id="odate"
															class="alert">2019-2-12 00：00：00</span> <span id="status"
															class="alert">未支付</span> <a class="alert" href="">xxxx</a>
													</p> -->
												</div>
												
												<div id="insert"></div>
												
												<!--  <div class="theme-bg">
                                                    <p class="alert text-white">You have not placed any orders.</p>
                                                </div> -->
											</div>
										</div>
									</div>


								

								</div>
							</div>
							<!-- 具体页面展示 -->
							<div class="col-xs-12 col-sm-6 col-lg-6">
							    <div class="myaccount-link-list" id="showOneCommo"></div>
							    
								<div class="myaccount-link-list" id="showItem"></div>
								
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- End of My Account -->
			<!-- Start Brand Area -->
			<div class="brand-area section-padding">
				<div class="container">
					<div class="row">
						<div class="col-md-12">
							<div class="section-title text-center mb-35">
								<h2 class="text-uppercase">
									<strong>OUR BRAND</strong>
								</h2>
								<p class="text-defualt">BRAND</p>
								<img alt="" src="images/section-border.png">
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
							<div class="payment-method b-img"></div>
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

</body>

</html>