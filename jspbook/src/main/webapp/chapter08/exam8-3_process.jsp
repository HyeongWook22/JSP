<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	  String id= (String)request.getAttribute("id");
	  String pw= (String)request.getAttribute("pw");
	  String name= (String)request.getAttribute("name");
	%>
	
	<p>아이디 : <%= id %>
	<p>비밀번호 : <%= pw %>
	<P>이름 : <%= name %>
</body>
</html>