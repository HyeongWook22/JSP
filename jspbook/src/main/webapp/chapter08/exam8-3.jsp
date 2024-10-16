<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form name="loginForm" id="loginForm" method="post" action="8_3">
		<p> 아 이 디 : <input type="text" name="id" id="id">
		<p> 비밀번호 : <input type="password" name="passwd" id="passwd">
		<p> 이 름 : <input type="text" name="name" id="name1">
		<p> <input type="button" value="전송" name="butt" id="butt">
	</form>
	
	<script type="text/javascript">
		console.log("dd");
		var submit = document.querySelector("#butt");
		submit.addEventListener("click", checkLogin);
		
		function checkLogin()
		{
			var form = document.querySelector("#loginForm");
			var id = document.querySelector("#id");
			var pw = document.querySelector("#passwd");		
			var name = document.querySelector("#name1");
			var idlen = document.querySelector("#id").value.length;
			var pwlen = document.querySelector("#passwd").value.length;
			
			//이름 유효성 검사
			if (!isNaN(name.value.substr(0, 1)))
			{
				alert("이름은 빈칸이나 숫자로 시작할 수 없습니다!");
				name.select();
				return;
			}
		
			
			//아이디 유효성 검사
			if (idlen < 4 || idlen > 12)
			{
				console.log(idlen);
				alert("이 아이디는 4~12자 이내로 입력 가능합니다!");
				id.select();
				return;
			}
			
			for (i=0; i<idlen; i++)
			{
				var ch = id.value.charAt(i);
				
				
				if ((ch<'a'||ch>'z') && (ch>'A'||ch<'Z') && (ch>'0'||ch<'9'))
				{
					alert("아이디는 영문 소문자만 입력가능 합니다!");
					id.select();
					return;
				}
			}
			
			//비밀번호 유효성 검사
			if (pwlen < 4)
			{
				console.log(pwlen);
				alert("비밀번호는 4자 이상으로 입력해야 합니다!");
				pw.select();
				return;
			}
			
			if (isNaN(pw.value))
			{
				alert("비밀번호는 숫자만 입력 가능합니다!");
				pw.select();
				return;
			}
			
			form.submit();
		}
	
	
	</script>
</body>
</html>