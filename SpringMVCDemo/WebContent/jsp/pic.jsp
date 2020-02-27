<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
   function changePic(){
	   document.getElementById("pic").src="/SpringMVCDemo/controller/user/getpic?a="+Math.random();
   }
</script>
</head>
<body>
   <img id="pic" src="/SpringMVCDemo/controller/user/getpic" onclick="changePic()">
</body>
</html>