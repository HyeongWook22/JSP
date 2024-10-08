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
		for(int i = 0; i<10; i++)
		{
			if(i % 2 == 0)
				out.println(i + "<br>");
		}
	%>
	<br>
	<a href = "index.jsp">홈으로 이동</a>
</body>
</html>