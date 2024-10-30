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
		
	<hr>
	
	<p><a href = "8_1">예제 8-1 (page 278)</a></p>
	<p><a href = "8_2">예제 8-2 (page 282)</a></p>
	<p><a href = "8_3">예제 8-3~4 (page 285~291)</a></p>	
	<p><a href = "8_5">예제 8-5 (page 296)</a></p>
		
	<hr>
	
	<p><a href = "9_1">예제 9-1 (page 318)</a></p>
	<p><a href = "9_2">예제 9-2 (page 329)</a></p>
	<p><a href = "9_3">예제 9-3 (page 333)</a></p>
	<p><a href = "9_4">예제 9-4 (page 336)</a></p>
	<p><a href = "9_5">예제 9-5 (page 339)</a></p>
			
	<hr>
	
	<p><a href = "10_1">예제 10-1 (page 364)</a></p>
	<p><a href = "10_1">예제 10-2 (page 366)</a></p>
		
	<hr>
	
	<p><a href = "11_1">예제 11-1 (page 386)</a></p>
	<p><a href = "11_2">예제 11-2 (page 388)</a></p>
	<p><a href = "11_3">예제 11-3 (page 389)</a></p>
	<p><a href = "11_4">예제 11-4 (page 393)</a></p>
	<p><a href = "11_4">예제 11-5 (page 397)</a></p>
	<p><a href = "11_6">예제 11-6 (page 400)</a></p>
			
	<hr>
	
	<p><a href = "12_1">예제 12-1 (page 423)</a></p>
	<p><a href = "12_2">예제 12-2 (page 426)</a></p>
	<p><a href = "12_3">예제 12-3 (page 430)</a></p>
			
	<hr>
	
	<p><a href = "13">로그인</a>
	<p><a href = "13_2">예제 13-1~3 (page 452~457)</a></p>
	<p><a href = "13_5">예제 13-5 (page 461)</a></p>
	<p><a href = "13_6">예제 13-6 (page 463)</a></p>
				
	<hr>
	
	<p><a href = "14_1">예제 14-1 (page 488)</a></p>
	<p><a href = "14_2">예제 14-2 (page 491)</a></p>
					
	<hr>
	
	<p><a href = "16_1">예제 16-1 (page 553)</a></p>
	<p><a href = "16_2">예제 16-2 (page 558)</a></p>
	<p><a href = "16_3">예제 16-3 (page 564)</a></p>
	<p><a href = "16_5">예제 16-5 (page 570)</a></p>
	<p><a href = "16_7">예제 16-7 (page 564)</a></p>
</body>
</html>