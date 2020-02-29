<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../../js/jquery.js"></script>
<script type="text/javascript">
	//获取验证码信息
	function changeLogPic(){
		src = '/SpringMVCDemo/controller/test/getpic?a='+Math.random();
		$("#imgPic").prop("src",src);
	}
	
    //获取登录信息
	function sendLoginMes(){
		$.ajax({
			url:"../../controller/user/login",
			type:"POST",
			data:{
				req:"req",
				resp:"resp",
				user:$("#user").val(),
				password:$("#pass").val(),
				loginCode:$("#logPic").val()
			},
			dateType:"json",
			success:function(data){
				alert(data);				
			}
		})
	}	
</script>
</head>
<body>
	<div id="login">
		账号：<input type="text" name="user" id="user"/>
		密码：<input type="password" name="password" id="pass"/>
		验证码：<input type="text" name="logPic" id="logPic"/>
		<img id="imgPic" src="/SpringMVCDemo/controller/test/getpic" onclick="changeLogPic()">
		<button onclick="sendLoginMes()">发送请求</button>		
	</div>
</body>
</html>


