package book_controller;

import java.io.IOException;

import dao.BookRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/deleteBook")
public class delete_controller extends HttpServlet
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("delete_controller에 도착");
		//전처리
		String id = req.getParameter("id");
		//모델이동
		BookRepository br = BookRepository.getInstance();
		br.delBook(id);
		//뷰이동
		resp.sendRedirect("books");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

}
