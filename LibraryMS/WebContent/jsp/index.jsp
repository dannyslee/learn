<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="learn.woniuxy.web.libraryms.po.BookPO,java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="../js/jquery.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">
	$(function(){
			var p1 = $("#book").val();
			if(p1!="show"){
				$("#book").val("show")
			}
		})
	}) 
	
</script>
</head>
<body>
	<div>
	    <input type="hidden" name="book" id="book" value="show">
		<%@ include file="show.jsp" %>	
	</div>
</body>
</html>