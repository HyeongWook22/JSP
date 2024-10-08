package controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// controller를 만드는 방법을 순서대로 확인해보자
// step 1 : HttpServelet 클래스를 상속
// step 2 : 오버라이딩을 실시 (doGet(), doPost())
// step 3 : 서블릿매핑

@WebServlet("/first")
public class cont1 extends HttpServlet
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("두겟실행됨");
		RequestDispatcher ds = req.getRequestDispatcher("first.jsp");
		ds.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("두포스트실행됨");
	}
	
}