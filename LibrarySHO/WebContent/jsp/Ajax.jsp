<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- 指定js的文件路径 -->
<base href="/LibrarySHO/">
<base href="${pageContext.request.contextPath}">
<title>Insert title here</title>
<!-- ../js/jquery.js or /SpringMVCDemo/js/jquery.js  -->
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript">
   
   function sendAjax(){
	   $.ajax({
		   url:"controller/user/test",
		   type:"POST",
		   data:{
			   name:$("#name").val(),
			   age:$("#age").val(),	   
		   },
	       dataType:"json",
	       success:function(data){
	    	   $("#mes").html(data);
	       }
	   });
	   
	   
   }
</script>
</head>
<body>
  <input  type="text" id="name">
  <input  type="text" id="age">
  <div style="color:red" id="mes"></div>
  <button onclick="sendAjax()">发送请求</button>
</body>
</html>