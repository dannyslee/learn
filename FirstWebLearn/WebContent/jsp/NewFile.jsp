<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.List,learn.woniuxy.web.studentms.po.View_AllStudentsPO"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
	
			      <c:forEach items="${stus}" var="View_AllStudentsPO">
						<tr>
						<td>${View_AllStudentsPO.s_id}</td>
						<td>${View_AllStudentsPO.s_name}</td>
						<td>${View_AllStudentsPO.s_age}</td>
						<td>${View_AllStudentsPO.s_sex}</td>
						<td>${View_AllStudentsPO.s_phone}</td>
						<td>${View_AllStudentsPO.s_no}</td>
						<td>${View_AllStudentsPO.s_class}</td>
						<td>
						    <a href="/FirstWebLearn/student?oper=delete&s_id=${View_AllStudentsPO.s_id}">删除</a>
						    <a href ="/FirstWebLearn/class?oper=updateStu&s_id=${View_AllStudentsPO.s_id}&s_name=${View_AllStudentsPO.s_name}&s_age=${View_AllStudentsPO.s_age}&s_sex=${View_AllStudentsPO.s_sex}&s_phone=${View_AllStudentsPO.s_phone}&s_no=${View_AllStudentsPO.s_no}&s_class=${View_AllStudentsPO.s_class}">更改</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>