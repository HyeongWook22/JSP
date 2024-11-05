<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="dto.member" %>
<%@ page session="false" %>
<%
	String sessionId=null;
	HttpSession session = null;
	session = request.getSession(false);
	System.out.println(session);
	if(session != null){
	    member mb = (member) session.getAttribute("member");
	    if(mb != null){
	        sessionId = mb.getName();   
	    }
}
%>
<header class="pb-3 mb-4 border-bottom">
  <div class="container ">  
    <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">   
      <a href="./welcome.jsp" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-dark text-decoration-none">
       <svg  width="40" height="32" fill="currentColor" class="bi bi-house-fill" viewBox="0 0 16 16">
  			<path d="M8.707 1.5a1 1 0 0 0-1.414 0L.646 8.146a.5.5 0 0 0 .708.708L8 2.207l6.646 6.647a.5.5 0 0 0 .708-.708L13 5.793V2.5a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5v1.293L8.707 1.5Z"/>
  			<path d="m8 3.293 6 6V13.5a1.5 1.5 0 0 1-1.5 1.5h-9A1.5 1.5 0 0 1 2 13.5V9.293l6-6Z"/>
				</svg> 
        <span class="fs-4">Home</span>
      </a>

      <ul class="nav nav-pills">
     <%
				if(sessionId==null)
				{	
				%>
					<li class="nav-item"><a class="nav-link" href="member_login">로그인 </a></li>
					<li class="nav-item"><a class="nav-link" href="member_add">회원 가입</a></li>

				<%
				}
				else
				{ 
				%>
					<li style="padding-top: 7px;">[<%=sessionId%>님]</li>
					<li class="nav-item"><a class="nav-link" href="member_logout">로그아웃 </a></li>
					<li class="nav-item"><a class="nav-link" href="member_update">회원 수정</a></li>
				<%
				}
				%>
        <li class="nav-item"><a href = "books" class="nav-link" >상품 목록</a></li>
        <li class ="nav-item"><a href = "addBook" class = "nav-link"  >상품 등록</a></li>
        <li class ="nav-item"><a href = "editBook?edit=update" class = "nav-link"  >상품 수정</a></li>
        <li class ="nav-item"><a href = "editBook?edit=delete" class = "nav-link"  >상품 삭제</a></li>
        <li class ="nav-item"><a href = "BoardListAction?pageNum=1" class = "nav-link"  >게시판</a></li>
      </ul> 
    </div>
</div>
</header>
