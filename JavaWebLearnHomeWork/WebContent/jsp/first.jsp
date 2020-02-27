<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>


<%@ include file="includeDemo.jsp" %>
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