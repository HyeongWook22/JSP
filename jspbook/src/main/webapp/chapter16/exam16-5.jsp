<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="dto.member_dto" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	ArrayList<member_dto> arr = (ArrayList<member_dto>) request.getAttribute("list");
%>
	<table width="300" border="1">
		<tr>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이름</th>
		</tr>
		
		<%
			for(int i=0; i<arr.size(); i++)
			{
				member_dto dto = arr.get(i);
				String id = dto.getId();
				String pw = dto.getPw();
				String name = dto.getName();
		%>
		<tr>
			<td><%=id %></td>
			<td><%=pw %></td>
			<td><%=name %></td>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>