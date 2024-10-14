package chapter06;

import java.io.IOException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/6_1_1")
public class chapter06_1_controller extends HttpServlet
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String userid = req.getParameter("id");
		String passwd = req.getParameter("passwd");
		String username = req.getParameter("name");
		String phonenumber1 = req.getParameter("phone1");
		String phonenumber2 = req.getParameter("phone2");
		String phonenumber3 = req.getParameter("phone3");
		String usersex = req.getParameter("sex");
		String[] hobby = req.getParameterValues("hobby");
		
		req.setAttribute("id", userid);
		req.setAttribute("pw", passwd);
		req.setAttribute("name", username);
		req.setAttribute("number1", phonenumber1);
		req.setAttribute("number2", phonenumber2);
		req.setAttribute("number3", phonenumber3);
		req.setAttribute("sex", usersex);		
		req.setAttribute("hobby", hobby);

			
		RequestDispatcher ds = req.getRequestDispatcher("chapter06/exam6-1_process.jsp");
		ds.forward(req, resp);
	}
	
}
