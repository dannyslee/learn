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
			
		    <input type="hidden" name="oper" value="insert"/>
			<br/>
			<label for="sname">姓名：</label>
			<input type="text" name="s_name" id="s_name"/>
			<br/>
			<label for="sex">性别：</label>
			<input type="radio" name="s_sex" id="s_sex" value="男" checked="checked"/>男
			<input type="radio" name="s_sex" id="s_sex" value="女"/>女	
			<br/>
			<label for="age">年龄：</label>
			<input type="text" name="s_age" id="s_age"/>
			<br/>
			<label for="tel">电话：</label>
			<input type="text" name="s_phone" id="s_phone"/>
			<br/>
			<label for="cid">班级：</label>
			<select name="s_no">
				<option value ="1">Java</option>
				<option value ="2">C++</option>
			</select>
			<br/>
			<input type="submit" />
	</form>
</body>
</html>