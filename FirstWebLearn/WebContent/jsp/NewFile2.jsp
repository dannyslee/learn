<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.List,learn.woniuxy.web.studentms.po.View_AllStudentsPO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <%@ include file="ShowStudents.jsp" %>	
	<div>
	    <a href = "/FirstWebLearn/class?oper=insertStu">新增</a>
		<table>
			<thead>
				<tr>
					<th>学生编号</th>
					<th>学生姓名</th>
					<th>学生年龄</th>
					<th>学生性别</th>
					<th>学生电话</th>
					<th>课程编号</th>
					<th>课程名</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td></td>
				</tr>
				<%
				Object obj = request.getAttribute("stus");
				if(obj!=null){
					List<View_AllStudentsPO> stus = (List<View_AllStudentsPO>)obj;
					for(View_AllStudentsPO po:stus){
						%>
						<tr>
						<td><%=po.getS_id() %></td>
						<td><%=po.getS_name() %></td>
						<td><%=po.getS_age() %></td>
						<td><%=po.getS_sex() %></td>
						<td><%=po.getS_phone()  %></td>
						<td><%=po.getS_no() %></td>
						<td><%=po.getS_class() %></td>
						<td>
						    <a href="/FirstWebLearn/student?oper=delete&s_id=<%=po.getS_id()%>">删除</a>
						    <a href ="/FirstWebLearn/class?oper=updateStu&s_id=<%=po.getS_id()%>&s_name=<%=po.getS_name()%>&s_age=<%=po.getS_age()%>&s_sex=<%=po.getS_sex()%>&s_phone=<%=po.getS_phone()%>&s_no=<%=po.getS_no()%>&s_class=<%=po.getS_class()%>">更改</a>
						</td>
					</tr>
					<%
	                  }
	             
				}
                  
                %>

			</tbody>
		</table>
	</div>
</body>
</html>