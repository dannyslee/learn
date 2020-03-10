<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html class="no-js" lang="zxx">

	<head>
		<meta charset="utf-8">
		<meta http-equiv="x-ua-compatible" content="ie=edge">
		<title>Abot</title>
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
		<script src="js/cartorder.js" type="text/javascript" charset="utf-8"></script>
		<script>
			$(function () { $(".popover-options a").popover({html : true });});
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
			<!-- Start Breadcrumbs Area -->
<!-- 			<div class="breadcrumbs-area breadcrumbs-bg ptb-60">
				<div class="container">
					<div class="row">
						<div class="col-lg-12">
							<div class="breadcrumbs-inner">
								<h5 class="breadcrumbs-disc m-0">Best Products for you</h5>
								<h2 class="breadcrumbs-title text-black m-0">ABOUT FORGE </h2>
								<ul class="top-page">
									<li><a href="index.html">Home</a></li>
									<li>></li>
									<li>About</li>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div> -->
			<!-- End Breadcrumbs Area -->
			<!-- Start page content -->
			<section id="page-content" class="page-wrapper pt-10">

				<!-- Start Featured product Area -->
				<div class="featured-product-area section-padding">
					<div class="container">
						<div class="row rp-style">
							<div class="col-md-12">
								<div class="section-title text-center mb-35">
									<h2 class="text-uppercase"><strong>您放入购物车的商品共计：</strong><h1 id="subTotal"></h1></h2>
									<p class="text-defualt">感谢您的喜欢</p>
									<img alt="" src="images/section-border.png">
								</div>
							</div>
						</div>
						
						<div class="product-list-tab modify-tnm">
						    <div class="container">
						        <div class="row rp-style-2">
						            <div class="product-list tab-content">
						                <div role="tabpanel" class="tab-pane fade in active" id="home">
						                    <div class="product-container-list rp-style-2" id="carts">
												<!-- 商品简单展示 从这里开始 -->
						
												<!-- 商品简单展示 从这里结束 -->
						                     
						                    <div role="tabpanel" class="tab-pane fade modify2" id="menu1">
						                        <div class="product-container-list product-container-list-full rp-style-2" id="commo">></div>
						                     </div>  
												
						                    </div>
						                </div>
						            </div>                        
						        </div>
						    </div>
						</div>
						
						
						
						<div class="row rp-style">
							<div class="featured-carousel indicator-style" >
							</div>
						</div>
					</div>
				</div>
				<!-- Start About Middle Area -->
				<div class="about-middle-area">
					<div class="container">
						<div class="row">
							<div class="col-sm-6">
								<div class="section-title text-center mb-35">
									<h2 class="text-uppercase"><strong>本次购物的保障</strong></h2>
									<p class="text-defualt">我们一定严格遵守</p>
									<img alt="" src="images/section-border.png">
								</div>
								<div class="about-middle-inner">
									<h4 class="text-uppercase mb-20"><strong>我们承诺：</strong></h4>
									<div class="about-middle-content">
<!-- 										<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusm jedo tempor incididunt ut labore et
											dolore magna aliqua. Ut enim ad inim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquiLorem
										</p> -->
										<ul class="mission-list">
											<li>
												<img alt="" src="images/about/check.png">
												<p>14天无理由退货，并承担来回运费 </p>
											</li>
											<li>
												<img alt="" src="images/about/check.png">
												<p>如果发现质量问题，直接双倍金额赔付 </p>
											</li>
										</ul>
										<ul class="mission-list">
											<li>
												<img alt="" src="images/about/check.png">
												<p>承诺全国两日必达(非不可抗力除外) </p>
											</li>
											<li>
												<img alt="" src="images/about/check.png">
												<p>欢迎防伪查询，非正品十倍赔付 </p>
											</li>
										</ul>
									</div>

								</div>
							</div>
							
							<!-- <div class="login-account p-30 box-shadow"> -->
								<div class="row">
									<div class="col-sm-3 login-account">
										<input type="text" placeholder="姓名" id="name">
									</div>
									
									<div class="col-sm-3">
										<input type="text" placeholder="电话" id="tel">
									</div>
									<div class="col-sm-6">
										<select class="custom-select" id="province">
											<option value="defalt">省</option>
											<option value="四川省">四川省</option>
											<option value="台湾省">台湾省</option>
											<option value="华盛顿州省">华盛顿州省</option>
											<option value="广东省">广东省</option>
										</select>
									</div>
									<div class="col-sm-6">
										<select class="custom-select" id="city">
											<option value="defalt">市</option>
											<option value="成都市">成都市</option>
											<option value="台北市">台北市</option>
											<option value="c-3">New York</option>
											<option value="c-4">London</option>
										</select>
									</div>
									<div class="col-sm-6">
										<select class="custom-select" id="county">
											<option value="defalt">县</option>
											<option value="天府三区">天府三区</option>
											<option value="莲花县">莲花县</option>
											<option value="c-3">Boston</option>
											<option value="c-4">Cambridge</option>
										</select>
									</div>
									<div class="col-sm-6">
										<input type="text" placeholder="详细位置..." id="detailedAddresss">
									</div>
									<div class="col-sm-6">
										<br/>
										<div class="signature col-sm-9">
											<img alt="" src="images/about/signature.png">
											<h6><a href="#">CEO签名承诺：</a></h6>
											<a href="#">ZHIWEN Li</a>
										</div>
										<div class="col-sm-2">
											<button class="btn-default" type="button" onclick="pushOrder()">提交订单</button>
										</div>
										
									</div>
								</div>
								
								
							</div>

							</div>
						</div>
					</div>
				</div>
	
				<!-- End Why Choose Us Area -->
				<!-- Start Brand Area -->
				<div class="brand-area section-padding">
					<div class="container">
						<div class="row">
							<div class="col-md-12">
								<div class="section-title text-center mb-35">
									<h2 class="text-uppercase"><strong>OUR BRAND</strong></h2>
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