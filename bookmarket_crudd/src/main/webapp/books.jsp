<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.ArrayList" %>
<%@ page import = "dto.Book" %>
<%@ page import = "dao.BookRepository" %>
<%@ page import = "java.sql.*" %>
<%@ page session="false" %>
<% System.out.println("books.jsp 로 도착"); %>
<jsp:useBean id = "bookDAO" class = "dao.BookRepository" scope = "session" />
<!DOCTYPE html>
<html>
<head>
<link rel = "stylesheet" href = "./resources/css/bootstrap.min.css" />
<meta charset="UTF-8">
<title>도서 목록</title>
</head>
<body>
<div class = "container py-4">
	<%@ include file = "menu.jsp" %>
	<%
		ArrayList<Book> arr = (ArrayList<Book>)request.getAttribute("list");
		if(arr == null)
		{
			System.out.println("리스트 값을 전달받지 못했음");
		}
	%>
	
	<div class = "p-5 mb-4 bg-body-teritary rounded-3">
		<div class = "container-fluid py-5"> 
			<h1 class = "display-5 fw-bold">도서목록</h1>
			<p class = "col-md-8 fs04">BookList</p>
		</div>	
	</div>
	<div class = "row align-items-md-stretch   text-center">
	<%
		for (int i=0; i<arr.size(); i++)
		{
			Book bk = arr.get(i);
			
	%>
		<div class = "col-md-4">
			<div class = "h-100 p-2">
				<img src ="resources/images/<%=bk.getB_fileName() %>" style = "width : 250px; height : 350px" />
				<h5><b><%= bk.getB_name() %></b></h5>
				<p> <%= bk.getB_author() %>
				<br><%= bk.getB_publisher() %> | <%=bk.getB_releaseDate() %>
				<p> <%= bk.getB_description() %>
				<p> <%= bk.getB_unitPrice() %>원
				<P> <a href = book?id=<%=bk.getB_id()%> class = "btn btn-secondary" role = "button">상세 정보 &raquo;></a>
			</div>
		</div>
		<%
			}
		%>
	</div>
	<%@ include file = "footer.jsp" %>
</div>
</body>
</html>