package chapter12;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/12_2f")
public class chapter12_2_1 extends HttpServlet
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String pw = req.getParameter("passwd");
		
		req.setAttribute("id", id);
		req.setAttribute("pw", pw);
		
		RequestDispatcher ds = req.getRequestDispatcher("chapter12/filter02_process.jsp");
		ds.forward(req, resp);
	}

}
