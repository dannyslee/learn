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
	
</body>
</html>