<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
<!-- 		<script type="text/javascript" src="../../js/jquery.js"></script>
		<script type="text/javascript">
			function creatMail(){
				$.ajax({
					url:"../../controller/order/creorder",
					type:"POST",
					data:{
						m_name:$("#name").val(),
						m_tel:$("#name").val(),
						m_address:$("#address").val()
					},
					dataType:"json",
					success:function(data){
						//
					}
				})
			}
		</script> -->
	</head>
	<body>
		<div id="mail">
			收件人：<input type="text" id="name" value="" />
			收货电话：<input type="text" id="tel" value="" />
			收货地址：<input type="text" id="address" value="" />
			<!-- <button type="button" id="creatMail()" onclick="creatMail()">提交地址</button> -->
		</div>
	</body>
</html>
