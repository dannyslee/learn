<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="learn.woniuxy.web.libraryms.po.BookPO,java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <a href = "/LibraryMS/BookToUpdate?book=insert">新增</a>  
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
				<%
				Object obj = request.getAttribute("books");
				if(obj!=null){
					List<BookPO> stus = (List<BookPO>)obj;
					for(BookPO po:stus){
						%>
						<tr>
						<td><%=po.getId() %></td>
						<td><%=po.getName() %></td>
						<td><%=po.getOutput() %></td>
						<td><%=po.getPrice() %></td>
						<td><%=po.getWriter() %></td>
						<td><%=po.getCreatedate() %></td>
						<td>
						    <a href="/LibraryMS/BookToUpdate?book=update&id=<%=po.getId()%>">更改</a>
						     <a href="/LibraryMS/BookToUpdate?book=delete&id=<%=po.getId()%>">删除</a>
						</td>
					</tr>
					<%
	                  }
	             
				}
                  
                %>

			</tbody>
		</table>
</body>
</html>