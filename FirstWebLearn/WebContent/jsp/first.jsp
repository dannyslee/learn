<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List,learn.woniuxy.web.studentms.po.View_AllStudentsPO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<!-- JSP:七大动作 -->
<!-- 1.静态包含 
复制被包含页面中的body标签内内容，放入当前页面，使用同一个servlet
-->
<%@ include file="includeDemo.jsp" %>
<!-- 2.动态包含 
虽然显示，但是相互独立，放入不同的servlet
-->
<jsp:include page="NewFile.jsp"></jsp:include>
<!-- 3.请求转发 -->
<jsp:forward page="NewFile.jsp">
        <!-- 传参 -->
        <jsp:param value="admin" name="account"/>
        <!--  取参 -->
        <%=request.getParameter("account") %>
        <%-- <jsp:params></jsp:params> --%>
</jsp:forward>
<!-- 4.创建java对象 -->
<jsp:useBean id="demo" scope="session" class="com.woniuxy.web.jsp.first_jsp"></jsp:useBean>
<!-- 5.为作用域中对象属性赋值 -->
<jsp:setProperty property="name" name="demo" value="张三"/>
<!-- 6.为作用域中对象属性赋值 -->
<jsp:getProperty property="name" name="demo"/>
<%-- <%= request.getAttribute("name").getName() getName()元素封装（失血模型）后的get方法 %> --%>
<%-- 7. <jsp:plugin code="" codebase="" type="bean"></jsp:plugin> ：老方法，用于指定插件 --%>
<%-- 隐藏注释 --%>
<!-- 小脚本 -->
<%
   int u=1;
   int o=todo();
%>
<!-- 声明 -->
<%!
   int todo(){
	int i;
	int j;
	int s=0;
	for(i=2;i<=100;i++){
		for(j=2;j<i;j++){
			if(i%j==0){
				break;
			}
		}
		if(j>=i){
			s+=i;
		}
	 }  
	 return s;
	}
%>
<!-- 表达式 -->
a:<%=todo()%>
o:<%=o %>
</body>
</html>