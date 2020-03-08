<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>Login / Register</title>
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
	<script src="js/login.js" type="text/javascript" charset="utf-8"></script>
	
	<script type="text/javascript">
		
	</script>
	
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
                                            <li><a href="my-account.html">My Account</a></li>
                                        </ul>
                                    </li>
                                </ul>
                            </div>
                        </div>
                        <div class="col-sm-3 col-xs-6">
                            <div class="header-top-middle">
                                <ul class="header-top-style">
                                    <li>
                                        <a href="login.html">
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

                        </div> 
                        <div class="col-md-2 col-sm-4 col-xs-12">
                            <div class="header-logo text-center">
                                <a href="index.jsp"><img alt="" src="images/logo.png"></a>
                            </div>
                        </div>
                        <div class="col-md-offset-0 col-md-5 col-sm-offset-0 col-sm-4 col-xs-offset-3 col-xs-6">
                            <div class="shopping-cart">
                            
                                <ul class="shopping-cart-down box-shadow white-bg">
                                    <li class="media">
                                        <a href="#"><img alt="" src="images/cart/1.jpg"></a>
                                        <div class="cart-item-wrapper">
                                            <a href="#">Zelletria ostma</a>
                                            <span class="quantity">
                                                <span class="amount">$195</span>
                                                 x 2
                                            </span>
                                            <a title="Remove this item" class="remove" href="#">
                                                <i class="fa fa-trash-o"></i>
                                            </a>
                                        </div>
                                    </li>
                                    <li class="media">
                                        <a href="#"><img alt="" src="images/cart/2.jpg"></a>
                                        <div class="cart-item-wrapper">
                                            <a href="#">Letria postma</a>
                                            <span class="quantity">
                                                <span class="amount">$145</span>
                                                 x 1
                                            </span>
                                            <a title="Remove this item" class="remove" href="#">
                                                <i class="fa fa-trash-o"></i>
                                            </a>
                                        </div>
                                    </li>
                                    <li class="media">
                                        <a href="#"><img alt="" src="images/cart/3.jpg"></a>
                                        <div class="cart-item-wrapper">
                                            <a href="#">Montria jastma</a>
                                            <span class="quantity">
                                                <span class="amount">$155</span>
                                                 x 2
                                            </span>
                                            <a title="Remove this item" class="remove" href="#">
                                                <i class="fa fa-trash-o"></i>
                                            </a>
                                        </div>
                                    </li>
                                    <li class="media">
                                        <span class="total-title pull-left">Sub Total</span>
                                        <span class="total pull-right">$845</span>
                                    </li>
                                    <li class="media">
                                        <a class="cart-btn" href="#">VIEW CART</a>
                                        <a class="cart-btn" href="#">CHECKOUT</a>
                                    </li>
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
        <!-- Start Breadcrumbs Area -->
        <div class="breadcrumbs-area breadcrumbs-bg ptb-60">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="breadcrumbs-inner">
                            <h5 class="breadcrumbs-disc m-0">Best Products for you</h5>
                            <h2 class="breadcrumbs-title text-black m-0">Login / Register </h2>
                            <ul class="top-page">
                                <li><a href="index.html">Home</a></li>
                                <li>></li>
                                <li>Login / Register</li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>  
        <!-- End Breadcrumbs Area -->
        <!-- Start page content -->
        <section id="page-content" class="page-wrapper pt-10">
            <!-- Start Register Area -->
            <div class="register-area pt-90">
                <div class="container">
                    <div class="row">
                        <div class="col-md-6">
                            <div class="registered-customers">
                                <h4 class="text-uppercase mb-20"><strong>IF 已注册用户：</strong></h4>
                                <form action="#">
                                    <div class="login-account p-30 box-shadow">
                                        <p>欢迎你的再次光临，请在这里登录：</p>
                                        <input type="text" placeholder="邮件地址" id="user">
                                        <input type="password" placeholder="密码"id="pass">
										<input type="img" placeholder="验证码"  id="logPic" >
										
										<!-- 验证码 -->
										<img id="imgPic" src="http://localhost:8080/SpringMVCDemo/controller/user/getpic" onclick="changeLogPic()">
                                        <p><small><a href="#">忘记密码?</a></small></p>
                                        <button type="submit" class="cart-button text-uppercase" onclick="sendLoginMes()">登录</button>
                                    </div>
                                </form>                                
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="registered-customers new-customers">
                                <div class="section-title text-uppercase mb-40">
                                    <h4><strong>IF 新用户：</strong></h4>
                                </div>
							  <form>
                                    <div class="login-account p-30 box-shadow">
                                        <div class="row">
                                           <!-- <div class="col-sm-6">
                                                <input type="text" placeholder="First Name">
                                            </div>
                                            <div class="col-sm-6">
                                                <input type="text" placeholder="last Name">
                                            </div>
                                            <div class="col-sm-6">
                                                <select class="custom-select">
                                                    <option value="defalt">country</option>
                                                    <option value="c-1">Australia</option>
                                                    <option value="c-2">Bangladesh</option>
                                                    <option value="c-3">Unitd States</option>
                                                    <option value="c-4">Unitd Kingdom</option>
                                                </select>
                                            </div>
                                            <div class="col-sm-6">
                                                <select class="custom-select">
                                                    <option value="defalt">State</option>
                                                    <option value="c-1">Melbourne</option>
                                                    <option value="c-2">Dhaka</option>
                                                    <option value="c-3">New York</option>
                                                    <option value="c-4">London</option>
                                                </select>
                                            </div>
                                            <div class="col-sm-6">
                                                <select class="custom-select">
                                                    <option value="defalt">Town/City</option>
                                                    <option value="c-1">Victoria</option>
                                                    <option value="c-2">Chittagong</option>
                                                    <option value="c-3">Boston</option>
                                                    <option value="c-4">Cambridge</option>
                                                </select>
                                            </div>
                                            <div class="col-sm-6">
                                                <input type="text" placeholder="Detailed Address...">
                                            </div>
                                        </div>
                                        <input type="text" placeholder="Phone here..."> -->
                                        <input type="text" placeholder="邮件地址" id="ruser">
                                        <input type="password" placeholder="密码"  id="rpass">
                                        <input type="password" placeholder="确认密码" id="rcpass" onchange="checkPass()">
                                        <div class="checkbox">
                                            <label class="mr-10"> 
                                                <small>
                                                    <input type="checkbox" name="signup">欢迎您的到来
                                                </small>
                                            </label>
											<br />
                                            <label> 
                                                <small>
                                                    <input type="checkbox" name="signup" ><strong>注册后将有一封确认邮件发送至您的邮箱，请注意查收！<strong>
                                                </small>
                                            </label>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <button value="register" type="submit" class="cart-button text-uppercase mt-20" onclick="sendRegiterMes()">注册</button>
                                            </div>
                                        <!--<div class="col-md-6">
                                                <button type="reset" class="cart-button text-uppercase mt-20">Clear</button>
                                            </div> -->
											
                                        </div>
                                    </div>
                                </form>                                
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- End of Register Area -->
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
                           <!-- <div class="brand-carousel">
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
<!--        <footer id="footer" class="footer-area">
            <div class="footer-top-area text-center ptb-40">
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