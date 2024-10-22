package chapter13;

import java.io.IOException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/13_5")
public class exam13_5 extends HttpServlet
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher ds = req.getRequestDispatcher("chapter13/exam13-5.jsp");
		ds.forward(req, resp);	
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
			System.out.println("세션 설정이 성공했습니다<br>");
			System.out.println(id + "님 환영합니다");
		}
		else
		{
			System.out.println("세션 설정이 실패했습니다.");
		}
		
		//모델
		
		//이동
		RequestDispatcher ds = req.getRequestDispatcher("chapter13/exam13-5_printer3.jsp");
		ds.forward(req, resp);	
	}

}
