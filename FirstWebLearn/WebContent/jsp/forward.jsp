<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="demo" scope="request" class="com.woniuxy.web.jsp.Demo"></jsp:useBean>
  
 <!-- 5.为作用域中对象属性赋值 -->
<jsp:setProperty property="name" name="demo" value="张三"/>
<!-- 6.为作用域中对象属性赋值 -->
<jsp:getProperty property="name" name="demo"/>
<!-- <input name="demo">
 --></body>
</html>