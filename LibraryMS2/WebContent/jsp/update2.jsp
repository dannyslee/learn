<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="learn.woniuxy.web.libraryms.po.Book,java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    	<form action="/LibraryMS2/UpdateBookServlet" method="post">
    	    <%
    		   Object obj = request.getAttribute("book");
    	       Book book = (Book)obj;
    	       int id = book.getId();
    	       String name = book.getName();
    	       String output = book.getOutput();
    	       double price = book.getPrice();
    	       String writer = book.getWriter();
    	       int wid = book.getWid();
    	    %>
    	     

		    <input type="hidden" name="book" value="update"/>
		    <input type="hidden" name="wid" value="<%=wid%>"/>	    
			<label for="id">编号：</label>
			<input type="text" name="id" id="id" value="<%=id%>" readonly="readonly"  />

			<label for="name">书名：</label>
			<input type="text" name="name" id="name" value="<%=name%>" />

			<label for="output">出版社：</label>
			<input type="text" name="output" id="output" value="<%=output%>" />

			<label for="price">价格：</label>
			<input type="text" name="price" id="price" value="<%=price%>" />

			
			<label for="writer">作者：</label>
			<input type="text" name="writer" id="writer" value="<%=writer%>" />
<!-- 			<select name="wid">
				<option value ="1" >李智闻</option>
				<option value ="2">李世圆</option>
				<option value ="3" >吕东</option>				
			</select>	 -->

			<input type="submit" />
	</form>
</body>
</html>