<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
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
	<script src="js/vendor/jquery.js" type="text/javascript" charset="utf-8"></script>
	<script src="js/shop.js" type="text/javascript" charset="utf-8"></script>
</head>

<body>
    <!--[if lt IE 8]>
        <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
    <![endif]-->  
    <input type="hidden" id="t_id" value="${param.t_id}" />
    
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
                                <li><a href="index.jsp">Home</a></li>
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
            <!-- Banner Area Start -->
            <div class="banner-two-area">
                <div class="banner-two-bottom">

                </div>
            </div>
            <!-- Banner Area End -->
            <!-- Start Shop View Area -->
            <div class="shop-view-area pt-90">
                <div class="container">
                    <div class="row">
                        <div class="col-md-4 col-sm-2 col-xs-4">
                            <div class="shop-tab-pill">
                                <ul>
                                    <li class="active"><a data-toggle="pill" href="#home"><i class="fa fa-th" aria-hidden="true"></i></a></li>
                                    <li><a data-toggle="pill" href="#menu1"><i class="fa fa-list" aria-hidden="true"></i></a></li>
                                </ul>
                            </div>                            
                        </div>
                        <div class="col-md-4 col-sm-6 hidden-xs">
                            <div class="shop-tab-pill">

                                <div class="show-label showing">
									
									<!-- 此处改为复选框 -->
									
                                   <!--  <label>Showing : </label>
                                    <select>
                                        <option selected="selected" value="position">9</option>
                                        <option>1</option>
                                        <option>2</option>
                                        <option>3</option>
                                        <option>4</option>
                                        <option>5</option>
                                        <option>6</option>
                                        <option>7</option>
                                        <option>8</option>
                                        <option>9</option>
                                    </select> -->
                                </div>
                            </div>                          
                        </div>
                        <div class="col-sm-4 col-xs-8">
                            <div class="shop-pagination">
                                <!-- <label>page : </label>
                                <ul>
                                    <li><a href="javascript:lastPage()"><i class="fa fa-angle-left" aria-hidden="true"></i></a></li>     
                                    <li><a href="#" id="pageNow"></a></li>
                                    <li><a href="#">/</a></li>
                                    <li><a href="#" id="pageN"></a></li>
                                    <li><a href="javascript:nextPage()"><i class="fa fa-angle-right" aria-hidden="true"></i></a></li>
                                </ul> -->
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- End Shop View Area -->
            <!-- Start Product List -->
            <div class="product-list-tab modify-tnm">
                <div class="container">
                    <div class="row rp-style-2">
                        <div class="product-list tab-content">
                            <div role="tabpanel" class="tab-pane fade in active" id="home">
                                <div class="product-container-list rp-style-2" id="simplecommo">
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
            <!-- End Product List -->
            <!-- Start Shop View Area -->
            <div class="shop-view-area pt-30">
                <div class="container">
                    <div class="row">
                        <div class="col-md-4 col-sm-2 col-xs-4">
                            <div class="shop-tab-pill">
                                <ul>
                                    <li class="active"><a data-toggle="pill" href="#home"><i class="fa fa-th" aria-hidden="true"></i></a></li>
                                    <li><a data-toggle="pill" href="#menu1"><i class="fa fa-list" aria-hidden="true"></i></a></li>
                                </ul>
                            </div>                            
                        </div>
                        <div class="col-md-4 col-sm-6 hidden-xs">
                            <div class="shop-tab-pill">
                                <div class="show-label">
<!--                                    <label>Sort by : </label>
                                    <select>
                                        <option selected="selected" value="position">Position</option>
                                        <option value="Name">Name</option>
                                        <option value="Price">Price</option>
                                    </select> -->
                                </div>
                                <div class="show-label showing">
<!--                                     <label>Showing : </label>
                                    <select>
                                        <option selected="selected" value="position">9</option>
                                        <option>1</option>
                                        <option>2</option>
                                        <option>3</option>
                                        <option>4</option>
                                        <option>5</option>
                                        <option>6</option>
                                        <option>7</option>
                                        <option>8</option>
                                        <option>9</option>
                                    </select> -->
                                </div>
                            </div>                          
                        </div>
                        <div class="col-sm-4 col-xs-8">
                            <div class="shop-pagination">
                                <label>page : </label>
                                <ul>
                                   <li><a href="javascript:lastPage()"><i class="fa fa-angle-left" aria-hidden="true"></i></a></li>     
                                    <li><a href="#" id="pageNow"></a></li>
                                    <li><a href="#">/</a></li>
                                    <li><a href="#" id="pageN"></a></li>
                                    <li><a href="javascript:nextPage()"><i class="fa fa-angle-right" aria-hidden="true"></i></a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
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
<!--                            <div class="brand-carousel">
                                <div class="col-md-12">
                                    <div class="single-brand text-center">
                                        <a href="#">
                                            <img src="images/brand/1.png" alt="">
                                        </a>
                                    </div>
                                </div>
                                <div class="col-md-12">
                                    <div class="single-brand text-center">
                                        <a href="#">
                                            <img src="images/brand/2.png" alt="">
                                        </a>
                                    </div>
                                </div>
                                <div class="col-md-12">
                                    <div class="single-brand text-center">
                                        <a href="#">
                                            <img src="images/brand/3.png" alt="">
                                        </a>
                                    </div>
                                </div>
                                <div class="col-md-12">
                                    <div class="single-brand text-center">
                                        <a href="#">
                                            <img src="images/brand/4.png" alt="">
                                        </a>
                                    </div>
                                </div>
                                <div class="col-md-12">
                                    <div class="single-brand text-center">
                                        <a href="#">
                                            <img src="images/brand/5.png" alt="">
                                        </a>
                                    </div>
                                </div>
                                <div class="col-md-12">
                                    <div class="single-brand text-center">
                                        <a href="#">
                                            <img src="images/brand/1.png" alt="">
                                        </a>
                                    </div>
                                </div>
                                <div class="col-md-12">
                                    <div class="single-brand text-center">
                                        <a href="#">
                                            <img src="images/brand/2.png" alt="">
                                        </a>
                                    </div>
                                </div>
                                <div class="col-md-12">
                                    <div class="single-brand text-center">
                                        <a href="#">
                                            <img src="images/brand/3.png" alt="">
                                        </a>
                                    </div>
                                </div> -->
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
<!--            <div class="footer-top-area text-center ptb-40">
                <div class="container">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="footer-top-content">
                                <a href="index.html">
                                    <img src="images/footer/logo.png" alt="">
                                </a>
                                <p class="pb-30">Forge is the best ecommerce site lorem ipsum dolor sit amet, consectetur aiscing elit, sed do eiusmod tempor incididunt ut labore et dolore</p>
                                <ul class="social-icon">
                                    <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                                    <li><a href="#"><i class="fa fa-twitter"></i></a></li>
                                    <li><a href="#"><i class="fa fa-linkedin"></i></a></li>
                                    <li><a href="#"><i class="fa fa-google-plus"></i></a></li>
                                    <li><a href="#"><i class="fa fa-instagram"></i></a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div> -->
