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
		String id = (String) request.getAttribute("id");
		String pw = (String) request.getAttribute("pw");
	
		out.println(id + "님 환영합니다");
		out.println("비밀번호는" + pw + "입니다.");
	%>
</body>
</html>