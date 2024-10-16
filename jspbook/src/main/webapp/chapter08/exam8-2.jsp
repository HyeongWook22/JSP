<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- 버튼 id를 submit으로 주면 안됨 -->
	<form name="loginForm" id="loginForm" method="post" action="8_2">
		<p> 아 이 디 : <input type="text" name="id" id="id">
		<p> 비밀번호 : <input type="password" name="passwd" id="passwd">
		<p> <input type="button" value="전송" name = "butt" id="butt">
	</form>
	
	<script>
		console.log("dd");
		var submit = document.querySelector("#butt");
		submit.addEventListener("click", checkLogin);
		
		function checkLogin() 
		{
			var loginform = document.querySelector("#loginForm");		
			var id = document.querySelector("#id");
			var pw = document.querySelector("#passwd");
			
			
			if (id.value == "")
			{
				console.log(id);
				alert("아이디를 입력해주세요.");
				id.focus();
				return false;
			}
			else if (pw.value == "")
			{
				console.log(pw);
				alert("비밀번호를 입력해주세요.");
				pw.focus();
				return false;
			}
			loginform.submit();			
		}
	</script>
	</body>
</html>