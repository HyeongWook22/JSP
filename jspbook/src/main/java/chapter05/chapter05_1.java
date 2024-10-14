package chapter05;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/5_1")
public class chapter05_1 extends HttpServlet
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String useid = req.getParameter("id");
		String password = req.getParameter("passwd");
		
		System.out.println("도착함");
				
		req.setAttribute("useid", useid);
		req.setAttribute("password", password);
		
		RequestDispatcher ds = req.getRequestDispatcher("chapter05/exam5-1.jsp");
		ds.forward(req, resp);
	}

}
