package book_controller;

import java.io.IOException;

import dao.BookRepository;
import dto.Book;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/book")
public class read_one_controller extends HttpServlet
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("read_one_controller의 doget에 도착");
		//전처리
		String bookId = req.getParameter("id");
		
		//모델이동
		BookRepository br = BookRepository.getInstance();
		Book bk = br.getBookById(bookId);
		
		//뷰이동
		req.setAttribute("dto", bk);
		
		RequestDispatcher rs = req.getRequestDispatcher("book.jsp");
		rs.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

}
