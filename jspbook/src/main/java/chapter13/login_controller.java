package chapter13;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/13")
public class login_controller extends HttpServlet
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("클라이언트 요청에 의해 컨트롤러 도착");
		RequestDispatcher ds = req.getRequestDispatcher("chapter13/login.jsp");
		ds.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//전처리
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		
		System.out.println("전처리 과정으로 넘어옴");
		
		if(id.equals("admin")&&pw.equals("1234"))
		{
			// getSession(true)혹은 getSession()은 현재 세션 객체가 있으면 그냥 쓰고 없으면 새로 생성한다.
			// getSession(false)는 현재 세션 객체가 있으면 그냥쓰고 없으면 null을 반납한다.
			HttpSession session = req.getSession(true); //세션 생성
			session.setAttribute("id", id);
			session.setAttribute("pw", pw);
			
			RequestDispatcher ds = req.getRequestDispatcher("chapter13/printer.jsp");
			ds.forward(req, resp);	
			
		}
		else
		{
			
		}
		
		//모델
		
		//이동
	}

}
