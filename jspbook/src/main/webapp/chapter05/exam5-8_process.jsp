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
		String id = (String)request.getAttribute("id");
		String pw = (String)request.getAttribute("pw");
	%>
	
	<p> 아 이 디 :<% out.println(id); %>
	<p> 비밀번호 :<% out.println(pw); %>
</body>
</html>