<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
  img {
    width:20%;
    height:20%;
  }
</style>
</head>
<body>
		<%
		  String name1= (String)request.getAttribute("name1");
		  String subject1=(String)request.getAttribute("subject1");
		  String file1=(String)request.getAttribute("file1");
		  String name2= (String)request.getAttribute("name2");
		  String subject2=(String)request.getAttribute("subject2");
		  String file2=(String)request.getAttribute("file2");
		  String name3= (String)request.getAttribute("name3");
		  String subject3=(String)request.getAttribute("subject3");
		  String file3=(String)request.getAttribute("file3");	
		%>
	<p>
	이름 : <%= name1%>
    제목 : <%= subject1%> 
    파일 : <%= file1%>  
    <img src="img/<%=file1 %>">
    
    <br>
    
    <p>
	이름 : <%= name2%> 
    제목 : <%= subject2%> 
    파일 : <%= file2%>  
    <img src="img/<%=file2 %>">
    
    <br>
    
    <p>
	이름 : <%= name3%> 
    제목 : <%= subject3%> 
    파일 : <%= file3%> 
    <img src="img/<%=file3 %>">
</body>
</html>