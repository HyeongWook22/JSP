package member_controller;

import java.io.IOException;
import java.util.Date;

import dao.MemberRepository;
import dto.member;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/member_login")
public class read_one_controller extends HttpServlet
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Member read_one_controller에 doget()에 도착");
		//전처리
		//모델이동
		//뷰이동
		RequestDispatcher rs = req.getRequestDispatcher("loginMember.jsp");
		rs.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		MemberRepository mr = MemberRepository.getMr();
		member mb = mr.getUser(id,password);
		if (mb != null) //dto가 존재하므로 회원이 맞다.
		{
			//세션 생성
			HttpSession session = request.getSession(true);
			session.setAttribute("member", mb);
		}
		else
		{
			resp.sendRedirect("member_login?error=1");
		}
		//뷰이동
		RequestDispatcher rs = request.getRequestDispatcher("resultMember.jsp?msg=2");
		rs.forward(request, resp);
	}

}
