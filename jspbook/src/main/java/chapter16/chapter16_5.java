package chapter16;

import java.io.IOException;
import java.util.ArrayList;

import dao.member_repository;
import dto.member_dto;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/16_5")
public class chapter16_5 extends HttpServlet
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		member_repository mr = member_repository.getInstance();
		ArrayList<member_dto> arr = mr.Allmember();
		
		req.setAttribute("list", arr);
		
		RequestDispatcher ds = req.getRequestDispatcher("chapter16/exam16-5.jsp");
		ds.forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
	}

}