<!--            <div class="footer-middle-area footer-bg">
                <div class="container">
                    <div class="row">
                        <div class="col-md-3 col-sm-6">
                            <div class="single-footer-inner">
                                <h5 class="footer-title text-white">CONTACT</h5>
                                <ul class="footer-contact">
                                    <li class="contact-icon">
                                        <img alt="" src="images/footer/icon/1.png">
                                    </li>
                                    <li class="footer-text text-ash">
                                        <p>8901 Marmora Raod,</p>
                                        <p>Glasgow, D04  89GR</p>
                                    </li>
                                </ul>
                                <ul class="footer-contact">
                                    <li class="contact-icon">
                                        <img alt="" src="images/footer/icon/2.png">
                                    </li>
                                    <li class="footer-text text-ash">
                                        <p>Telephone : (801) 4256  9856</p>
                                        <p>Telephone : (801) 4256  9658</p>
                                    </li>
                                </ul>
                                <ul class="footer-contact">
                                    <li class="contact-icon">
                                        <img alt="" src="images/footer/icon/3.png">
                                    </li>
                                    <li class="footer-text text-ash">
                                        <p>Email : info@forge.com</p>
                                        <p>Web : www.forge.com</p>
                                    </li>
                                </ul>
                            </div>
                        </div>
                        <div class="col-md-2 col-sm-6">
                            <div class="single-footer-inner">
                                <h5 class="footer-title text-white">CONTACT</h5>
                                <ul class="footer-menu">
                                    <li><a href="index.html">Home</a></li>
                                    <li><a href="about.html">About us</a></li>
                                    <li><a href="contact.html">Contact us</a></li>
                                    <li><a href="#">Our blog</a></li>
                                    <li><a href="#">Support centre</a></li>
                                    <li><a href="#">Privacy policy</a></li>
                                </ul>
                            </div>
                        </div>
                        <div class="col-md-2 col-sm-3">
                            <div class="single-footer-inner">
                                <h5 class="footer-title text-white">SUPPORT</h5>
                                <ul class="footer-menu">
                                    <li><a href="#">Delivery information</a></li>
                                    <li><a href="3">Order tracking</a></li>
                                    <li><a href="#">Return product</a></li>
                                    <li><a href="#">Gift card</a></li>
                                    <li><a href="#">Home delivery</a></li>
                                    <li><a href="#">Online support</a></li>
                                </ul>
                            </div>
                        </div>
                        <div class="col-md-5 col-sm-9">
                            <h2 class="footer-title">LATEST TWEETS</h2>
                            <div class="tweet-list">
                                <ul class="left-tweet">
                                    <li class="tweet-inner clearfix">
                                        <div class="tweet-img">
                                            <a href="#">
                                                <img alt="" src="images/footer/tweet/1.jpg">
                                            </a>
                                        </div>
                                        <div class="tweet-text">
                                            <a href="#">Forge is the best ecommerce elt</a>
                                            <p>Jan 25, 2017</p>
                                        </div>
                                    </li>
                                    <li class="tweet-inner clearfix">
                                        <div class="tweet-img">
                                            <a href="#">
                                                <img alt="" src="images/footer/tweet/2.jpg">
                                            </a>
                                        </div>
                                        <div class="tweet-text">
                                            <a href="#">Forge is the best ecommerce elt</a>
                                            <p>Jan 25, 2017</p>
                                        </div>
                                    </li>
                                </ul>
                                <ul class="left-tweet">
                                    <li class="tweet-inner clearfix">
                                        <div class="tweet-img">
                                            <a href="#">
                                                <img alt="" src="images/footer/tweet/1.jpg">
                                            </a>
                                        </div>
                                        <div class="tweet-text">
                                            <a href="#">Forge is the best ecommerce elt</a>
                                            <p>Jan 25, 2017</p>
                                        </div>
                                    </li>
                                    <li class="tweet-inner clearfix">
                                        <div class="tweet-img">
                                            <a href="#">
                                                <img alt="" src="images/footer/tweet/2.jpg">
                                            </a>
                                        </div>
                                        <div class="tweet-text">
                                            <a href="#">Forge is the best ecommerce elt</a>
                                            <p>Jan 25, 2017</p>
                                        </div>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div> -->
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
