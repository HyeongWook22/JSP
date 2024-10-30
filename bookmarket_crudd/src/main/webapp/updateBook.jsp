<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="dto.Book" %>
<%
	Book bk = (Book)request.getAttribute("dto");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel = "stylesheet" href = "./resources/css/bootstrap.min.css" />
<title>도서 수정</title>
</head>
<body>
<div class="container py-4">
	<%@ include file = "menu.jsp" %>
	
	<div class="p-5 mb-4 bg-body-tertiary rounded-3">
		<div class="container-fluid py-5">
			<h1 class="display-5 fw-bold">도서 수정</h1>
			<p class="col-md-8 fs-4">Book Updating</p>
		</div>
	</div>
	

	<div class="row align-items-md-stretch">
		<div class="col-md-5">
			<img src ="resources/images/<%=bk.getB_fileName() %>" alt="image" style = "width:100%" />			
		</div>
		<div class="col-md-7">
			<form name ="newBook" action="updateBook" method="post" enctype="multipart/form-data">
			<div class="mb-3 row">
				<label class="col-sm-2">도서코드</label>
				<div class="col-sm-5">
					<input type="text" name="bookId" id="bookId" class="form-control" value='<%= bk.getB_id() %>' readonly>
				</div>
			</div>
			<div class="mb-3 row">
				<label class="col-sm-2">도서명</label>
				<div class="col-sm-5">
					<input type="text" name="name" id="name" class="form-control" value='<%= bk.getB_name()%>'>
				</div>
			</div>
			<div class="mb-3 row">
				<label class="col-sm-2">가격</label>
				<div class="col-sm-5">
					<input type="text" name="unitPrice" id="unitPrice" class="form-control" value='<%= bk.getB_unitPrice()%>'>
				</div>
			</div>
			<div class="mb-3 row">
				<label class="col-sm-2">저자</label>
				<div class="col-sm-5">
					<input type="text" name="author" class="form-control" value='<%= bk.getB_author()%>'>
				</div>
			</div>
			<div class="mb-3 row">
				<label class="col-sm-2">출판사</label>
				<div class="col-sm-5">
					<input type="text" name="publisher" class="form-control" value='<%= bk.getB_publisher()%>'>
				</div>
			</div>
			<div class="mb-3 row">
				<label class="col-sm-2">출판일</label>
				<div class="col-sm-5">
					<input type="text" name="releaseDate" class="form-control" value='<%= bk.getB_releaseDate()%>'>
				</div>
			</div>
			<div class="mb-3 row">
				<label class="col-sm-2">상세정보</label>
				<div class="col-sm-5">
					<textarea name="description" id="description" cols="50" rows="2" class="form-control" placeholder ="100자 이상 적어주세요" >
					<%= bk.getB_description()%></textarea>
				</div>
			</div>
			<div class="mb-3 row">
				<label class="col-sm-2">분류</label>
				<div class="col-sm-5">
					<input type="text" name="category" class="form-control" value='<%= bk.getB_category()%>'>
				</div>
			</div>
			<div class="mb-3 row">
				<label class="col-sm-2">재고수</label>
				<div class="col-sm-5">
					<input type="text" name="unitsInStock" id="unitsInStock" class="form-control" value='<%= bk.getB_unitsInStock()%>'>
				</div>
			</div>
			<div class="mb-3 row">
				<label class="col-sm-2">상태</label>
				<div class="col-sm-8">
					<% String status = bk.getB_condition(); %>
					<input type="radio" name="condition" value="new" <%if(status.equals("new")){out.println("checked");} %>>신규도서
					<input type="radio" name="condition" value="old" <%if(status.equals("old")){out.println("checked");} %>>중고도서
					<input type="radio" name="condition" value="eBook" <%if(status.equals("eBook")){out.println("checked");} %>>E-Book
				</div>
			</div>
			<div class="mb-3 row">
				<label class="col-sm-2">이미지</label>
				<div class="col-sm-8">
					<input type="file" name="bookImage" class="form-control">
				</div>
			</div>
			<div class="mb-3 row">
				<div class="col-sm-offset-2 col-sm-10">
					<input type="submit" class="btn btn-primary" value="등록">
				</div>
			</div>
			</form>
		</div>
	</div>
		<jsp:include page="footer.jsp"></jsp:include>
</div>
</body>
</html>