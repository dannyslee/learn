<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="learn.woniuxy.web.studentms.po.ClassPO,java.util.List,java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
     <!-- set:賦值 -->
     <!-- 為作用域中屬性賦值 -->
     <c:set var="sname" value="admin" scope="session"></c:set>
     ${sessionScope.sname}
     
   <%--   <%session.setAttribute("ClassPO", new ClassPO());%>
     <c:set value="張三" target="${sessionScope.ClassPO}" scope="session"></c:set>
     ${sessionScope.ClassPO.c_class} --%>
     
     <!-- out -->
     <c:out value="${sessionScope.sname}" default="變量不存在"></c:out>
     
     <!--remove  -->
     <c:remove var="name" scope="session"/>
     <c:out value="${sessionScope.sname}" default="變量不存在"></c:out>

     <c:set var="account" value="17822222222" scope="session"></c:set>
     
     
     <!-- if -->
     <c:if test="${empty sessionScope.account}" scope="request" var="re">
     <a href="#">登錄</a>
     <a href="#">注冊</a>
     </c:if>
     ${requestScope.re}
     <c:if test="${!empty sessionScope.account}">
        ${sessionScope.account}
     </c:if>
     
     <br/>
     <%
     List li = new ArrayList();
     
     for(int i=0;i<10;i++){
    	 li.add(i);
     }
     request.setAttribute("li", li);
     %>
     <c:forEach items="${requestScope.li}" var="num" begin="2" end="8" varStatus="state">
                        循環項：：${num }:${state.current } <br/>                
                         索引：${state.index} <br/>
                         當前循環次數：${state.count} <br/>
                         是否為第一次循環：${state.first} <br/>
                         是否為最後一次循環：${state.last}   <br/>        
     </c:forEach>
     
     
       <%
       session.setAttribute("name", "小王");
       session.setAttribute("demo", new ClassPO(1,"二班"));
      %>
      <%=session.getAttribute("name")%>
      <%
        Object obj = session.getAttribute("demo");
       if(obj!=null){
    	   ClassPO po = (ClassPO)obj;
       %>
       <%=po.getC_class() %>
       <%
       }
      %> 
      ${sessionScope.demo.c_class}
      ${sessionScope.demo["c_class"]}
      
      <%=session.getAttribute("test") %>
      ${!empyt?"空":sessionScope.test} 
      
      <%=request.getParameter("sname") %> 
      ${param.sname}
      
   <%--    <%
       String[] vals = request.getParameterValues("language");
      %>
      <%=vals[0] %>
      ${paramValues.language[0]}
      ${paramValues.language[1]}
      
      <%=request.getContextPath() %>
      ${pageContext.request.contextPath} --%>
      
                  昵称：${param.nickname}
                 城市：${param.city}
                  开发语言：
      ${paramValues.language[0]}
      ${paramValues.language[1]}
      ${paramValues.language[2]}
                                                                                                                                                                                                                                                                                                                                                                                                                                                                    
</body>
</html>