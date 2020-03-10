<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html class="no-js" lang="zxx">

<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>Shop Full</title>
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
	<script src="./js/vendor/jquery.js" type="text/javascript" charset="utf-8"></script>
	<script src="js/shopone.js" type="text/javascript" charset="utf-8"></script>
</head>

<body>
    <!--[if lt IE 8]>
        <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
    <![endif]-->  
	    <input type="hidden" id="c_id" value="${param.c_id}" />
    <!-- Body main wrapper start -->
    <div class="wrapper">
        <!-- Start of header area -->
        <%@ include file="header.jsp" %>
        <!-- End of header area -->
        <!-- Start Breadcrumbs Area -->
        <div class="breadcrumbs-area breadcrumbs-bg ptb-60">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="breadcrumbs-inner">
                            <h5 class="breadcrumbs-disc m-0">Best Products for you</h5>
                            <h2 class="breadcrumbs-title text-black m-0">FORGE SHOP</h2>
                            <ul class="top-page">
                                <li><a href="index.html">Home</a></li>
                                <li>></li>
                                <li>Shop</li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>  
        <!-- End Breadcrumbs Area -->
		
        <!-- Start page content -->
        <section id="page-content" class="page-wrapper pt-10">
            <!-- Start Product List -->
            <div class="product-list-tab modify-tnm">
                <div class="container">
                    <div class="row rp-style-2">
                        <div class="product-list tab-content">
                            <div role="tabpanel" class="tab-pane fade in active">
                                <div class="product-container-list rp-style-2" >
								  <div class="product-container-list product-container-list-full rp-style-2" id="onecommo">
									  
									  
									  <!-- 开始插入 单个商品 -->
						<!-- 			<div class="cp-style-2 mt-30">
									    <div class="product-inner-list clearfix">   
									        <div class="product-img-list">
									            <a href="#">
									                <div class="product-img b-img">
									                    <img alt="" src="images/product/arrival/1.jpg">
									                </div>
									            </a>
									            <span class="product-tag text-uppercase black-bg">new</span>
									        </div>
									        
									        <div class="product-text product-text-list gray-ash-bg">
									            <h5 class="product-name-list">
									                <a title="Montria jastma" href="#"><strong>Montria jastma</strong></a>
									            </h5>
									            <ul class="pull-left list-inline ratings rating-list pb-20">
									                <li><i class="rated fa fa-star"></i></li>
									                <li><i class="rated fa fa-star"></i></li>
									                <li><i class="rated fa fa-star"></i></li>
									                <li><i class="rated fa fa-star"></i></li>
									                <li><i class="rated fa fa-star"></i></li>
									                <li class="reviews text-theme"><span>10</span>Review(s)</li>
									            </ul>
									            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat pariatur</p>
									            <ul class="pricing pricing-list">
									                <li class="text-right p-price text-center">$180</li>
									                <li class="text-right c-price text-defualt text-center">$150</li>
									            </ul>
									            <div class="clear"></div>
									            <ul class="quick-veiw-list">
									                <li><a href="#"><i class="fa fa-shopping-cart"></i></a></li>
									                <li><a href="#"><i class="fa fa-eye"></i></a></li>
									                <li><a href="#"><i class="fa fa-refresh"></i></a></li>
									                <li><a href="#"><i class="fa fa-heart"></i></a></li>
									            </ul>
									        </div>                                                        
									    </div>
									  </div> -->
									  <!-- 结束插入 单个商品-->
									</div>
								</div>	  
							</div>
                        </div>                        
                    </div>
                </div>
            </div>
            <!-- End Product List -->
            <!-- Start Shop View Area -->
            
            <!-- End Shop View Area -->
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

</body>

</html>