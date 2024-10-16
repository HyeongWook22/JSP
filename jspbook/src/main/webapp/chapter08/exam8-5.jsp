<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form name="loginForm" id="loginForm" method="post" action="8_5">
		<p> 아 이 디 : <input type="text" name="id" id="id">
		<p> 비밀번호 : <input type="password" name="passwd" id="passwd">
		<p> 이 름 : <input type="text" name="name" id="name1">
		<p> 연락처 : <select name="phone1" id="phone1">
			<option value="010">010</option>
			<option value="011">011</option>
			<option value="016">016</option>
			<option value="017">017</option>
			<option value="019">019</option>
		</select>
		- <input type="text" maxlength="4" size="4" name="phone2" id ="phone2">
		- <input type="text" maxlength="4" size="4" name="phone3" id ="phone3">
		<p> 이메일 : <input type = "email" name="email" id="email">
		<p> <input type="button" value="가입하기" name="butt" id="butt">
	</form>
	
	<script type="text/javascript">
		var submit = document.querySelector("#butt");
		submit.addEventListener("click", checkMember)
	
		function checkMember()
		{
			var regExpId = /^[a-z|A-Z|ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/;
			var regExpName = /^[가-힣]*$/;
			var regExpPasswd = /^[0-9]*$/;
			var regExpPhone = /^\d{3}-\d{3,4}-\d{4}$/;
			var regExpEmail = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
			
			var form = document.querySelector("#loginForm");
			var id = document.querySelector("#id").value;
			var pw = document.querySelector("#passwd").value;
			var phone = document.querySelector("#phone1").value + "-" + form.phone2.value + "-" + form.phone3.value;
			var email = document.querySelector("#email").value;
		
			if (!regExpId.test(id))
			{
				alert("아이디는 문자로 시작해주세요!");
				id.select();
				return;
			}
			
			if (!regExpName.test(name))
			{
				alert("이름은 한글만 입력해주세요!");
				name.select();
				return;
			}
			
			if (!regExpPasswd.test(pw))
			{
				alert("비밀번호는 숫자만 입력해주세요!");
				passwd.select();
				return;
			}
			
			if (!regExpPhone.test(phone))
			{
				alert("연락처 입력을 확인해주세요!");
				phone.select();
				return;
			}
			
			if (!regExpEmail.test(email))
			{
				alert("이메일 입력을 확인해주세요!");
				email.select();
				return;
			}
			
			form.submit();
			
		}
	</script>
</body>
</html>