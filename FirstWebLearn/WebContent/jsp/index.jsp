<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<!-- <form action="/FirstWebLearn/login" method="post"> -->
		<form action="/FirstWebLearn/login" method="post">
			<input type="text" id="account" name="account" /> <input
				type="password" id="password" name="password" /> <input
				type="submit" value="submint" />
		</form>
	</div>
	<%@ include file="NewFile.jsp" %>	
</body>
</html>