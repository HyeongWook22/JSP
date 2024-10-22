package chapter11;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/11_4")
public class chapter11_4 extends HttpServlet
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher ds = req.getRequestDispatcher("chapter11/exam11-4.jsp");
		ds.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String num1 = req.getParameter("num1");
		String num2 = req.getParameter("num2");
		
		System.out.println(num1);
		System.out.println(num2);
		
		req.setAttribute("num1", num1);
		req.setAttribute("num2", num2);
		
		RequestDispatcher ds = req.getRequestDispatcher("chapter11/exam11-4_process.jsp");
		ds.forward(req, resp);
	}

}
