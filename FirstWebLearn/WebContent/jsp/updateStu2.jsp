<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
			<input type="text" name="s_id" id="s_id" value="<%=request.getParameter("s_id")%>" readonly="readonly"  />
			<br/>
			<label for="sname">姓名：</label>
			<input type="text" name="s_name" id="s_name" value="<%=request.getParameter("s_name") %>" />
			<br/>
			<label for="sex">性别：</label>
			<input type="text" name="s_sex" id="s_sex" value="<%=request.getParameter("s_sex") %>" />
			<br/>
			<label for="age">年龄：</label>
			<input type="text" name="s_age" id="s_age" value="<%=request.getParameter("s_age") %>" />
			<br/>
			<label for="tel">电话：</label>
			<input type="text" name="s_phone" id="s_phone" value="<%=request.getParameter("s_phone") %>"/>
			<br/>
			<label for="cid">班级：</label>
			 <%
				String s_class = request.getParameter("s_class");
				String v1 ="";
				String v2 ="";
				switch(s_class){
					case "Java":
						v1="selected";
						break;
					case "C++":
						v2="selected";
						break;
					default:
						break;
				}
					
			 %>
			<select name="s_no">
				<option value ="1" <%=v1 %>>Java</option>
				<option value ="2" <%=v2 %>>C++</option>
			
			</select>
			<br/>
			<input type="submit" />
	</form>
</body>
</html>