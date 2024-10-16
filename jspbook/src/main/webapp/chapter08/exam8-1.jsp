<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form name = "loginForm">
		<p> 아 이 디 : <input type="text" name="id" id="id">
		<p> 비밀번호 : <input type="password" name="passwd" id="passwd">
		<p> <input type="submit" value="전송" id="submit">
	</form>
	
<script type="text/javascript">
	console.log("ss");
	var submit = document.querySelector("#submit");
	submit.addEventListener("click",checkForm);
	
	function checkForm()
	{
		console.log("dd");
		var id = document.querySelector("#id").value;
		var pw = document.querySelector("#passwd").value;
		console.log(id);
		console.log(pw);
		alert("아이디 :" + id + "\n 비밀번호 : " + pw);
	}
</script>
</body>
</html>