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
		request.setCharacterEncoding("UTF-8");
		
		String id = (String)request.getAttribute("id");
		String pw = (String)request.getAttribute("pw");
		String name = (String)request.getAttribute("name");
		String phone1 = (String)request.getAttribute("phone1");
		String phone2 = (String)request.getAttribute("phone2");
		String phone3 = (String)request.getAttribute("phone3");
 		String email = (String)request.getAttribute("email");
	%>
	<p>아이디 : <%= id %>
	<p>비밀번호 : <%= pw %>
	<P>이름 : <%= name %>
	<P>연락처 : <%= phone1 %>-<%= phone2 %>-<%= phone3 %>
	<p>이메일 : <%= email %>
</body>
</html>