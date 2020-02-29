<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../js/jquery.js"></script>
<script type="text/javascript">
	// 登录验证码检测
	function changeLoginPic(){
		//设置属性与值
		$("#loginPicImg").prop("src","controller/picture/loginPic?a="+Math.random());
	}
	
	//登录检测
	$.ajax({
		url:"controller/user/login",
		type:"POST",
		data:{
			account:$("#laccount").val(),
			pass:$("#lpass").val(),
			code:$("#lpic").val()
		},
		dataType:"json",
		success:function(data){
			if(data.indexOf("成功")！=-1){
				location.reload();
			}else{
				#("#lmes").html(data)//这个data是得到的返回值
			}
		}
	})
	
	//账号，密码正则检测
	function checkAccount(){
		var reg = new RegExp("^1[3456789]\\d{9}$");
		if(reg.test($("#laccount").val())){
			$("#lmes").html("");
		}else{
			$("#lmes").html("账号不合法！必须为11位手机号!");
		}
	}
	
</script>
</head>
<body>
	<div id="header">
		<div id="logo"><a href="index.html">LibrarySHOP</a></div>
		<div id="username">
			<!-- 如果没有登录，使用该页面 -->
			<% %>
			<div id="n-inout">
				<a href="javaScript:void(0)" onclick="showLoginBox()" class="icon i-user">登录</a>
				<a href="javaScript:void(0)" onclick="showRegisterBox()" class="icon i_register">注册</a>
			</div>
			<% %>
			<!-- 如果已登录，使用该页面 -->
			<div id="y-input">
				<a href="allorder.html" class="icon i-order">订单</a>
				<a href="shopcar.html" class="icon i-shopcar">购物车</a>
				<a href="" class="icon i-loginout">${sessionSope.user.u_user}</a>
				<a href="" class="icon i-loginout">注销</a>
			</div>
			<% %>
		</div>
	</div>
</body>
</html>