<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "dto.Book" %>
<%@ page import = "dao.BookRepository" %>
<%@ page errorPage = "exceptionNoBookId.jsp" %>
<%@ page session="false" %>
<% 
	System.out.println("book.jsp에 도착");
	Book bk = (Book)request.getAttribute("dto");
%>
<jsp:useBean id = "bookDAO" class = "dao.BookRepository" scope = "session" />

<!DOCTYPE html>
<html>
<head>
<link rel = "stylesheet" href = "./resources/css/bootstrap.min.css" />

<title>도서 정보</title>
<script type="text/javascript">
	function addToCart()
	{
		if (confirm("도서를 장바구니에 추가하시겠습니까?"))
		{
			document.addForm.submit();	
		}
		else
		{
			document.addForm.reset();	
		}
	}
</script>
</head>
<body>
<div class = "container py-4">
	<%@ include file = "menu.jsp" %>
	
	<div class = "p-5 mb-4 bg-body-tertiary rounded-3">
		<div class = "container-fluid py-5">
			<h1 class = "display-5 fw-bold">도서정보</h1>
			<p class = "col-md-8 fs-4">BookInfo</p>
		</div>
	</div>
	
	<div class = "row align-items-md-stretch">
		<div class = "col-md-5">
			<img src ="./resources/images/<%=bk.getB_fileName()%>" style = "width : 70%">
		</div>
		<div class = "col-md=12">
			<h3><b><%=bk.getB_name() %></b></h3>
			<p> <%=bk.getB_description() %>
			<p> <b>도서코드 :</b><span class = "badge text-bg-danger"><%=bk.getB_id() %></span>
			<p> <b>저자</b> : <%=bk.getB_author() %>
			<p> <b>출판사</b> : <%=bk.getB_publisher() %>
			<p> <b>출판일</b> : <%=bk.getB_releaseDate() %>
			<p> <b>분류</b> : <%=bk.getB_category() %>
			<p> <b>재고수</b> : <%=bk.getB_unitsInStock() %>
			<h4><%=bk.getB_unitPrice() %>원</h4>
			<p>	
			<form name="addForm" action="./addCart.jsp?id=<%=bk.getB_id() %>" method="post"> 
				<a href = "#" class = "btn btn-info" onclick="addToCart()">도서주문 &raquo;</a>
				<a href = "./cart.jsp" class="btn btn-warning">장바구니 &raquo;</a>
				<a href = "./books.jsp" class = "btn btn-secondary">도서목록 &raquo;</a>
			</form>
		</div>
	</div>
	<jsp:include page = "footer.jsp" />	
</div>
</body>
</html>