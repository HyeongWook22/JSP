<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
<!-- 정적리소스는 절대경로표시를 추천함 -->
<link href="/bookmarket_crudd/resources/css/bootstrap.min.css" rel="stylesheet">
<meta charset="UTF-8">
<title>Welcome</title>
</head>
<body>
<div class = "container py-4">
<%@ include file = "menu.jsp" %>
	
<%! 
	String greeting = "도서 쇼핑몰에 오신 것을 환영합니다";
	String tagline = "Welcome to Web Market!";
%>
	<div class = "p-5 mb-4 bg-body-tertiary rounded-3">
		<div class = "container-fluid py-5">
			<h1 class = "display-5 fw-bold"><%=greeting %></h1>
			<p class = "col-md-8 fs-4">BookMarket</p>
		</div>
	</div>
	
	<div class = "row align-tiems-md-stretch   text-center">
		<div class = "col-md-12">
			<div class = "h-100 p-5">
				<h3><%=tagline %></h3>
				<%
					Date day = new java.util.Date();
					String am_pm;
					int hour = day.getHours();
					int minute = day.getMinutes();
					int second = day.getSeconds();
					if (hour < 12)
					{
						am_pm = "AM";
					}
					else
					{
						am_pm = "PM";
					}
					
					if (hour == 0) 
					{
						hour = 12;
					}
					else if(hour > 12)
					{
						hour = hour - 12;
					}
					
					String CT = hour + ":" + minute + ":" + second + " " + am_pm;
					out.println("현재 접속 시각: " + CT + "\n");
				%>
			</div>
		</div>
	</div>
	
	<footer class = "pt-3 mt-4 text-body-secondary border-top">
		&copy; BookMarket
	</footer>
</div>
</body>
</html>