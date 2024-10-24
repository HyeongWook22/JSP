package chapter14;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/14_1")
public class chapter14_1 extends HttpServlet
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher ds = req.getRequestDispatcher("chapter14/exam14-1.jsp");
		ds.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String pw = req.getParameter("passwd");
		
		if(id.equals("admin") && pw.equals("1234"))
		{
			Cookie cookie_id = new Cookie("userID", id);
			Cookie cookie_pw = new Cookie("userPW", pw);
			resp.addCookie(cookie_id);
			resp.addCookie(cookie_pw);
			
			req.setAttribute("id", id);
			req.setAttribute("pw", pw);
		}
		
		RequestDispatcher ds = req.getRequestDispatcher("chapter14/exam14-1_process.jsp");
		ds.forward(req, resp);
	}
	
}
