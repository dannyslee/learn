 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
         	<form action="/LibraryMS/BookServlet" method="post">

			<label for="name">书名：</label>
			<input type="text" name="name" id="name" />
	
			<label for="output">出版社：</label>
			<input type="text" name="output" id="output" />

			<label for="price">价格：</label>
			<input type="text" name="price" id="price"/>

<!-- 			<label for="writer">作者：</label>
			<input type="text" name="writer" id="writer"/>
			<br/> -->
			<select name="wid">
				<option value ="1">李智闻</option>
				<option value ="2">李世圆</option>
			    <option value ="3">吕东</option>			    
			</select>

			<input type="submit" />
	</form>
</body>
</html>