<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	request.setCharacterEncoding("utf-8");
	String userid = (String)request.getAttribute("useid");
	String password = (String)request.getAttribute("password");
%>    

	<p> 아이디 : <%=userid %>
	<p> 비밀번호 : <%=password %>
</body>
</html>