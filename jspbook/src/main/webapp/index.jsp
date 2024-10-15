<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP 실습</title>
</head>
<body>
	실습리스트
	<p><a href = "2_1">예제 2-1(page 65)</a></p>
	<p><a href = "2_2">예제 2-2(page 66)</a></p>
	<p><a href = "2_3">예제 2-3(page 67)</a></p>
	<p><a href = "2_4">예제 2-4(page 69)</a></p>
	<p><a href = "2_5">예제 2-5(page 70)</a></p>
	<p><a href = "2_6">예제 2-6(page 72)</a></p>
	<p><a href = "2_7">예제 2-7(page 72)</a></p>
	
	<hr>
	
	<p><a href = "3_1">예제 3-1(page 89)</a></p>
	<p><a href = "3_2">예제 3-2(page 90)</a></p>
	<p><a href = "3_3">예제 3-3(page 92)</a></p>
	<p><a href = "3_4">예제 3-4(page 92)</a></p>
	<p><a href = "3_6">예제 3-6(page 96)</a></p>
	<p><a href = "3_7">예제 3-7(page 98)</a></p>	
	<p><a href = "3_9">예제 3-9(page 104)</a></p>	
	<p><a href = "3_10">예제 3-10(page 105)</a></p>	
	<p><a href = "3_11">예제 3-11(page 108)</a></p>
	
	<hr>
	
	<p><a href = "4_1">예제 4-1(page 123)</a></p>
	<p><a href = "4_2">예제 4-2(page 128)</a></p>
	<p><a href = "4_3">예제 4-3(page 130)</a></p>
	<p><a href = "4_4">예제 4-4(page 132)</a></p>
	<p><a href = "4_5">예제 4-5(page 137)</a></p>
	<p><a href = "4_6">예제 4-6(page 138)</a></p>
	<p><a href = "4_7">예제 4-7(page 139)</a></p>
	<p><a href = "4_8">예제 4-8(page 140)</a></p>
	<p><a href = "4_9">예제 4-9(page 144)</a></p>
	<p><a href = "4_10">예제 4-10(page 145)</a></p>
	<p><a href = "4_11">예제 4-11 (page 146)</a></p>
	
	<form action = "4_0" method = "get">
		<p><input type = "text" name = "id" />
		<p><input type = "text" name = "name" />
		<p><input type = "submit" value = "전송" />
	</form>
	
	<%
		String id = "admin";
		String name = "김";
	%>
	<p><a href = "4_0?id=${id}&name=<%=name%>">예제  4-0</a></p>
	
	<hr>
	
	<form action = "5_1" method = "post">
	예제 5-1(page 168)
	<p>아 이 디 : <input type = "text" name = "id">
	<p>비밀번호 : <input type = "text" name = "passwd">
	<p> <input type = "submit" value = "전송">
	</form>
	
	<p><a href = "5_2">예제 5-2 (page 171)</a></p>
	<p><a href = "5_3">예제 5-3 (page 173)</a></p>	
	
	<form action = "5_4" method = "post">
	예제 5-4(page 178)
	<p>아 이 디 : <input type = "text" name = "id">
	<p>비밀번호 : <input type = "text" name = "passwd">
	<p> <input type = "submit" value = "전송">
	</form>
	
	<p><a href = "5_5">예제 5-5 (page 181)</a></p>
	<p><a href = "5_7">예제 5-7 (page 185)</a></p>
	<p><a href = "5_8">예제 5-8 (page 186)</a></p>
	
	<hr>
	
	<p><a href = "6_1">예제 6-1~5 (page 205~216)</a></p>
	
	<hr>
	
	<p><a href = "7_1">예제 7-1 (page 243)</a></p>
	<p><a href = "7_2">예제 7-2 (page 247)</a></p>
	<p><a href = "7_3">예제 7-3 (page 254)</a></p>
	
		
</body>
</html>