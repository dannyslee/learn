<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="../../js/jquery.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">
	

	function checkPass() {
		var a = $("#rpass").val();
		var b = $("#rcpass").val();
		if (a!=b) {
			$("#mes").html("两次密码不同")
		}
	}

	function sendRegiterMes() {
		$.ajax({
			url : "../../controller/user/register",
			type : "POST",
			data : {
				req : "req",
				resp : "resp",
				user : $("#ruser").val(),
				password : $("#rpass").val()
			},
			dataType : "json",
			success : function(data) {
				alert(data)
			}
		})
	}
</script>
</head>
<body>
<div id="register">
	账号：<input type="text" name="ruser" id="ruser"/>
	密码: <input type="password" name="rpass" id="rpass"/>
	确认密码: <input type="password" name="rcpass" id="rcpass" onchange="checkPass()"/>
	<div style="color:red" id="mes"></div>
	<button onclick="sendRegiterMes()" >确认提交</button>
</div>
</body>
</html>