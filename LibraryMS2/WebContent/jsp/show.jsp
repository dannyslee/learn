<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="learn.woniuxy.web.libraryms.po.Book,java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="/LibraryMS2/InsertShowBookServlet">新增</a>
	<table>
			<thead>
				<tr>
					<th>编号</th>
					<th>书名</th>
					<th>出版社</th>
					<th>价格</th>
					<th>作者</th>
					<th>入库时间</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td></td>
				</tr>
			   <c:forEach items="${books}"  var="book">
					<tr>
						<td>${book.id}</td>
						<td>${book.name}</td>
						<td>${book.output}</td>
						<td>${book.price}</td>
						<td>${book.writer}</td>
						<td>${book.createdate}</td>
						<td>
						    <a href="/LibraryMS2/SearchByBookIdServlet?id=${book.id}">更改</a>
						     <a href="/LibraryMS2/DeleteBookServlet?id=${book.id}">删除</a>
						</td>
					</tr>
				</c:forEach>

			</tbody>
		</table>
</body>
</html>