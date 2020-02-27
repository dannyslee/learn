<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/FirstWebLearn/student" method="post">
			
			<br/>
		    <input type="hidden" name="oper" value="update"/>
			<label for="sid">编号：</label>
			<input type="text" name="s_id" id="s_id" value="${param.s_id}" readonly="readonly"  />
			<br/>
			<label for="sname">姓名：</label>
			<input type="text" name="s_name" id="s_name" value="${param.s_name}" />
			<br/>
			<label for="sex">性别：</label>
			<input type="text" name="s_sex" id="s_sex" value="${param.s_sex}" />
			<br/>
			<label for="age">年龄：</label>
			<input type="text" name="s_age" id="s_age" value="${param.s_age}" />
			<br/>
			<label for="tel">电话：</label>
			<input type="text" name="s_phone" id="s_phone" value="${param.s_phone}"/>
			<br/>
			<label for="cid">班级：</label>
			<select name="s_no">			
			<c:choose>
			  <c:when test="${param.s_no ==1}">	
			   <option value ="1" selected >Java</option>
				<option value ="2" >C++</option>			
			  </c:when>
			  <c:when  test="${param.s_no ==2}">
			     <option value ="1" >Java</option>
				 <option value ="2" selected>C++</option>		
			  </c:when>
				<c:otherwise> 
				<option value ="1" >Java</option>
				<option value ="2" >C++</option>	
               </c:otherwise>
			</c:choose>	
			</select>
			<br/>
			<input type="submit" />
	</form>
</body>
</html>