package chapter11;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/11_3")
public class chapter11_3 extends HttpServlet
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher ds = req.getRequestDispatcher("chapter11/exam11-3.jsp");
		ds.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String num1 = req.getParameter("num1");
		String num2 = req.getParameter("num2");
		
		System.out.println(num1);
		System.out.println(num2);
		
		try 
		{
			int a = Integer.parseInt(num1);
			int b = Integer.parseInt(num2);
			int c = a / b;
		
			System.out.println(c);
		
			req.setAttribute("c", c);
		
			RequestDispatcher ds = req.getRequestDispatcher("chapter11/exam11-3_process.jsp");
			ds.forward(req, resp);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			RequestDispatcher ds = req.getRequestDispatcher("chapter11/exam11-3_error.jsp");
			ds.forward(req, resp);
		}

	}

}
